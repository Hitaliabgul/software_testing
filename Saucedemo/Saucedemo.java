package saucedemo;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Saucedemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));  //implicit wait
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(3000)); //explicit wait
		
		//open saucedemo website
		driver.get("https://sauce-demo.myshopify.com/");
		
		//maximize the screen window
		driver.manage().window().maximize();

		//get title of the webpage
		String title = driver.getTitle();
		System.out.println("Title of the page is: " + title);

		//search field
		WebElement search = driver.findElement(By.xpath("//*[@id=\"search-field\"]"));
		Boolean enablestatusofsearch = search.isEnabled();
		System.out.println("Enable status of search field: " + enablestatusofsearch);
		search.sendKeys("shoes");

		driver.findElement(By.xpath("//*[@id=\"search-submit\"]")).click();
		//navbar items
		List<WebElement> navitems = driver.findElements(By.xpath("//div[@class='seven columns offset-by-one desktop']//nav//a"));
		System.out.println("total navitems" + navitems.size());
		System.out.println("navitems names");

		for (int i = 0; i < navitems.size(); i++) {
			String navitemsnames = navitems.get(i).getText();
			System.out.println(navitemsnames);
		}

		//left menu
		List<WebElement> leftmenu = driver.findElements(By.xpath("//*[@id=\"main-menu\"]//li"));
		System.out.println("Total number of leftmenu: " + leftmenu.size());
		System.out.println("Names of leftmenuitems: ");
		// print all values
		for (int j = 0; j < leftmenu.size(); j++) {
			String leftmenunames = leftmenu.get(j).getText();
			System.out.println(leftmenunames);

		}

		// aboutus
		driver.findElement(
				By.xpath("//div[@class='seven columns offset-by-one desktop']//a[normalize-space()='About Us']"))
				.click();
		String aboutus = driver.findElement(By.xpath("//h1[normalize-space()='About Us']")).getText();
		System.out.println("Status of about page: " + aboutus);

		// signup page
		driver.findElement(By.xpath("//div[@class='seven columns offset-by-one desktop']//a[@id='customer_register_link']")).click();
		String signup = driver.findElement(By.xpath("//h1[@class='accounts-title']")).getText();
		System.out.println(signup);

		// firstname
		driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("hitali1");
		// lastname
		driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("abgul1");
		// email
		driver.findElement(By.xpath("//input[@id='email' and @class='long']")).sendKeys("hitaliabgul1@gmail.com");
		// password
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("hitali123");
		// button
		driver.findElement(By.xpath("//div[@class='action_bottom']")).click();

		// loginpage
		driver.findElement(
				By.xpath("//div[@class='seven columns offset-by-one desktop']//a[@id='customer_login_link']")).click();
		System.out.println(driver.findElement(By.xpath("//h1[@class='accounts-title']")).getText());
		// email
		driver.findElement(By.xpath("//input[@id='customer_email']")).sendKeys("hitaliabgul1@gmail.com");
		// password
		driver.findElement(By.xpath("//input[@id='customer_password']")).sendKeys("hitali123");
		// button
		WebElement signInButton = mywait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='action_bottom']//input[@value='Sign In']")));
		signInButton.click();

		WebElement catalogLink = mywait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main-menu\"]/li[2]/a")));
		catalogLink.click();
		// catalog
		driver.findElement(By.xpath("//*[@id=\"main-menu\"]/li[2]/a")).click();

		// total cards on catalog
		driver.findElements(By.xpath("//*[@id=\"page-content\"]/section/div")).size();
		System.out.println("total items which are present in the catalog"+driver.findElements(By.xpath("//*[@id=\"page-content\"]/section/div")).size());

		// click on first card
		driver.findElement(By.xpath("//img[@alt='Grey jacket']")).click();
		// get name of the clothes
		String text = driver.findElement(By.xpath("//h1[@itemprop='name']")).getText();
		System.out.println("Clothes name: " + text);
		// get price for the clothes
		String price = driver.findElement(By.xpath("//span[@class='product-price']")).getText();
		System.out.println("Price of the clothes: " + price);

		// click on add to card button as well as check enable status of button
		Boolean addtocart = driver.findElement(By.xpath("//input[@id='add']")).isEnabled();
		System.out.println("Enable status of addtocart: " + addtocart);
		driver.findElement(By.xpath("//input[@id='add']")).click();
		// catalog
		driver.findElement(By.xpath("//*[@id=\"main-menu\"]/li[2]/a")).click();

		// click on noir jacket
		driver.findElement(By.xpath("//img[@alt='Noir jacket']")).click();

		// get name of the clothes
		String textofnoirjacket = driver.findElement(By.xpath("//h1[@itemprop='name']")).getText();
		System.out.println("Clothes name: " + textofnoirjacket);
		// get price fo the clothes
		String priceofnoir = driver.findElement(By.xpath("//span[@class='product-price']")).getText();
		System.out.println("Price of the clothes: " + priceofnoir);

		driver.findElement(By.xpath("//input[@id='add']")).click();
		// sizedropdown
		WebElement sizedropdown = driver.findElement(By.xpath("//select[@id='product-select-option-0']"));
		Select sizedrpdownlist = new Select(sizedropdown);
		// get options in size dropdown
		List<WebElement> optionsforsize = sizedrpdownlist.getOptions();
		// count total no of options
		System.out.println("Total no of options: " + optionsforsize.size());
		// print names of size options
		System.out.println("Name of size options which are available: ");
		for (int i = 0; i < optionsforsize.size(); i++) {
			String sizenames = optionsforsize.get(i).getText();
			System.out.println(sizenames);
		}
		// select the Medium 'm' value from the size dropdown
		sizedrpdownlist.selectByValue("M");

		// color dropdown
		WebElement colordrpdown = driver.findElement(By.xpath("//*[@id=\"product-select-option-1\"]"));
		Select coloroption = new Select(colordrpdown);
		// get options of color dropdown
		List<WebElement> coloroptions = coloroption.getOptions();
		// count total number of options in color dropdown
		System.out.println("Total no of options in color dropdown: " + coloroptions.size());
		// print names of color options
		System.out.println("Name of color options which are available: ");
		for (int j = 0; j < coloroptions.size(); j++) {
			String colornames = coloroptions.get(j).getText();
			System.out.println(colornames);
		}
		// click on red value from dropdown
		coloroption.selectByValue("Red");
		// finally click on add to cart button
		driver.findElement(By.xpath("//input[@id='add']")).click();

	}

}
