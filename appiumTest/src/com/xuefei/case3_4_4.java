/**
 * com.testcase.demo
 * appiumTest
 * case1.java
 * 
 * Copyright 2018 QYcloud Product test group
 *
 * Created on 2018年3月9日 下午3:28:05
 *
 * Created by LuoPeng
 */
package com.xuefei;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;

/*
 *@author luopeng
 *Last_Update 2018年4月25日上午10:41:04
 *
 */
public class case3_4_4 extends TestInfo {
	private static AppiumDriver driver;

	@BeforeClass
	public void setup() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.BROWSER_NAME, "");
		cap.setCapability("platformName", Platform);
		cap.setCapability("deviceName", PhoneCode);
		cap.setCapability("platformVersion", Version);
		// 将上面获取到的包名和Activity名设置为值
		cap.setCapability("appPackage", ApkPackage);
		cap.setCapability("appActivity", ApkActivity);
		// A new session could not be created
		// cap.setCapability("appWaitActivity","com.android.ayplatform.activity.WelcomeActivity");
		// 每次启动时覆盖session，否则第二次后运行会报错不能新建session
		cap.setCapability("sessionOverride", true);
		// 解决每次启动APP需要确认权限问题--即不重复安装
		cap.setCapability("noReset", true);
		cap.setCapability("noSign", true);
		/*
		 * 中文输入,隐藏键盘启动 capabilities.setCapability("unicodeKeyboard", "True");
		 * capabilities.setCapability("resetKeyboard", "True");
		 */
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	}

	@Test(description = "我的发起-回退")
	public void plus() throws InterruptedException {

		Thread.sleep(3000);
		ClickXpath(MainPage_Tag_MyLaunch_Xpath);
		// driver.findElementByXPath(MainPage_Tag_MyLaunch_Xpath).click();//我发起的

		Thread.sleep(3000);
		ClickId("com.android.ayplatform.release:id/workbench_module_i_started_item1");
		// driver.findElementById("com.android.ayplatform.release:id/workbench_module_i_started_item1").click();//打开流程

		Thread.sleep(2000);
		ClickId("com.android.ayplatform.release:id/more");
		// driver.findElementById("com.android.ayplatform.release:id/more").click();//点击三个点

		Thread.sleep(2000);
		ClickXpath("//android.widget.TextView[@text='回退']");
		// driver.findElementByXPath("//android.view.ViewGroup[6]").click();//点击回退

		Thread.sleep(2000);
		ClickXpath("//android.widget.Button[@text='确定']");

		/*
		 * ClickXpath(
		 * "//hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]"
		 * );
		 */
		// driver.findElementByXPath("//hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]").click();//点击确定

		Back();

	}

	private void waitForId(String string) {
		// TODO Auto-generated method stub

	}

	@AfterClass
	public void tearDown() throws Exception {
		AppBase.textPrint("test end!");
		driver.quit();

	}

	/*
	 * //账号登录 public void login() throws InterruptedException { // 用户名输入
	 * Thread.sleep(5000);
	 * driver.findElementById("com.android.ayplatform:id/cardNumAuto").clear();
	 * Thread.sleep(2000);
	 * driver.findElementById("com.android.ayplatform:id/cardNumAuto").sendKeys(
	 * "15380424938"); Thread.sleep(2000); // 密码输入
	 * driver.findElementById("com.android.ayplatform:id/Pass").clear();
	 * Thread.sleep(2000);
	 * driver.findElementById("com.android.ayplatform:id/Pass").sendKeys(
	 * "luo199259"); Thread.sleep(2000); // HTC U11 关闭输入法键盘
	 * driver.navigate().back(); Thread.sleep(2000); // 登录
	 * driver.findElementById("com.android.ayplatform:id/login").click();
	 * Thread.sleep(2000); }
	 */

	/*
	 * // 等待xpath控件出现 public void waitForXpath(String Name, String Xpath) throws
	 * InterruptedException { for (int second = 0;; second++) { if (second >=
	 * 60) fail("timeout"); try { if
	 * (Name.equals(driver.findElementByXPath(Xpath))) break; Thread.sleep(2);
	 * 
	 * } catch(Exception e) { Thread.sleep(1000); e.printStackTrace();
	 * AppBase.textPrint("Page--> " + driver.getTitle() + "  :loding error");
	 * driver.quit(); AppBase.snapshot(); } Thread.sleep(1000);
	 * AppBase.textPrint("XpathButton--> " + Name + "  :cannot found!"); } }
	 */
	/*
	 * public void CheckXpath(String Xpath,String Text){ try {
	 * AppBase.textPrint("Check The Text For Xpath!");
	 * assertEquals(driver.findElement(By.xpath(Xpath)).getText(), Text);
	 * AppBase.textPrint("Check Success!"); } catch (Error e) {
	 * AppBase.textPrint("Check Fail!"); e.printStackTrace();
	 * AppBase.snapshot(); } }
	 */

	public void ClickId(String Id) {
		try {
			AppBase.textPrint("Click The Element For Id -> " + Id);
			driver.findElementById(Id).click();
			AppBase.textPrint("Click Act Success");
		} catch (Error e) {
			AppBase.textPrint("Click Fail");
			e.printStackTrace();
			AppBase.snapshot();
		}
	}

	public void ClickXpath(String Xpath) {
		try {
			AppBase.textPrint("Click The Element For Xpath ->" + Xpath);
			driver.findElementByXPath(Xpath).click();
			AppBase.textPrint("Click Act Success!");
		} catch (Error e) {
			AppBase.textPrint("Click Fail");
			e.printStackTrace();
			AppBase.snapshot();
		}
	}

	public void InPutByXpath(String Xpath, String Text) {
		try {
			AppBase.textPrint("input text For Id! ->" + Xpath);
			driver.findElementById(Xpath).sendKeys(Text);
			AppBase.textPrint("input success!");

		} catch (Error e) {

			AppBase.textPrint("input fail!");
			e.printStackTrace();
			AppBase.snapshot();

		}

	}

	public void Back() {
		driver.navigate().back();
	}

}
