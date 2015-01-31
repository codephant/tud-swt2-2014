import org.junit.Assert;
import org.custommonkey.xmlunit.XMLAssert;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.custommonkey.xmlunit.XMLUnit;
import org.custommonkey.xmlunit.Diff;

import java.io.File;

public class J2WsdlRegrTest
{
	@BeforeClass
	public static void setUp(){
		RegressionHelpers.prepareWsdlDir();
		RegressionHelpers.setupXMLUnit();
	}

	// @Test
	// public void filesHaveNoExtName ()
	// 	throws java.lang.InterruptedException, java.io.IOException
	// {
	// 	final String Class = "NoMethod";
	// 	final String FileName = String.format("%s", Class);
	// 	RegressionHelpers.convert2WsdlWithLib(Class, "old", FileName);
	// 	RegressionHelpers.convert2WsdlWithLib(Class, "new", FileName);
	// 	File oldWsdlDir = RegressionHelpers.getWsdlDir(Class, "old");
	// 	File newWsdlDir = RegressionHelpers.getWsdlDir(Class, "new");
	// 	String newFileName = oldWsdlDir.list()[0];
	// 	String oldFileName = newWsdlDir.list()[0];

	// 	Assert.assertEquals("The file names are different",
	// 		oldFileName, newFileName);
	// }

	@Test
	public void filesHaveSameName ()
		throws java.lang.InterruptedException, java.io.IOException
	{
		final String Class = "SameFileName";
		final String FileName = String.format("%s.xml", Class);
		RegressionHelpers.convert2WsdlWithLib(Class, "old", FileName);
		RegressionHelpers.convert2WsdlWithLib(Class, "new", FileName);
		String oldFileName = RegressionHelpers.getWsdlDir(Class, "old").list()[0];
		String newFileName = RegressionHelpers.getWsdlDir(Class, "new").list()[0];

		Assert.assertEquals("Generated files have same name.",
			oldFileName, newFileName);
	}

	@Test
	public void xmlEqualNoMethod ()
		throws java.io.IOException, org.xml.sax.SAXException, java.lang.InterruptedException
	{
		final String ClassName = "NoMethod";
		final String FileName = String.format("%s.xml", ClassName);
		String oldXML = RegressionHelpers.convertWithLibAndLoadXml(ClassName, "old", FileName);
		String newXML = RegressionHelpers.convertWithLibAndLoadXml(ClassName, "new", FileName);

		RegressionHelpers.assertXMLSimilar("NoMethod is similar", oldXML, newXML);
	}

	@Test
	public void xmlEqualManyMethods ()
		throws java.io.IOException, org.xml.sax.SAXException, java.lang.InterruptedException
	{
		final String ClassName = "ManyMethods";
		final String FileName = String.format("%s.xml", ClassName);
		String oldXML = RegressionHelpers.convertWithLibAndLoadXml(ClassName, "old", FileName);
		String newXML = RegressionHelpers.convertWithLibAndLoadXml(ClassName, "new", FileName);

		RegressionHelpers.assertXMLSimilar("ManyMethods", oldXML, newXML);
	}
	

	@Ignore
	@Test
	public void xmlUnitConfigurationPassed()
		throws java.io.IOException, org.xml.sax.SAXException
	{
		String control = "<?xml version='1.0' encoding='UTF-8'?> \n" +
									"		<books> \n" +
									"<!-- comment 1-->" +
									"		    <book> \n" +
									"		        <name>Angels &amp; Demons</name> \n" +
									"		        <isbn>9971-5-0210-0</isbn> \n" +
									"		        <author transport='http'>Dan Brown</author> \n" +
									"		        <category></category> \n" +
									"		    </book> \n" +
									"		    <book> \n" +
									"		        <name>You can         win</name> \n" +
									"		        <isbn>9971-5-0222-0</isbn> \n" +
									"		        <author>Shiv Khera</author> \n" +
									"		    </book> \n" +
									"		</books>";

		String test = "<?xml version='1.0' encoding='UTF-8'?> \n" +
									"		<books> \n" +
									"		    <book> \n" +
									"		        <name>Angels &amp; Demons</name> \n" +
									"		        <isbn>9971-5-0210-0</isbn> \n" +
									"		        <author transport='http11'>Dan Brown</author> \n" +
									"		        <category></category> \n" +
									"		    </book> \n" +
									"<!-- comment 2               -->" +
									"		    <book> \n" +
									"		        <name>You can win</name> \n" +
									"		        <isbn>9971-5-0222-0</isbn> \n" +
									"		        <author>Shiv Khera</author> \n" +
									"		    </book> \n" +
									"		</books>";
		Diff diff = new Diff(control, test);
		diff.overrideDifferenceListener(
			new myDifferenceListener());
		XMLAssert.assertTrue("Files are not the same", diff.similar());
		//assertXMLEqual("Files are not the same", control, test);
	}
}
