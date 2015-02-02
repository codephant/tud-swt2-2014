import org.junit.Assert;
import org.custommonkey.xmlunit.XMLAssert;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.custommonkey.xmlunit.XMLUnit;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.examples.RecursiveElementNameAndTextQualifier;

import java.io.File;

public class J2WsdlRegrTest
{
	@BeforeClass
	public static void setUp(){
		RegressionHelpers.prepareWsdlDir();
		RegressionHelpers.setupXMLUnit();
	}

	/**
	 * This is a template for tests that test for XML similarity with XMLUnit.
	 * Dollar-variables ("$...") must be replaces by the actual test data.

	@Test
	public void $testName ()
		throws java.io.IOException, org.xml.sax.SAXException, java.lang.InterruptedException
	{
		// setup constants of this test
		final String ClassName = "$className";
		final String FileName = String.format("%s.xml", ClassName);

		// convert and load XML strings for both library versions
		String oldXML = RegressionHelpers.convertWithLibAndLoadXml(ClassName, "old", FileName);
		String newXML = RegressionHelpers.convertWithLibAndLoadXml(ClassName, "new", FileName);

		// use the custom assert to provide complete XML diff on failure
		RegressionHelpers.assertXMLSimilar(ClassName, oldXML, newXML);
	}
	 */

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

		Assert.assertEquals("Generated files should have same name.",
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

		RegressionHelpers.assertXMLSimilar(ClassName, oldXML, newXML);
	}

	@Test
	public void xmlEqualOneMethod ()
		throws java.io.IOException, org.xml.sax.SAXException, java.lang.InterruptedException
	{
		final String ClassName = "OneMethod";
		final String FileName = String.format("%s.xml", ClassName);
		String oldXML = RegressionHelpers.convertWithLibAndLoadXml(ClassName, "old", FileName);
		String newXML = RegressionHelpers.convertWithLibAndLoadXml(ClassName, "new", FileName);

		RegressionHelpers.assertXMLSimilar(ClassName, oldXML, newXML);
	}

	@Test
	public void xmlEqualManyMethods ()
		throws java.io.IOException, org.xml.sax.SAXException, java.lang.InterruptedException
	{
		final String ClassName = "ManyMethods";
		final String FileName = String.format("%s.xml", ClassName);
		String oldXML = RegressionHelpers.convertWithLibAndLoadXml(ClassName, "old", FileName);
		String newXML = RegressionHelpers.convertWithLibAndLoadXml(ClassName, "new", FileName);

		RegressionHelpers.assertXMLSimilar(ClassName, oldXML, newXML);
	}
	
	@Test
	public void xmlEqualReturnTypes()
		throws java.io.IOException, org.xml.sax.SAXException, java.lang.InterruptedException
	{
		// setup constants of this test
		final String ClassName = "ReturnTypes";
		final String FileName = String.format("%s.xml", ClassName);

		// convert and load XML strings for both library versions
		String oldXML = RegressionHelpers.convertWithLibAndLoadXml(ClassName, "old", FileName);
		String newXML = RegressionHelpers.convertWithLibAndLoadXml(ClassName, "new", FileName);

		// use the custom assert to provide complete XML diff on failure
		RegressionHelpers.assertXMLSimilar(ClassName, oldXML, newXML);
	}

	@Test
	public void xmlEqualParameterTypes ()
		throws java.io.IOException, org.xml.sax.SAXException, java.lang.InterruptedException
	{
		final String ClassName = "ParameterTypes";
		final String FileName = String.format("%s.xml", ClassName);
		String oldXML = RegressionHelpers.convertWithLibAndLoadXml(ClassName, "old", FileName);
		String newXML = RegressionHelpers.convertWithLibAndLoadXml(ClassName, "new", FileName);

		RegressionHelpers.assertXMLSimilar(ClassName, oldXML, newXML);
	}
	
	@Test
	public void xmlEqualParameterNumber()
		throws java.io.IOException, org.xml.sax.SAXException, java.lang.InterruptedException
	{
		// setup constants of this test
		final String ClassName = "ParameterNumber";
		final String FileName = String.format("%s.xml", ClassName);

		// convert and load XML strings for both library versions
		String oldXML = RegressionHelpers.convertWithLibAndLoadXml(ClassName, "old", FileName);
		String newXML = RegressionHelpers.convertWithLibAndLoadXml(ClassName, "new", FileName);

		// use the custom assert to provide complete XML diff on failure
		RegressionHelpers.assertXMLSimilar(ClassName, oldXML, newXML);
	}
	
	@Ignore
	@Test
	public void xmlEqualStaticMethods()
		throws java.io.IOException, org.xml.sax.SAXException, java.lang.InterruptedException
	{
		// setup constants of this test
		final String ClassName = "StaticMethods";
		final String FileName = String.format("%s.xml", ClassName);

		// convert and load XML strings for both library versions
		String oldXML = RegressionHelpers.convertWithLibAndLoadXml(ClassName, "old", FileName);
		String newXML = RegressionHelpers.convertWithLibAndLoadXml(ClassName, "new", FileName);

		// use the custom assert to provide complete XML diff on failure
		RegressionHelpers.assertXMLSimilar(ClassName, oldXML, newXML);
	}
	
	@Test
	public void xmlEqualExceptionMethods()
		throws java.io.IOException, org.xml.sax.SAXException, java.lang.InterruptedException
	{
		// setup constants of this test
		final String ClassName = "ExceptionMethods";
		final String FileName = String.format("%s.xml", ClassName);

		// convert and load XML strings for both library versions
		String oldXML = RegressionHelpers.convertWithLibAndLoadXml(ClassName, "old", FileName);
		String newXML = RegressionHelpers.convertWithLibAndLoadXml(ClassName, "new", FileName);

		// use the custom assert to provide complete XML diff on failure
		RegressionHelpers.assertXMLSimilar(ClassName, oldXML, newXML);
	}
	
	@Test
	public void xmlEqualCustomClasses()
		throws java.io.IOException, org.xml.sax.SAXException, java.lang.InterruptedException
	{
		// setup constants of this test
		final String ClassName = "CustomClasses";
		final String FileName = String.format("%s.xml", ClassName);

		// convert and load XML strings for both library versions
		String oldXML = RegressionHelpers.convertWithLibAndLoadXml(ClassName, "old", FileName);
		String newXML = RegressionHelpers.convertWithLibAndLoadXml(ClassName, "new", FileName);

		// use the custom assert to provide complete XML diff on failure
		RegressionHelpers.assertXMLSimilar(ClassName, oldXML, newXML);
	}

	@Test
	public void xmlEqualIdentifierCharacters ()
		throws java.io.IOException, org.xml.sax.SAXException, java.lang.InterruptedException
	{
		final String ClassName = "IdentifierCharacters";
		final String FileName = String.format("%s.xml", ClassName);
		String oldXML = RegressionHelpers.convertWithLibAndLoadXml(ClassName, "old", FileName);
		String newXML = RegressionHelpers.convertWithLibAndLoadXml(ClassName, "new", FileName);

		RegressionHelpers.assertXMLSimilar(ClassName, oldXML, newXML);
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
									"		        <name>You can win</name> \n" +
									"		        <isbn>9971-5-0222-0</isbn> \n" +
									"		        <author>Shiv Khera</author> \n" +
									"		    </book> \n" +
									"		    <book> \n" +
									"		        <name>Angels &amp; Demons</name> \n" +
									"		        <isbn>9971-5-0210-0</isbn> \n" +
									"		        <author transport='http11'>Dan Brown</author> \n" +
									"		        <category></category> \n" +
									"		    </book> \n" +
									"<!-- comment 2               -->" +

									"		</books>";
		//RegressionHelpers.assertXMLSimilar("XML UNit Configuration", control, test);
		Diff diff = new Diff(control, test);
		diff.overrideDifferenceListener(
			new myDifferenceListener());
		diff.overrideElementQualifier(new RecursiveElementNameAndTextQualifier());
		XMLAssert.assertTrue("Files are not the same", diff.similar());
		//assertXMLEqual("Files are not the same", control, test);
	}
}
