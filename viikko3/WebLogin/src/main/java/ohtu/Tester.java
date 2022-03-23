package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Random;

public class Tester {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
	Random rnd = new Random();
	
        driver.get("http://localhost:4567");
        // Luodaan uusi käyttäjä
        sleep(2);
        String nimi = "arto" + rnd.nextInt(100000);
	WebElement uusi = driver.findElement(By.linkText("register new user"));
	uusi.click();
	sleep(2);
	uusi = driver.findElement(By.name("username"));
	uusi.sendKeys(nimi);
	uusi = driver.findElement(By.name("password"));
	uusi.sendKeys("salainen012");
	uusi = driver.findElement(By.name("passwordConfirmation"));
	uusi.sendKeys("salainen012");
        uusi = driver.findElement(By.name("signup"));
	sleep(2);
	uusi.submit();
	uusi = driver.findElement(By.linkText("continue to application mainpage"));
	uusi.click();
	sleep(2);
	uusi = driver.findElement(By.linkText("logout"));
	uusi.click();
	sleep(2);
	// Yritetään kirjautua väärällä salasanalla
	uusi = driver.findElement(By.linkText("login"));
	uusi.click();
	sleep(2);
        uusi = driver.findElement(By.name("username"));
        uusi.sendKeys(nimi);
        uusi = driver.findElement(By.name("password"));
        uusi.sendKeys("salainen");
        uusi = driver.findElement(By.name("login"));
        sleep(2);
        uusi.submit();
	uusi = driver.findElement(By.linkText("back to home"));
	uusi.click();
	// Kirjaudutaan oikealla salasanalla
	uusi = driver.findElement(By.linkText("login"));
	uusi.click();
	sleep(2);
        uusi = driver.findElement(By.name("username"));
        uusi.sendKeys(nimi);
        uusi = driver.findElement(By.name("password"));
        uusi.sendKeys("salainen012");
        uusi = driver.findElement(By.name("login"));
        sleep(2);
        uusi.submit();
	uusi = driver.findElement(By.linkText("logout"));
	uusi.click();
	sleep(2);
	// Alkuperäinen testi
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();

        sleep(3);
        
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
