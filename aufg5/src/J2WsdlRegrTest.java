import static org.junit.Assert.*;
import static org.custommonkey.xmlunit.XMLAssert.*;

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

	//@Test
	//public void filesHaveNoExtName ()
		//throws java.lang.InterruptedException, java.io.IOException
	//{
		//final String Class = "NoMethod";
		//final String FileName = "xml";
		//RegressionHelpers.convert2WsdlWithLib(Class, "old", FileName);
		//RegressionHelpers.convert2WsdlWithLib(Class, "new", FileName);
		//File oldWsdlDir = RegressionHelpers.getWsdlDir(Class, "old");
		//File newWsdlDir = RegressionHelpers.getWsdlDir(Class, "new");
		//String newFileName = oldWsdlDir.list()[0];
		//String oldFileName = newWsdlDir.list()[0];
//
		//assertEquals("Generate files with no extension",
			//oldFileName, newFileName);
	//}

	@Test
	public void filesHaveSameName ()
		throws java.lang.InterruptedException, java.io.IOException
	{
		final String Class = "NoMethod";
		final String FileName = String.format("%s.xml", Class);
		RegressionHelpers.convert2WsdlWithLib(Class, "old", FileName);
		RegressionHelpers.convert2WsdlWithLib(Class, "new", FileName);
		File oldWsdlDir = RegressionHelpers.getWsdlDir(Class, "old");
		File newWsdlDir = RegressionHelpers.getWsdlDir(Class, "new");
		String newFileName = oldWsdlDir.list()[0];
		String oldFileName = newWsdlDir.list()[0];

		assertEquals("Generated files have different names.",
			oldFileName, newFileName);
	}

	@Test
	public void sameNoMethodXML ()
		throws java.io.IOException, org.xml.sax.SAXException
	{
		File xmlFile;
		String oldXML;
		String newXML;

		xmlFile = RegressionHelpers.getWsdlDir("NoMethod", "old").listFiles()[0];
		oldXML = RegressionHelpers.loadXmlString(xmlFile);
		xmlFile = RegressionHelpers.getWsdlDir("NoMethod", "new").listFiles()[0];
		newXML = RegressionHelpers.loadXmlString(xmlFile);

		assertXMLEqual("The NoMethod XML files are not identical", oldXML, newXML);
	}
}
