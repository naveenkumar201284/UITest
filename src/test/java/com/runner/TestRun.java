package com.runner;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import filloreader.FilloReader;
import utility.ConstantHelper;

public class TestRun {
	static XmlSuite testNGsuite;
	static List<XmlClass> lst_testNgclassName = new ArrayList<XmlClass>();
	public static List<XmlSuite> testNGsuitelst = new ArrayList<XmlSuite>();
	static XmlTest testNGSuit_test;
	static List<XmlSuite> testNGXmlsuites = new ArrayList<XmlSuite>();
	public static List<Map<String, String>> pram = new ArrayList<Map<String, String>>();
	static Map<String, String> prammap = new HashMap<String, String>();

	public static void main(String[] args) throws Throwable {
		List<String> testvalue = new ArrayList<String>();
		BrowserInit.Initialize();
		//List<Map<String, String>> getRunModeTCListMap = FilloReader.getTestDataInListMap(new File("C:\\Users\\naveen.kumar\\Downloads\\Labloid_POMFramework-master\\src\\main\\java\\datamanager\\loginData.xlsx"),"TestRun"," ","select * from %s");
		List<Map<String, String>> getRunModeTCListMap=new FilloReader().getTestDataInListMap(new File("C:\\Users\\naveen.kumar\\Downloads\\Labloid_POMFramework-master\\src\\main\\java\\datamanager\\loginData.xlsx"),"TestRun", "select * from %s"); 

		String ExistingTestName = "";
		for (Map<String, String> map : getRunModeTCListMap) {
			String TestName = map.get("Reference").toString();
			testNGsuite = new XmlSuite();
			testNGsuite.setVerbose(888);
			testNGsuite.setName(ConstantHelper.testSuiteName);
			testNGSuit_test = new XmlTest(testNGsuite);
			testNGSuit_test.setName(ConstantHelper.testXMLTestName);
			if (!ExistingTestName.isEmpty()) {
				if (ExistingTestName.equals(TestName)) {
					testvalue.add(map.get("TestCase ID").toString());
				} else {
					testvalue = new ArrayList<String>();
					testvalue.add(map.get("TestCase ID").toString());
					ExistingTestName = TestName;
				}
			}
			if (ExistingTestName.isEmpty()) {
				testvalue.add(map.get("TestCase ID").toString());
				ExistingTestName = TestName;
			}
			String values = "";
			if (testvalue.size() > 1) {
				values = String.join(",", testvalue);
			}
			if (values.isEmpty())
				prammap.put(TestName, map.get("TestCase ID").toString());
			else
				prammap.put(TestName, values);
			System.out.println(prammap);
			// prammap.put(TestName, map.get("TestCase ID").toString());
			// pram.add(prammap);
			testNGSuit_test.setParameters(prammap);
			lst_testNgclassName.add(new XmlClass(TestName.toString()));
		}
		testNGSuit_test.setXmlClasses(lst_testNgclassName);
		List<XmlSuite> testNGXmlsuites = new ArrayList<XmlSuite>();
		testNGXmlsuites.add(testNGsuite);
		TestNG testNG = new TestNG();
		testNG.setXmlSuites(testNGXmlsuites);
		testNGsuite.setFileName("hghjgg.xml");
		// testNGSuit_test.setParameters(prammap);
		for (XmlSuite suite : testNGXmlsuites) {
			createXmlFile(suite);
		}
		System.out.println("Filerated successfully.");
		testNG.run();
		BrowserInit.TearDown();
	}

	public static void createXmlFile(XmlSuite mSuite) {
		FileWriter writer;
		try {
			writer = new FileWriter(new File("naveen.xml"));
			writer.write(mSuite.toXml());
			writer.flush();
			writer.close();
			System.out.println(new File("myTemp.xml").getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}