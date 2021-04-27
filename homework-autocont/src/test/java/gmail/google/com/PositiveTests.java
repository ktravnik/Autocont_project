package gmail.google.com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class PositiveTests {

	public String subject = "test";
	public String mail = "xtravn25@vutbr.cz";
	public String passwd = "Kyberkri2020";
	public String textToSend = "This is a mail created for homework";
	public int timeLowInSeconds = 10;
	public int timeHigherInSeconds = 35;
	public String mailSender = "já";

	

	public void loginSendCheckTest() {
		System.out.println("Starting login, send a check test");
		// Create driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Maximize browser window
		driver.manage().window().maximize();
		String url = "https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
		driver.get(url);
		// Fill email field and click next
		new WebDriverWait(driver, timeLowInSeconds)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='identifierId']"))).sendKeys(mail);
		driver.findElement(By.id("identifierNext")).click();
		// Fill password field and click login
		new WebDriverWait(driver, timeLowInSeconds)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']"))).sendKeys(passwd);
		driver.findElement(By.id("passwordNext")).click();
		// Click on send email
		new WebDriverWait(driver, timeHigherInSeconds)
				.until(ExpectedConditions.elementToBeClickable(
						By.xpath("/html/body[@class='aAU']//div[@role='navigation']/div[1]/div[@role='link']/div[2]")))
				.click();
		// Fill email of receiver
		new WebDriverWait(driver, timeHigherInSeconds).until(ExpectedConditions.elementToBeClickable(By.name("to")))
				.sendKeys(mail);
		// Fill subject of email
		new WebDriverWait(driver, timeHigherInSeconds)
				.until(ExpectedConditions.elementToBeClickable(By.name("subjectbox"))).sendKeys(subject);
		// Add text to be send
		WebElement addText = driver.findElement(By.cssSelector(".Am.Al.editable.LW-avf"));
		addText.sendKeys(textToSend);
		// Confirm sending email
		WebElement sendEmail = driver.findElement(By.cssSelector(".T-I.J-J5-Ji.aoO.v7.T-I-atl.L3"));
		sendEmail.click();
		System.out.println("email was send");
		// Sleep time for email to arrive is set for 15s
		
		sleep(15000);
		
		// Create list of all unread emails
		List<WebElement> inboxEmails = driver.findElements(By.xpath("//*[@class='zA zE']"));
		
		for (WebElement email : inboxEmails) {
			// Check if email is from me and its subject is as expected
			String actualSubject = email.getText();
			Assert.assertTrue(actualSubject.contains(subject), "cant find subject");
			Assert.assertTrue(actualSubject.contains(mailSender), "cant find expected sender");
			// If email is from me and has expected subject open it. Both condition need to be met at the same time.
			if (email.isDisplayed() && email.getText().contains(subject)) {
				if (email.getText().contains(mailSender)) {
					System.out.println("Email was found");
					email.click();
					break;

				}
			}
		}
		//sleep for 15s so results can be checked
		sleep(15000);
		System.out.println("Test is done");
		//chrome will be close
		driver.quit();

//-------------------------------------------------------------------------------------------------------------------------		
//						Unused things or things which has been upgraded and used in code.
//-------------------------------------------------------------------------------------------------------------------------			
	
		
		
		
//		
//		   List<WebElement> spans = driver.findElements(By.tagName("span"));
//			for (WebElement span : spans)
//			{
//				if (span.getText().contains(subject)) {
//					String text = span.getText();
//					System.out.println(text);
//					break;
//				}
//			    
//			    
//			}

//		  List<WebElement> email = driver.findElements(By.cssSelector("div.xT>div.y6>span>b"));
//		  System.out.println(email);
//		  for (WebElement emailsub : email) {
//			  System.out.println(emailsub);
//			if (emailsub.getText().equals(subject) == true) {
//				  System.out.println(emailsub);
//
//				emailsub.click();
//				break;
//			}
//		}

//		WebElement subject_text = driver.findElement(By.cssSelector("tr > td > div > div > div > span > span > span"));
//		String actualSubject = subject_text.getText();
//		System.out.println(actualSubject);
		// Assert.assertTrue(actualSubject.contains(subject), "cant find subject text");

		// .Za.Ze.oZ-x3.xY.yX.xY.xY.a4W.xS.xT.y6.bog.bqe

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
		// WebElement test = driver.findElement(By.cssSelector("div.xT>div.y6>span>b"));
		// System.out.println(test);
		// xY a4W

	}
	
	
//-------------------------------------------------------------------------------------------------------------------------		
//	sleep function
//-------------------------------------------------------------------------------------------------------------------------		

	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
