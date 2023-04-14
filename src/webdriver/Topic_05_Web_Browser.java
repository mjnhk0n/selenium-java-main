package webdriver;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Web_Browser {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	// Tương tác với browser thì sẽ thông qua biến WebDriver - driver
	// Tương tác với element thì sẽ thông qua biến WebElement - element
	// 1- Tên hàm: dùng để làm gì
	// 2- Tham số truyền vào: khi dùng hàm này cần truyền dữ liệu gì để xử lý hay không?
	// 3- Kiểu dữ liệu trả về:
	// 	tip 1: Hàm action thì không có dữ liệu trả về (click/ nhập/ chọn/ accept/ hover/...) 100% là void()
	//	tip 2: Hàm nào lấy dữ liệu ra thì cần trả về (getURL/ title/ ID/ text/...) - return()
	// 	Có thể lưu vào 1 biến để sử dụng sau hoặc sử dụng luôn thì không cần tạo biến
	// 4- Thuộc class/ interface nào > phạm vi sử dụng (element hoặc webdriver)
	
	
	
	@Test
	public void TC_01_() {
	// Close: đóng 1 tab của browser
		driver.close();
	// Quit: tắt browser
		driver.quit();
	// Có thể lưu lại biến để sử dụng cho các step sau
		WebElement emailTextbox = driver.findElement(By.xpath("//input[@id='Email']"));
		// dấu '=' để gán dữ liệu cho biến "emailTextbox" với KIỂU DỮ LIỆU là WebElement - clean code
		emailTextbox.clear();
		emailTextbox.sendKeys("");
		
		// nếu không gán biến thì phải lặp lại đoạn code (hard code) > code không clean - bad code
		driver.findElement(By.xpath("//input[@id='Email']")).clear();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("");
		
	// Có thể sử dụng luôn ( không cần tạo biến) - dùng 1 lần
		driver.findElement(By.xpath("//button[@id='Login'])")).click();
		
	// findElement's' - Số nhiều - tìm hết các elements - trả về 1 list element
		driver.findElements(By.xpath(""));
		List<WebElement> checkBoxes = driver.findElements(By.xpath(""));
	
	// mở ra 1 trong URL nào đó
		driver.get("https://facebook.com");
	
	// lấy dữ liệu ra thì sẽ có tiền tô (prefix) là getXXX
		// Trả về URL của page hiện tại
		Assert.assertEquals(driver.getCurrentUrl(), "https://facebook.com");
	
	// Trả về page source code HTML của page hiện tại
		// Dùng để verify tương đối
		driver.getPageSource();
		Assert.assertTrue(driver.getPageSource().contains("trong cuộc sống của bạn"));
		
	// Trả về title của page hiện tại
		Assert.assertEquals(driver.getTitle(), "Facebook - Đăng nhập hoặc đăng ký");
	
	// Webdriver API - Window/ tab
		// Lấy ID của window/ tab đang active
		String loginWindowID = driver.getWindowHandle();
		
		// Lấy ID của tất cả window/ tab
		Set<String> allIDs = driver.getWindowHandles();
		
		// Cookie/ Cache
		Options opt = driver.manage();
		
		// Login thành công -> lưu lại
		opt.getCookies();
		// Test case khác > Set cookie vào lại > không cần type lại ID để login
		
		opt.logs();
		
		Timeouts time = opt.timeouts();
		
		// Khoảng thời gian chờ element xuất hiện
		time.implicitlyWait(5, TimeUnit.SECONDS);
		time.implicitlyWait(5000, TimeUnit.MILLISECONDS);
		time.implicitlyWait(5000000, TimeUnit.MICROSECONDS);
		
		// Khoảng thời gian chờ Page load
		time.pageLoadTimeout(5, TimeUnit.SECONDS);
		
		// WebDriver API - JS executor (JavascriptExecutor library)
		// Khoảng thời gian chờ script được thực thi xong
		time.setScriptTimeout(5, TimeUnit.SECONDS);
		
		
		Window win = opt.window();
		// Test GUI: Font/ Size/ Color/ Position/ Location/ ...	
		win.fullscreen();
		win.maximize();

		Navigation nav = driver.navigate();
		
		nav.back();
		nav.forward();
		nav.refresh();
		
		nav.to(""); // = với driver.get("");
		
		TargetLocator tar = driver.switchTo();
		
		// WebDriver API - Alert/ Authentication Alert (Alert library)
		tar.alert();
		// WebDriver API - Frame/ iFrame (Frame library)
		tar.frame("");
		// WebDriver API - tab/ window
		tar.window("");	
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}