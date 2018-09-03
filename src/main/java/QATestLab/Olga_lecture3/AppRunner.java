package QATestLab.Olga_lecture3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import QATestLab.Olga_lecture3.*;

public class AppRunner {

	public static void main(String[] args) {
		WebDriver driver = GetInitChromdriver();
		driver.manage().window().maximize();
		driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/index.php?controller=AdminLogin&token=d251f363cceb5a849cb7330938c64dea&redirect=AdminDashboard");
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("webinar.test@gmail.com");
		WebElement password = driver.findElement(By.id("passwd"));
		password.sendKeys("Xcg7299bnSmMuRLp9ITw");
		WebElement enter = driver.findElement(By.name("submitLogin"));
		enter.submit();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("main")));
				
		WebElement category = driver.findElement(By.id("subtab-AdminCatalog"));
		Actions builder = new Actions(driver);
		builder.moveToElement(category).build().perform();
		driver.findElement(By.id("subtab-AdminCategories")).click();
		driver.findElement(By.id("page-header-desc-category-new_category")).click();
		WebDriverWait wait1 = new WebDriverWait(driver, 3);
		wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("category_form")));
		driver.findElement(By.xpath("//input[@id='name_1']")).sendKeys("New category");
		driver.findElement(By.id("category_form_submit_btn")).submit();
		
		WebDriverWait wait2 = new WebDriverWait(driver, 5);
		wait2.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='alert alert-success']")));
		
		driver.findElement(By.id("desc-category-back")).click();
		driver.findElement(By.xpath("//input[@class='filter'][@name='categoryFilter_name']")).sendKeys("New");
		driver.findElement(By.id("submitFilterButtoncategory")).submit();
		
		WebDriverWait wait3 = new WebDriverWait(driver, 5);
		wait3.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.partialLinkText("New")));
		
	}
	public static WebDriver GetInitChromdriver() {
		System.setProperty("webdriver.chrome.driver", AppRunner.class.getResource("chromedriver.exe").getPath());
		return new ChromeDriver();
	}
}
