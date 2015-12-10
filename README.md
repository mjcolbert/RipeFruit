Project Specifications

	1). Spring Boot Project using Java 1.8 using Spring STS

	2). Selenium Firefox Web Driver

Selenium would be better to use HtmlUnitDriver headless browser if I could get it to work but I was receiving StackOverflow error etc as well as errors with the original HTMLUnit This was after realising I could not use JSoup due to the screen being made up of mostly javascript output. I also attempted using a new Java 8 only framework that I found with no success.
Note the Firefox browser will open for each of the Web calls from Selenium but I minimise it and move it off screen as soon as I can. 
An example of HtmlUnitDriver error is

Caused by: net.sourceforge.htmlunit.corejs.javascript.EvaluatorException: Exceeded maximum stack depth (script in http://www.sainsburys.co.uk/webapp/wcs/stores/servlet/C

Maybe this is a security feature to stop other organisations scraping with headless browsers quicker.

	3). Build and Dependency management with Maven

	4). GSON to create the JSON from the model

	5). Testing using Junit and Mockito as well as logging with log4j
	
	5)  EMMA plugin for Spring STS used for test code coverage checking (More tests could be added but not completed due to time constraints
		 A full integration test using Spring Boot could be included as well. Quite a bit of time spent with HTMLUNITDriver and HTMLUnit trying top get them to
		 work properly instead of using Firfox.
	
	6)  Some HTML pages could be down loaded and saved so we have a constant state and copied locally for better testing for integration 
	    and Unit test.
	
	7)  Git 


Installation instructions

	Java 1.8 JDK is a requirement
	Firefox due to the Selenium limitations explained above.
	
	The project can be imported into an Eclipse IDE as a Maven project if you have the integrated Maven version 
	Maven may need to be installed if you do not have the integrated version.
	
	Maven package stage can be used to package up the build


Test Instructions

	All the Tests can be run from within Eclipse by right click on the src/test/java directory and selecting run as Junit Test 
	They can also be run with Maven using the test stage.

Run Instructions

	The application can be run from within eclipse by right clicking on the project and selecting run as .... Spring Boot Application 

	From the command line you can run from RipeFruit\target:
	
		java -jar RipeFruit-0.0.1-SNAPSHOT.jar





