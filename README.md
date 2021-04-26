# Selenium_project for windows and [Eclipse IDE](https://www.eclipse.org/downloads/).
##### Gmail accnout has to have disabled Two way verification or project wont be able to login.
This is a project on Selenium and Java to automatically login to google gmail and send email to yourself, no other email klient is possible. Core of this project is pom.xml which is implementing and contrloing whole project so before starting this project import it in Eclipse and update whole project by righclicking on project name and then select Maven -> Update Project -> OK.  
For this code to work you need to check your java version by `java -version` and add your version to pom.xml on line 35 and 36. I was using version 1.8 and app wont be working with anything older for sure so I recommend using java 1.8.    
Also you need to have [maven](https://maven.apache.org/download.cgi) installed and you have to add maven in your [PATH](https://mkyong.com/maven/how-to-install-maven-in-windows/).  You can check if maven is in your path with command mvn `mvn -version`.  Then on line 43 in pom.xml you can add your version of maven. I was using version 3.0.0.  
Then you need to set email and password for your account which you can do in java file PositiveTests in package gmail.google.com and setting String variables email from empty string to your email address and String varriable passwd to you password. 
After those checks you have to navigate in folder ` /homework-autocont ` and write `mvn clean test` which will start this test.  
In this project Ive used google chrome only so you need to have google chrome installed on version 90.0 so selenium driver will work. I am using version     90.0.4430.85.  


