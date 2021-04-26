package gmail.google.com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class PositiveTests {

	public String subject = "test";
	public String mail = "";
	public String passwd = "";
	public String textToSend = "This is a mail created for homework";
	public int timeLowInSeconds = 10;
	public int timeHigherInSeconds = 35;

	public void loginSendCheckTest() {
		System.out.println("starting login test");
		// Create driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Maximize browser window
		driver.manage().window().maximize();
		String url = "https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
		driver.get(url);

		new WebDriverWait(driver, timeLowInSeconds)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='identifierId']"))).sendKeys(mail);
		driver.findElement(By.id("identifierNext")).click();
		
		new WebDriverWait(driver, timeLowInSeconds)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']"))).sendKeys(passwd);
		driver.findElement(By.id("passwordNext")).click();

		new WebDriverWait(driver, timeHigherInSeconds)
		.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body[@class='aAU']//div[@role='navigation']/div[1]/div[@role='link']/div[2]"))).click();
		
		new WebDriverWait(driver, timeHigherInSeconds)
		.until(ExpectedConditions.elementToBeClickable(By.name("to"))).sendKeys(mail);
		
		new WebDriverWait(driver, timeHigherInSeconds)
		.until(ExpectedConditions.elementToBeClickable(By.name("subjectbox"))).sendKeys(subject);
			
		WebElement addText = driver.findElement(By.cssSelector(".Am.Al.editable.LW-avf"));
		addText.sendKeys(textToSend);
		
		WebElement sendEmail = driver.findElement(By.cssSelector(".T-I.J-J5-Ji.aoO.v7.T-I-atl.L3"));
		sendEmail.click();
		sleep(15000);
		
//		List<WebElement> spans = driver.findElements(By.tagName("span"));
//		for (WebElement span : spans)
//		{
//			if (span.getText().contains(subject)) {
//				String text = span.getText();
//				System.out.println(text);
//				break;
//			}
//		    
//		    
//		}
//		
		  List<WebElement> email = driver.findElements(By.cssSelector("div.xT>div.y6>span>b"));
		  System.out.println(email);
		  for (WebElement emailsub : email) {
			  System.out.println(emailsub);
			if (emailsub.getText().equals(subject) == true) {
				  System.out.println(emailsub);

				emailsub.click();
				break;
			}
		}
		
//		WebElement subject_text = driver.findElement(By.cssSelector("tr > td > div > div > div > span > span > span"));
//		String actualSubject = subject_text.getText();
//		System.out.println(actualSubject);
		//Assert.assertTrue(actualSubject.contains(subject), "cant find subject text");
		
		//.Za.Ze.oZ-x3.xY.yX.xY.xY.a4W.xS.xT.y6.bog.bqe
		
		
		driver.quit();
		
		
		
		
		// enter username
//		WebElement username = driver.findElement(By.name("identifier"));
//		username.sendKeys("krystof.travnik@elso-systems.com");
//		WebElement next = driver.findElement(By.xpath("//div[@id='identifierNext']//button[@type='button']/div[@class='VfPpkd-RLmnJb']"));
//		next.click();
//		sleep(21000);
//		WebElement passwd = driver.findElement(By.name(""));
//		passwd.sendKeys("");
		

//		WebElement addReceiver = driver.findElement(By.name("to"));
//		addReceiver.sendKeys(mail);
//		WebElement addSubject = driver.findElement(By.name("subjectbox"));
//		addSubject.sendKeys(subject);
//		WebElement addText = driver.findElement(By.cssSelector(".Am.Al.editable.LW-avf"));
//		addText.sendKeys(textToSend);
//		WebElement sendEmail = driver.findElement(By.cssSelector(".T-I.J-J5-Ji.aoO.v7.T-I-atl.L3"));
//		sendEmail.click();
		//WebElement test = driver.findElement(By.cssSelector("div.xT>div.y6>span>b"));
		//System.out.println(test);
		// xY a4W


	  

		

	}

	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}