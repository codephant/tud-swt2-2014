import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;

public class J2WsdlRegrTest
{
	@BeforeClass
	public static void prepareWsdlDirs ()
	{
		RegressionHelpers.prepareWsdlDir();
	}

	@Test
	public void filesHaveSameName ()
		throws java.lang.InterruptedException, java.io.IOException
	{
		final String Class = "NoMethod";
		final String FileName = String.format("%s.xml", Class);
		RegressionHelpers.convert2WsdlWithLib(Class, "old", FileName);
		RegressionHelpers.convert2WsdlWithLib(Class, "new", FileName);
		File oldWsdlDir = new File(
			RegressionHelpers.getWsdlFilePath(Class, "old", FileName)).getParentFile();
		File newWsdlDir = new File(
			RegressionHelpers.getWsdlFilePath(Class, "new", FileName)).getParentFile();
		String newFileName = oldWsdlDir.list()[0];
		String oldFileName = newWsdlDir.list()[0];

		assertEquals("Generated files have the same name",
			oldFileName, newFileName);
	}

	@Test
	public void sameNoMethodXML ()
	{
	}
}
