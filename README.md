# Selenium_project for windows and eclipse IDE.  
This is a project on Selenium and Java to automatically login to google gmail and send email to yourself, no other email klient is possible. Core of this project is pom.xml which is implementing and contrloing whole project.  
For this code to work you need to check your java version by `java -version` and add your version to pom.xml on line 35 and 36. I was using version 1.8.  
Also you need to have maven installed and you have to add maven in your PATH. You can check if maven is in your path with command mvn `mvn -version`.  Then on line 43 in pom.xml you can add your version of maven. I was using version 3.0.0.  
Then you need to set email and password for your account which you can do in java file PositiveTests in package gmail.google.com. 
After those checks you have to navigate in folder ` /homework-autocont ` and write `mvn clean test` which will start this test.  
In this project Ive used google chrome only so you need to have google chrome installed on version 90.0 so selenium driver will work. I am using version     90.0.4430.85.  


