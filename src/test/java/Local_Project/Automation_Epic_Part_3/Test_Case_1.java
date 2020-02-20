package Local_Project.Automation_Epic_Part_3;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class Test_Case_1 {
	
	WebDriver driver;
	String chrome_driver_directory;
	String web_site;

	@Test
	public void test_1() throws InterruptedException  {
		
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			final DocumentBuilder builder = factory.newDocumentBuilder();
			try {
				final Document document= builder.parse(new File("Test_Data.xml"));
				document.getDocumentElement().normalize();
				Element root = document.getDocumentElement();
				
				//Test Data
				chrome_driver_directory= root.getElementsByTagName("Chrome_Driver_Directory").item(0).getTextContent();
				web_site = root.getElementsByTagName("Web_Site").item(0).getTextContent();  
				
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.setProperty("webdriver.chrome.driver", chrome_driver_directory);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--lang=en-GB");
		driver = new ChromeDriver(options);
		
		Test_Modules module = new Test_Modules();
		module.openWebSite(driver, web_site);
		   
	}	
}
