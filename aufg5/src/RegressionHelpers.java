import static org.junit.Assert.fail;
import static java.lang.String.format;
import java.lang.ProcessBuilder;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.StringBuffer;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.DetailedDiff;
import org.custommonkey.xmlunit.Difference;
import org.custommonkey.xmlunit.XMLUnit;
import org.custommonkey.xmlunit.NodeDetail;

/**
 * Rather than an actual class, this is a namespace which holds various helper
 * functions needed for regression testing of the Apache Axis libraries'
 * Java2WSDL module.
 */
public final class RegressionHelpers
{
	/**
	 * Name of the conversion main-class in axis.
	 */
	public static final String J2WsdlClass = "org.apache.axis.wsdl.Java2WSDL";

	/**
	 * Fictional base URI for all WebService related URIs.
	 */
	public static final String LocationBase = "http://www.example.org/de/tu-dresden/inf/swt/2/ws2014/regtest";

	/**
	 * Prepare XMLUnit for the use of asserts in this Class.
	 */
	public static void setupXMLUnit ()
	{
		XMLUnit.setIgnoreWhitespace(true); 
		XMLUnit.setNormalizeWhitespace(true); 
		XMLUnit.setIgnoreComments(true);
	}

	/**
	 * Custom assertion, that checks via XMLUnit, whether two XML Strings are
	 * equal and if not fails with a message listing all differences.
	 */
	public static void assertXMLSimilar (String msg, String control, String test)
		throws java.io.IOException, org.xml.sax.SAXException
	{
		NodeDetail ctrlND, testND;
		DetailedDiff diff = new DetailedDiff(new Diff(control, test));
		StringBuilder failMsg = new StringBuilder();

		if (!diff.similar())
		{
			failMsg.append(format("%s XML differs in:\n", msg));
			for (Difference d : (java.util.List<Difference>)diff.getAllDifferences())
			{
				ctrlND = d.getControlNodeDetail();
				testND = d.getTestNodeDetail();
				failMsg.append(format(". Different %s (%s -> %s)\n"
					, d.getDescription()
					, ctrlND.getXpathLocation()
					, testND.getXpathLocation()
					));
				failMsg.append(format("\texpected: %s\n", ctrlND.getValue()));
				failMsg.append(format("\t   found: %s\n", testND.getValue()));
			}
			fail(failMsg.toString());
		}
	}

	/**
	 * Convert a given compiled Java class into WSDL and load the WSDL file's
	 * content as a String. Although it expects needs a file name. It will not
	 * load the file with this name, but the first file in the directory the WSDL
	 * file is written to. This accounts for the fact, that file names might be
	 * corrupted by the new version.
	 */
	public static String convertWithLibAndLoadXml (String className, String libVer, String fileName)
		throws java.lang.InterruptedException, java.io.IOException, org.xml.sax.SAXException
	{
		convert2WsdlWithLib(className, libVer, fileName);
		return loadXmlString(getWsdlDir(className, libVer).listFiles()[0]);
	}
	
	/**
	 * Fetch the contents of a file. It does not verify the content to be XML,
	 * but rather returns it unchecked.
	 * @todo Maybe the name should be changed to "loadString" since it doesn't check.
	 */
	public static String loadXmlString (File xmlFile)
		throws java.io.IOException, org.xml.sax.SAXException
	{
		StringBuffer xmlBuf = new StringBuffer();
		BufferedReader read = new BufferedReader(new FileReader(xmlFile));
		String line;

		line = read.readLine();
		while(line != null){
			xmlBuf.append(line);
			line = read.readLine();
		}

		read.close();
		
		return xmlBuf.toString();
	}

	/**
	 * Create a WSDL file from a compiled Java class or interface with the
	 * axis library version "libVer" into the file named "fileName".
	 * "libVer" will influence the generation of the new classpath. All files
	 * from the folder by the name of "lib_<libVer>/*" will be added to the
	 * classpath of the subprocess.
	 */
	public static void convert2WsdlWithLib (String className, String libVer, String fileName)
		throws java.lang.InterruptedException, java.io.IOException
	{
		ProcessBuilder pb = new ProcessBuilder();
		File wsdlFile = getWsdlFile(className, libVer, fileName);

		// Make sure the parent directory exists
		wsdlFile.getParentFile().mkdirs();

		String[] cmd = new String[]
			{ "java"
			, "-cp", String.format("%s:lib_%s/*",
				java.lang.System.getProperty("java.class.path"), libVer)
			, J2WsdlClass
			, "-n", String.format("%s/ns", LocationBase)
			, "-l", String.format("%s/%s", LocationBase, className)
			, "-o", wsdlFile.getPath()
			, className
			};

		pb.command(cmd);
		pb.start().waitFor();
	}

	/**
	 * Construct an abstract file, which respresents the directory to which the
	 * WSDL files for a certain class and library version should be written.
	 * "libVer" can be either String("old") or String("new")
	 */
	public static File getWsdlDir (String className, String libVer)
	{
		return new File(String.format("wsdl/%s/%s", className, libVer));
	}

	/**
	 * Construct an abstract file, which represents the file to which the WSDL
	 * xml for a certain class and library version should be written. It uses
	 * getWsdlDir() to get the directory component of the file path.
	 */
	public static File getWsdlFile (String className, String libVer, String fileName)
	{
		return new File(String.format("%s/%s",
			getWsdlDir(className, libVer).getPath(), fileName));
	}

	/**
	 * Ensure that the "wsdl" directory is present and empty. To "wsdl" or
	 * sub-directories thereof all WSDL files needed for the test are generated.
	 * If the directory exists, all its content is deleted, leaving the
	 * directory empty. If it doesn't exist yet, it is created, resulting in an
	 * empty directory. It the file exists and is no directory it is deleted and
	 * newly created as a directory.
	 */
	public static void prepareWsdlDir ()
	{
		File wsdlDir = new File("wsdl");

		if (wsdlDir.exists())
		{
			if (!wsdlDir.isDirectory())
			{
				wsdlDir.delete();
				wsdlDir.mkdirs();
			}
			else
			{
				clearDir(wsdlDir);
			}
		}
		else
		{
			wsdlDir.mkdirs();
		}
	}

	/**
	 * Delete all files and directories of a certain directory.
	 */
	public static void clearDir(File dir)
	{
		for (File f : dir.listFiles())
		{
			f.delete();
		}
	}

	/**
	 * Private constructor is private, because "sneaky-sneaky" -- but honestly,
	 * this is a function pseudo-namespace and not a class.
	 */
	private RegressionHelpers ()
	{}
}
