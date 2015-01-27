import java.lang.ProcessBuilder;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.StringBuffer;

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

		for (line = read.readLine(); line != null; line = read.readLine())
		{
			xmlBuf.append(line);
		}

		//TODO close BufferedReader/File
		
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
	 * Construct an abstract file, which respresents the folder to which the
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
	 * Private constructor is private, because "sneaky-sneaky"!
	 */
	private RegressionHelpers ()
	{}
}
