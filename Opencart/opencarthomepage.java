package opencart;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class opencartloginpage {

	public static void main(String[] args) {
		// create an object for chrome driver
		WebDriver driver = new ChromeDriver();
		
		//open the webpage using get method
		driver.get("https://www.opencart.com/");
		
		//every execution will take 3 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		
		//maximize the window screen
		driver.manage().window().maximize();

		//check logo visibility
		Boolean logo = driver.findElement(By.xpath("//img[@title='OpenCart - Open Source Shopping Cart Solution']")).isDisplayed();
		System.out.println("logo status: " + logo);

		//check title is present
		String title = driver.getTitle();
		System.out.println("title of the page is: " + title);

		//total navitems present on webpage
		List <WebElement> totalnavitems=driver.findElements(By.xpath("//ul[@class=\"nav navbar-nav\"]//li"));
		System.out.println("total number of navitems: "+totalnavitems.size());
		
		// print the names of navitems
		List<WebElement> navitems = driver.findElements(By.xpath("//*[@id=\"navbar-collapse-header\"]/ul"));
		System.out.println("Number of navitems: ");
		
		for (int i = 0; i < navitems.size(); i++) {
			String navitemsname = navitems.get(i).getText();
			System.out.println(navitemsname);
		}
		
        //check the select dropdown option
		WebElement drpdownnavitem=driver.findElement(By.xpath("//*[@id=\"navbar-collapse-header\"]/ul/li[6]/a"));
		Boolean drpdownenablestatus=drpdownnavitem.isEnabled();
		System.out.println("Enable status of dropdown menu in navbar: "+drpdownenablestatus);
		
		drpdownnavitem.click(); //click on the arrow icon
		
		//check the dropdown menu options are displayed
		Boolean displaystatusofoptions=driver.findElement(By.xpath("//ul[@class=\"nav navbar-nav\"]")).isDisplayed();
		System.out.println("Display status of resources options: "+displaystatusofoptions);
		
		//count the total number of options present in the dropdown menu
		List <WebElement> resourcelist=driver.findElements(By.xpath("//ul[@class=\"dropdown-menu\"]//li"));
		System.out.println("total number of resource list options: "+resourcelist.size() );
		
		//print the total number of options present in the dropdown menu
		System.out.println("Names of resourcelist options");
		
		for (int j=0;j<resourcelist.size();j++) {
			String resourcesnames=resourcelist.get(j).getText();
			System.out.println(resourcesnames);			
		}
		
		// open the showcase resource
		driver.findElement(By.xpath("//*[@id=\"navbar-collapse-header\"]/ul/li[6]/ul/li[1]/a")).click(); 
		// driver.navigate().back();

		// print names of showcase navitems 
		List<WebElement> showcasenavitems = driver.findElements(By.xpath("//*[@id=\"cms-showcase\"]/div[2]/ul"));
		System.out.println("showcase navbar items names: ");
		for (int k = 0; k < showcasenavitems.size(); k++) {
			String navitemsnames = showcasenavitems.get(k).getText();
			System.out.println(navitemsnames);
		}
        //count total number of cards present in the web page
		List<WebElement> cards = driver.findElements(By.xpath("//div[@class=\"row\"]"));
		System.out.println("total cards on webpage: " + cards.size());

		//count total number of pages present in the source page
		List<WebElement> pages = driver.findElements(By.xpath("//li[@class=\"page-item\"]"));
		System.out.println("total number of pages: " + pages.size());
		
		//send the input value in footer input field
		WebElement email=driver.findElement(By.xpath("//*[@id=\"newsletter\"]/div/input"));
		Boolean emailinputstatus=email.isEnabled();
		System.out.println("Enable status of email input field: "+emailinputstatus);
		email.sendKeys("hitaliabgul@gmail.com");
	}

}
