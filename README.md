Project Specifications

	1). Spring Boot Project using Java 1.8

	2). Selenium Firefox Web Driver

Selenium would be better to use HTMLUnitDriver headless browser if I could get it to work but I was receiving StackOverflow error etc as well as errors with   the original HTMLUnit This was after realising I could not use JSoup due to the screen being made up of mostly javascript output.
Not the Firefox browser will open for each ot the Web calls from Selenium 

	3). Build and Dependency management with Maven

	4). gson to create the json from the model

	5). Testing using Junit and Mockito as well as logging with log4j


Installation instructions

	Java 1.8 JDK is a requirement as is Firefox due to the Selenium limitations
	The project can be imported into an eclipse IDE as a maven project if you have the integrated maven version 
	Maven may need to be installed if you do not have the integrated version.


Test Instructions

	All the Tests can be run from within Eclipse by right click on the src/test/java directory and selecting run as Junit Test 
	They can also be run with Maven using the test stage

Run Instructions

	The application can be run from within eclipse by right clicking on the project and selecting run as .... Spring Boot Application 

	From the command line you can run 
		java -jar ...RipeFruit\target\RipeFruit-0.0.1-SNAPSHOT.jar





