package com.selenium.course.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvException;
import com.selenium.course.base.TestUtil;
import com.selenium.course.utils.CsvReader;

import lombok.extern.slf4j.Slf4j;

public class SignupYF extends TestUtil {
	//WebDriver driver = null;  
	
	 @DataProvider(name="Registration-data")
	    public static Object[][] dataProviderFromFile() throws IOException, CsvException {
	        return CsvReader.readCsvFile("src/test/resources/login-data.csv");
	        }               
	                
	    @BeforeTest
	    public void setupDriver() {
	        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
	        driver = new FirefoxDriver();
	    }

	    @Test (dataProvider="Registration-data")
	    public void executeSimpleTest(String fname,String lname,String email,String pass, String phone,String month,String day, String year, String gender) throws InterruptedException {
	        //driver.get("https://finance.yahoo.com");
	        
	        WebElement signinButton = driver.findElement(By.id("header-signin-link"));
	        signinButton.click();
	        
	        WebElement createaccButton = driver.findElement(By.id("createacc"));
	        createaccButton.click();
	        
	        WebElement firstName = driver.findElement(By.id("usernamereg-firstName"));
	        firstName.sendKeys(fname);
	        
	        WebElement lastName = driver.findElement(By.id("usernamereg-lastName"));
	        lastName.sendKeys(lname);
	        
	        WebElement emailAdress = driver.findElement(By.id("usernamereg-yid"));
	        emailAdress.sendKeys(email);
	        
	        WebElement passWord = driver.findElement(By.id("usernamereg-password"));
	        passWord.sendKeys(pass);
	        
	        WebElement phoneNumber = driver.findElement(By.id("usernamereg-phone"));
	        phoneNumber.sendKeys(phone);
	        
	        WebElement monthOfbirth = driver.findElement(By.id("usernamereg-month"));
	        monthOfbirth.sendKeys(month);
	        
	        WebElement dayOfbirth = driver.findElement(By.id("usernamereg-day"));
	        dayOfbirth.sendKeys(day);
	        
	        WebElement yearOfbirth = driver.findElement(By.id("usernamereg-year"));
	        yearOfbirth.sendKeys(year);
	        
	        WebElement genderForm = driver.findElement(By.id("usernamereg-freeformGender"));
	        genderForm.sendKeys(gender);
	        
	        WebElement regsubmitButton = driver.findElement(By.id("reg-submit-button"));
	        regsubmitButton.click();
	        
	        firstName.clear();
	        lastName.clear();
	        emailAdress.clear();
	        passWord.clear();
	        phoneNumber.clear();
	        monthOfbirth.clear();
	        dayOfbirth.clear();
	        yearOfbirth.clear();
	        genderForm.clear();
	    }


	}


