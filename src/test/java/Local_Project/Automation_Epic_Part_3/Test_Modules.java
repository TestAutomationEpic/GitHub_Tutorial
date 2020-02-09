package Local_Project.Automation_Epic_Part_3;

import org.openqa.selenium.WebDriver;

public class Test_Modules {
	
	public void openWebSite(WebDriver driver, String web_site) throws InterruptedException {
		
		driver.get(web_site);
		driver.manage().window().maximize();
		String Url = driver.getCurrentUrl().toString();
		System.out.println(Url);
		driver.navigate().refresh();
		Thread.sleep(5000);
        driver.quit();
        
	}

}
