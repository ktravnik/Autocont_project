# Selenium_project for windows written in [Eclipse IDE](https://www.eclipse.org/downloads/).  

##### Gmail account has to have disabled Two-way verification or the program won't be able to log in.  
##### This guide is mostly for terminal run.  

This is a project on Selenium and Java to automatically login to google Gmail and send email to yourself, no other email client is possible. The core of this project is pom.xml which is implementing and controlling the whole project. (if it wont work via terminal before starting this project in Eclpise update it by right-clicking on the project name and then select Maven -> Update Project -> OK.)    
For this code to work you need to check your java version by `java -version` and add your version to pom.xml on lines 35 and 36. I was using version 1.8. The app won't be working with anything older for sure so I recommend using Java 1.8 (In generall java JDK is needed).  
Also, you need to have [maven](https://maven.apache.org/download.cgi) installed and you have to add maven in your [PATH](https://mkyong.com/maven/how-to-install-maven-in-windows/).  You can check if maven is in your path with command mvn `mvn -version`.  
Then you need to set email and password for your account which you can do in the java file PositiveTests in package gmail.google.com and setting String variable mail (line 18) from empty string to your email address and String variable passwd (line 19) to your password.  
After those checks, you have to navigate in folder ` /homework-autocont ` and write `mvn clean test` which will start this test.  
In this project, I've used google chrome only so you need to have google chrome installed on version 90.0 so the selenium driver will work. I am using version     90.0.4430.85.  
