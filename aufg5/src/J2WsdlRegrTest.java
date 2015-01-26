import static org.junit.Assert.*;
import static org.custommonkey.xmlunit.XMLAssert.*;

import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.StringBuffer;

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
		File oldWsdlDir = RegressionHelpers.getWsdlDir(Class, "old");
		File newWsdlDir = RegressionHelpers.getWsdlDir(Class, "new");
		String newFileName = oldWsdlDir.list()[0];
		String oldFileName = newWsdlDir.list()[0];

		assertEquals("Generated files have the same name",
			oldFileName, newFileName);
	}

	@Test
	public void sameNoMethodXML ()
		throws java.io.IOException, org.xml.sax.SAXException
	{
		StringBuffer oldXmlBuf = new StringBuffer();
		StringBuffer newXmlBuf = new StringBuffer();
		String line;
		File oldFile = RegressionHelpers.getWsdlDir("NoMethod", "old").listFiles()[0];
		File newFile = RegressionHelpers.getWsdlDir("NoMethod", "new").listFiles()[0];
		BufferedReader bf;

		bf = new BufferedReader(new FileReader(oldFile));
		for(line = bf.readLine(); line != null; line = bf.readLine())
		{
			oldXmlBuf.append(line);
		}
		
		bf = new BufferedReader(new FileReader(newFile));
		for(line = bf.readLine(); line != null; line = bf.readLine())
		{
			newXmlBuf.append(line);
		}

		assertXMLEqual("NoMethod", oldXmlBuf.toString(), newXmlBuf.toString());
	}
}
