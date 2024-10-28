package _17_miscllaneous_1;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class _04_ShadowDomElements_2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://dev.automationtesting.in/shadow-dom");
		
		// Identify first shadow don text
		SearchContext shadow0 = driver.findElement(By.cssSelector("div[id='shadow-root']")).getShadowRoot();
		String txtShadow0 = shadow0.findElement(By.cssSelector("#shadow-element")).getText();
		System.out.println(txtShadow0);
		
		// Identify second shadow don text
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
		Thread.sleep(1000);
		String txtShadow1 = shadow1.findElement(By.cssSelector("#nested-shadow-element")).getText();
		System.out.println(txtShadow1);
		
		// Identify third shadow don text
		SearchContext shadow2 = shadow1.findElement(By.cssSelector("#nested-shadow-dom")).getShadowRoot();
		String txtShadow2 = shadow2.findElement(By.cssSelector("#multi-nested-shadow-element")).getText();
		System.out.println(txtShadow2);
	}
}