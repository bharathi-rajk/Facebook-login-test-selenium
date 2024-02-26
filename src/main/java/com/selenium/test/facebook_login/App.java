package com.selenium.test.facebook_login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver.Timeouts;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        System.out.println( "This application is to test facebook login!" );
        
        // System.setProperty("webdriver.chrome.driver", "C:\\Bharathi\\software\\Chrome-driver\\chromedriver-win64\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        
        WebDriver driver = new ChromeDriver(chromeOptions);
        
        System.out.println("Let's begin the testing");
        
        // 1. Open the browser and get to the URL
        driver.get("https://www.facebook.com/");
        
        // Enable wait for 2 seconds
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        
        // Enter email id / phone number on user name section
        driver.findElement(By.id("email")).sendKeys("000000000");
        Thread.sleep(1000);

        // Enter password on pass section
        driver.findElement(By.id("pass")).sendKeys("password");
        Thread.sleep(1000);
        
        System.out.println("We have provided test credentials, so the login attempt will not be successful. Let's wait for 10 seconds");

        // click login button
        driver.findElement(By.name("login")).click();
        Thread.sleep(10000);
        
        System.out.println("Testing has been completed.");
        driver.quit();
    }
}

