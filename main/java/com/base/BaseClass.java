package com.base;
import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class BaseClass {
	public static WebDriver driver;
	public static File file;


	// 1 Launch Browser
	public static WebDriver launchBrowser(String browsername) {	
		if (browsername.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			ChromeOptions chrome = new ChromeOptions();
			chrome.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking","enable-automation"));
			chrome.addArguments("incognito");
//			chrome.addArguments("headless");
			driver=new ChromeDriver(chrome);
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
		}
		else if (browsername.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}	
		else if (browsername.equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}	
		driver.manage().window().maximize();
		return driver;
	}
	
	public static void deleteCookies() {
		driver.manage().deleteAllCookies();
	}
	// 2 get
	public static WebDriver launchUrl(String url) {
		driver.get(url);
		return driver;
	}
	public static  void staticWait(long sec) {
	try {
		Thread.sleep(sec);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	

	}

	// 3 close
	public static void closeBrowser() {
		driver.close();
	}

	//4 quit
	public static void terminateBrowser() {
		driver.quit();
	}

	//5 Navigate-forward
	public static void forwardPage() {
		driver.navigate().forward();
	}

	//6 send keys
	public static void passInput(WebElement element, String input) {
		element.sendKeys(input,Keys.ENTER);
	}
	
	public static void sleep(long sec) {
		try {
			Thread.sleep(sec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//7 click

	public static void clickButton(WebElement element) {
		expliciWait(element);
		element.click();
	}

	//8 clear
	public static void deleteInpt(WebElement element) {
		element.clear();
	}

	private static Select dropDownsObject(WebElement element) {
		Select s = new Select(element);
		return s;
	}

	//9 select by value
	public static void selectbyValue(WebElement element, String ind) {
		dropDownsObject(element).selectByValue(ind);
	}

	// 10 select by index
	public static void selectbyIndex(WebElement element, int input) {
		dropDownsObject(element).selectByIndex(input);
	}

	//11 select by visible text
	public static void selectbyVisibletext(WebElement element, String sec) {
		dropDownsObject(element).selectByVisibleText(sec);
	}

	//13 scroll down and up

	public static void scroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 1000);");

	}
	public static void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}


	//14 Navigate TO
	public static void navigateto(String url) {
		driver.navigate().to(url);
	}

	//15 Navigate-back
	public static void backPage(WebElement element) {
		driver.navigate().back();
	}

	//16 Navigate-Refresh
	public static void reFresh(WebElement element) {
		driver.navigate().refresh();
	}

	//17 RadioButton
	public static void RadioButton(WebElement element) {
		element.click();
	}

	//18 Alert accept
	public static void alertaccept() {
		Alert a = driver.switchTo().alert();
		a.accept();
	}

	//19 Alert dismiss
	public static void alertdismiss() {
		Alert a = driver.switchTo().alert();
		a.dismiss();
	}

	//19 Alert input
	public static void alertinput(WebElement element, String input) {
		Alert a = driver.switchTo().alert();
		a.sendKeys(input);
	}

	//20 getAlerttext
	public static void getalerttext() {
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
	}

	//21 get current url
	public static void getcurrenturl() {
		System.out.println(driver.getCurrentUrl());
	}

	//22 get title
	public static String gettitle() {
		return driver.getTitle();
	}

	//23 get text
	public static String  getTex(WebElement element) {
		String text = element.getText();
		return text;
	}

	private static Actions actionsObj() {
		Actions as = new Actions(driver);
		return as;
	}

	//24 Actions drag&drop
	public static void draganddrop(WebElement element, WebElement element1) {
		actionsObj().dragAndDrop(element, element1).click().build().perform();
	}

	//25 Actions click
	public static void actionclick(WebElement element) {
		actionsObj().click(element).perform();
	}

	//26 Actions move to element
	public static void movetoelement(WebElement element) {
		actionsObj().moveToElement(element).perform();
	}

	//27 Actions context click
	public static void contextclick(WebElement element) {
		actionsObj().contextClick(element).perform();
	}

	//28 Actions Double click
	public static void doubleclick(WebElement element) {
		actionsObj().doubleClick(element).perform();
	}

	private static Robot robotObj() throws AWTException {
		Robot rt = new Robot();
		return rt;
	}

	//29 robots down key press & release
	public static void downkey() throws AWTException {
		robotObj().keyPress(KeyEvent.VK_DOWN);
		robotObj().keyRelease(KeyEvent.VK_DOWN);
	}

	//30 robots up key press & release
	public static void upkey() throws AWTException {
		robotObj().keyPress(KeyEvent.VK_UP);
		robotObj().keyRelease(KeyEvent.VK_UP);
	}

	//31 robots enter key press & release
	public static void enterkey() throws AWTException {
		robotObj().keyPress(KeyEvent.VK_ENTER);
		robotObj().keyRelease(KeyEvent.VK_ENTER);
	}

	//32 get window handles
	public static void windowhandles() {
		Set<String> allid = driver.getWindowHandles();
		System.out.println(allid);
	
		Iterator<String> iterator = allid.iterator();
		while(iterator.hasNext()) {
			String next = iterator.next();
			driver.switchTo().window(next).getTitle();
		}
	}
	//33 get window handle
	public static void windowhandle() {
		String id = driver.getWindowHandle();
		System.out.println(id);
	}

	//34 enable
	public static void isenable(WebElement element) {
		System.out.println(element.isEnabled());
	}

	//35 displayed
	public static boolean isdisplayed(WebElement element) {
		return element.isDisplayed();
	}

	//36 selected
	public static void isselected(WebElement element) {
		System.out.println(element.isSelected());
	}

	//37 deselect by visible text
	public static void deselectbyVisibletext(WebElement element, String des) {
		dropDownsObject(element).deselectByVisibleText(des);
	}

	//38 is multiple
	public static void ismultiple(WebElement element) {
		Select s = new Select(element);
		System.out.println(s.isMultiple());
	}

	//39 deselect by value
	public static void deselectbyValue(WebElement element, String ind) {
		dropDownsObject(element).deselectByValue(ind);
	}

	//40 deselect by index
	public static void deselectbyIndex(WebElement element, int input) {
		dropDownsObject(element).deselectByIndex(input);
	}

	//41 get options
	public static void getoptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		for (WebElement set : options) {
			System.out.println(set.getText());
		}
	}

	//42 get first selected option
	public static void getfirstselectedoptions(WebElement element) {
		Select s = new Select(element);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		System.out.println(firstSelectedOption.getText());
	}

	//43 get all selected option
	public static void getallslectedoptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		for (WebElement selectedOptions : allSelectedOptions) {
			System.out.println(selectedOptions.getText());
		}
	}

	//44 implicit wait
	public static void implicitwait(int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}

	//45 web-table AllDatas

	public static void webtableAllDatas(List<WebElement> elements) {
		List<WebElement> datas = elements;
		for (WebElement allDatas : datas) {
			System.out.println(allDatas.getText());
		}
	}
	//46 web-table rowDatas

	public static void webtableRowDatas(List<WebElement> elements) {
		List<WebElement> rDatas = elements;
		for (WebElement rowDatas : rDatas) {
			System.out.println(rowDatas.getText());
		}
	}
	//47 web-table columnDatas
	public static void webtableCoulmnDatas(List<WebElement> elements) {
		List<WebElement> cDatas = elements;
		for (WebElement columnDatas : cDatas) {
			System.out.println(columnDatas.getText());
		}
	}
	//48  web-table singleDatas
	public static void webtableSingleData(WebElement element) {
		System.out.println(element.getText());
	}
	//49 frame id
	public static void frameId(String id) {
		driver.switchTo().frame(id);	
	}
	//50 frame index
	public static void frameIndex(int index) {
		driver.switchTo().frame(index);
	}
	// 51 frame webelemet
	public static void frameWebelemet(WebElement element) {
		driver.switchTo().frame(element);
	}
	//52 frame exit
	public static void frameExit() {
		driver.switchTo().defaultContent();
	}
	//53 outer frame
	public static void outerFrame() {
		driver.switchTo().parentFrame();
	}
//	public static void goWindow(int num) {
//		ArrayList<String>allwin = new ArrayList()<>(driver.getWindowHandles());
//		driver.switchTo().window(allwin.get(num));
//	}

	public static String fullScreenshot(String location) throws IOException {
		Screenshot take = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(take.getImage(), "PNG", new File(location));
		return location  ;
	}
	
	

	public String takeScreenshot(String name)  {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File scrfile = screenshot.getScreenshotAs(OutputType.FILE);
		File destfile = new File("C:\\Users\\NishadNathiraa\\eclipse-workspace\\Flipkart_Assignment\\screenshot"+name+".png");
		try {
			FileUtils.copyFile(scrfile, destfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destfile.getAbsolutePath();
	}
	public static void listData(List<WebElement> allElements,String expected) {
//		List<WebElement> element = allElements;
		for (WebElement data : allElements) {
			
			if (data.getText().contains(expected)) {
				System.out.println(data.getText());
				data.click();
				break;
			}
		}
	}

	public static void expliciWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}


	public void screenShot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File scrfile = screenshot.getScreenshotAs(OutputType.FILE);
		File destfile = new File("C:\\Users\\NishadNathiraa\\eclipse-workspace\\Flipkart_Assignment\\screenshot"+name+".png");
		try {
			FileUtils.copyFile(scrfile, destfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}