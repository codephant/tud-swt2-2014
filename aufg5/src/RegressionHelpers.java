import java.io.File;
import java.lang.ProcessBuilder;

public final class RegressionHelpers
{
	public static final String J2WsdlClass = "org.apache.axis.wsdl.Java2WSDL";

	public static final String LocationBase = "http://www.example.org/de/tu-dresden/inf/swt/2/ws2014/regtest";

	public static void convert2WsdlWithLib (String className, String libVer, String fileName)
		throws java.lang.InterruptedException, java.io.IOException
	{
		ProcessBuilder pb = new ProcessBuilder();
		String wsdlFile = getWsdlFilePath(className, libVer, fileName);

		// Make sure the parent directory exists
		new File(wsdlFile).getParentFile().mkdirs();

		String[] cmd = new String[]
			{ "java"
			, "-cp", String.format("%s:lib_%s/*",
				java.lang.System.getProperty("java.class.path"), libVer)
			, J2WsdlClass
			, "-n", String.format("%s/ns", LocationBase)
			, "-l", String.format("%s/%s", LocationBase, className)
			, "-o", wsdlFile
			, className
			};

		pb.command(cmd);
		pb.start().waitFor();
	}

	public static String getWsdlFilePath (String className, String libVer, String fileName)
	{
		return String.format("wsdl/%s/%s/%s", className, libVer, fileName);
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
