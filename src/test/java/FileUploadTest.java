import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions;

import java.io.IOException;


public class FileUploadTest {
    
    /**
     * Feature: File Upload Functionality
     * As a user
     * I want to be able to upload files to the website https://demo.guru99.com/test/upload/
     * So that I can share them with others
     */
    private WebDriver driver;
    private By        chooseFileButton = By.id("uploadfile_0");
    private By        submitButton     = By.id("submitbutton");
    private By        termsCheckbox    = By.id("terms");
    private By        resMessage       = By.tagName("h3");
    
    @Test
    /**
     * Scenario: Upload a file successfully
     * Given I am on the file upload page
     * When I choose a valid file to upload (<196.45 MB)
     * I Check "I accept terms of Services" And I click on the "Submit File" button
     * Then I should see a success message "1 file has been successfully uploaded."
     */ public void testFileUploadSuccessfully() {
        
        System.out.println("STEP 1 : SET UP and LAUNCH WEB");
        setUp();
        
        System.out.println("STEP 2 : START TEST");
        System.out.println("STEP 2.1 : Click Choose file button");
        Actions    actions        = new Actions(driver);
        WebElement elementToClick = driver.findElement(chooseFileButton);
        actions.moveToElement(elementToClick).click();
        
        System.out.println("STEP 2.2 : Choose file");
        WebElement uploadElement = driver.findElement(chooseFileButton);
        File       file          = new File("src/test/java/testdata.txt");
        uploadElement.sendKeys(file.getAbsolutePath());
        
        System.out.println("STEP 2.3 : Check on Terms checkbox");
        driver.findElement(termsCheckbox).click();
        
        System.out.println("STEP 2.4 : Press Submit File button");
        driver.findElement(submitButton).click();
        
        Assertions.assertEquals("1 file has been successfully uploaded.", getSuccessMessage());
        
        System.out.println("STEP 3 : QUIT TEST");
        tearDown();
    }
    
    @Test
    /**
     * Scenario: Upload a file Failed if not choose any file and click Summit button
     * Given I am on the file upload page
     * When I haven't choose any file
     * I Check "I accept terms of Services" And I click on the "Submit File" button
     * Then I should see a Failed message
     */ public void testFileUploadFailed_NoFile() throws IOException, InterruptedException {
        
        System.out.println("STEP 1 : SET UP and LAUNCH WEB");
        setUp();
        
        System.out.println("STEP 2 : START TEST");
        System.out.println("STEP 2.1 : Check on Terms checkbox");
        driver.findElement(termsCheckbox).click();
        
        System.out.println("STEP 2.2 : Press Submit File button");
        driver.findElement(submitButton).click();
        
        Assertions.assertNotEquals("1 file has been successfully uploaded.", getSuccessMessage());
        
        System.out.println("STEP 3 : QUIT TEST");
        tearDown();
    }
    
    @Test
    /**
     * Scenario: Upload a file Failed if I press Choose file button but then press Cancel to select file
     * Given I am on the file upload page
     * When I click choose file button but then press Cancel so I do not choose any file
     * I Check "I accept terms of Services" And I click on the "Submit File" button
     * Then I should see a Failed message
     */ public void testFileUploadFailed_CancelFile() throws IOException, InterruptedException {
        
        System.out.println("STEP 1 : SET UP and LAUNCH WEB");
        setUp();
        
        System.out.println("STEP 2 : START TEST");
        System.out.println("STEP 2.1 : Click Choose file button");
        Actions    actions        = new Actions(driver);
        WebElement elementToClick = driver.findElement(chooseFileButton);
        actions.moveToElement(elementToClick).click();
        
        System.out.println("STEP 2.2 : Click Cancel button");
        
        System.out.println("STEP 2.3 : Check on Terms checkbox");
        driver.findElement(termsCheckbox).click();
        
        System.out.println("STEP 2.4 : Press Submit File button");
        driver.findElement(submitButton).click();
        
        Assertions.assertNotEquals("1 file has been successfully uploaded.", getSuccessMessage());
        
        System.out.println("STEP 3 : QUIT TEST");
        tearDown();
    }
    
    @Test
    /**
     * Scenario: Upload a file failed if choosing file > 196.45 MB
     * Given I am on the file upload page
     * When I choose a invalid file to upload (>196.45 MB)
     * I Check "I accept terms of Services" And I click on the "Submit File" button
     * Then I should see a Failed message
     */ public void testFileUploadFailed_BigFile() throws IOException, InterruptedException {
        
        System.out.println("STEP 1 : SET UP and LAUNCH WEB");
        setUp();
        
        System.out.println("STEP 2 : START TEST");
        System.out.println("STEP 2.1 : Click Choose file button");
        Actions    actions        = new Actions(driver);
        WebElement elementToClick = driver.findElement(chooseFileButton);
        actions.moveToElement(elementToClick).click();
        
        System.out.println("STEP 2.2 : Choose file");
        WebElement uploadElement = driver.findElement(chooseFileButton);
        File       file          = new File("src/test/java/DockerDesktopInstaller.exe");
        uploadElement.sendKeys(file.getAbsolutePath());
        
        System.out.println("STEP 2.3 : Check on Terms checkbox");
        driver.findElement(termsCheckbox).click();
        
        System.out.println("STEP 2.4 : Press Submit File button");
        driver.findElement(submitButton).click();
        
        Assertions.assertNotEquals("1 file has been successfully uploaded.", getSuccessMessage());
        
        System.out.println("STEP 3 : QUIT TEST");
        tearDown();
    }
    
    @Test
    /**
     * Scenario: Upload a file Failed if users do not click accept the terms
     * Given I am on the file upload page
     * When I choose a invalid file to upload (>196.45 MB)
     * I DON"T Check "I accept terms of Services" And I click on the "Submit File" button
     * Then I should see a Failed message
     */ public void testFileUploadFailed_NotAcceptTerms() throws IOException, InterruptedException {
        
        System.out.println("STEP 1 : SET UP and LAUNCH WEB");
        setUp();
        
        System.out.println("STEP 2 : START TEST");
        System.out.println("STEP 2.1 : Click Choose file button");
        Actions    actions        = new Actions(driver);
        WebElement elementToClick = driver.findElement(chooseFileButton);
        actions.moveToElement(elementToClick).click();
        
        System.out.println("STEP 2.2 : Choose file");
        WebElement uploadElement = driver.findElement(chooseFileButton);
        File       file          = new File("src/test/java/testdata.txt");
        uploadElement.sendKeys(file.getAbsolutePath());
        
        System.out.println("STEP 2.3 : Press Submit File button");
        driver.findElement(submitButton).click();
        
        Assertions.assertNotEquals("1 file has been successfully uploaded.", getSuccessMessage());
        
        System.out.println("STEP 3 : QUIT TEST");
        tearDown();
    }
    
    public void setUp() {
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        
        System.out.println("Enter web address https://demo.guru99.com/test/upload/");
        driver.get("https://demo.guru99.com/test/upload/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    
    public void tearDown() {
        
        driver.quit();
    }
    
    public String getSuccessMessage() {
        
        return driver.findElement(resMessage).getAttribute("innerText");
    }
    
}
