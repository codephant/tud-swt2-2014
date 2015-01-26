import java.lang.ProcessBuilder;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.StringBuffer;

public final class RegressionHelpers
{
	public static final String J2WsdlClass = "org.apache.axis.wsdl.Java2WSDL";

	public static final String LocationBase = "http://www.example.org/de/tu-dresden/inf/swt/2/ws2014/regtest";

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
		
		return xmlBuf.toString();
	}

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

	public static File getWsdlDir (String className, String libVer)
	{
		return new File(String.format("wsdl/%s/%s", className, libVer));
	}

	public static File getWsdlFile (String className, String libVer, String fileName)
	{
		return new File(String.format("%s/%s",
			getWsdlDir(className, libVer).getPath(), fileName));
	}

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

	public static void clearDir(File dir)
	{
		for (File f : dir.listFiles())
		{
			f.delete();
		}
	}

	private RegressionHelpers ()
	{}
}
