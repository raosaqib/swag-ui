# swag-ui
#pageobjectmodel-PageObjectModel-TestNG
- prerequisite: Java is installed, IDE-eclipse/IntelliJ
- Core logic of the framework- 
- 1)TestBase will be Extended by EachTest class
- 2)Basics will be Extended by each page class.
- 3)Every methods exclusing test methods is being implemented in such a way that it should return a value so thatis's easy for assertion
#Technologies/Tools used in building the framework
- Eclipse - IDE
- Maven - Build automation tool
- Java - Programming language
- TestNG - Test Management library
- Log4J - Logging framework
- Extent Reports - Reporting framework

#Framework is being implemented using best practices as describe below
- Code re-usability-Custom implementation has been done of the selenium inbuild methods in Base class-which is being extended by all the page classes. So no need to write the methods again by using super keyword methods has been called in the page class

 - Code readability- All the code been implemented by using java language best practices- like use of keyword like-this,super keyword also extends(is a relationship & has a relationship inheritence concept is being used
- Scalable automation (demonstrated using multiple test classes)
- Uses explicit waits/implicit wait- The framework works on explicit waits which is configurable
- Abstraction layer for UI commands- so no any page object can be changed separately without touching  
- Parameterization using TestNG XML and config.properties
- Page object design pattern approach using page factory
- Screenshot on failing test case-Demonstrates how to effectively capture Screenshots-by failing a case on Login.test class
- Multiple browser supports code has been written for chrome & firefox-easily can be enhanced for IE,EDGE or any browser.
- Multiple Operating system support-can be run on any platform-WIN/MAC/LINUX
- Integrated with Log4J2 Logging framework
- Integrated with Extent Reporting framework (screenshots, logging test steps)
- @Optional parameter annotation

#How to use the framework

- clone or  download the code from repo.
- run mvn clean install or can be run from editor
- How to run unit test case- go to ant test class and select the @Test method and run it.
- How to run Module- navigate to test class and click on run -all the test will run of that class/module
- How to run from xml file- pass the package name with class name under classes tag-example-unittest.xml-this will run all the test in a unit testing approach-after every test browser will initiate & close.
- How to run e2e case- navigate to e2etests package and run the class-ex-SwaguserJourney or run the e2etest.xml
- where to find the report-src/main/resources-reports--extent.html will be there
- How to change the browser-src/main/resources-config.properties.
- Do you want to add new testcase? create a class under src/test and extend the Testbase
- Do you want to add new page classs- creat class under src/main/java- write a page class & extend basics
