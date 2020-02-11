package br.unipe.pos.AndroidAutomation;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SampleTest {

	  private AndroidDriver driver;

	  @Before
	  public void setUp() throws MalformedURLException {
	    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "520389e5b8e3a305");

	    File classpathRoot = new File(System.getProperty("user.dir"));
        File app = new File(classpathRoot, "/app/AnotherCalculator.apk");
        desiredCapabilities.setCapability("app", app.getAbsolutePath());
 
	    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

	    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
	  }

	  @Test
	  public void sampleTest() {
	    MobileElement el1 = (MobileElement) driver.findElementById("net.tecnotopia.SimpleCalculator:id/button2");
	    el1.click();
	    MobileElement el2 = (MobileElement) driver.findElementById("net.tecnotopia.SimpleCalculator:id/buttonAdd");
	    el2.click();
	    MobileElement el3 = (MobileElement) driver.findElementById("net.tecnotopia.SimpleCalculator:id/button1");
	    el3.click();
	    MobileElement el4 = (MobileElement) driver.findElementById("net.tecnotopia.SimpleCalculator:id/button0");
	    el4.click();
	    MobileElement el5 = (MobileElement) driver.findElementById("net.tecnotopia.SimpleCalculator:id/buttonEquals");
	    el5.click();
	    
	    MobileElement display = (MobileElement) driver.findElementById("net.tecnotopia.SimpleCalculator:id/display");
	    assertEquals("13", display.getText());
	  }

	  @After
	  public void tearDown() {
	    driver.quit();
	  }
	}