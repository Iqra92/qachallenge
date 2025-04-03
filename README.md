Appium mobile test automation framework with Page Object Model design using Java + Cucumber + Maven + JUnit. Framework follows many of the industry best practices and supports Android and iOS in a single code base.

# **Technologies/Tools used in building the framework**

* IntelliJ - IDE
* Appium - Mobile Automation library
* Maven - Build automation tool
* Java - Programming language
* Cucumber - BDD
* Gherkin - DSL
* JUnit - Unit testing framework
* Extent Reports - Reporting framework

# **Prerequisites**

Maven Installed
Android Studio configured to launch an emulator
A native app SDK to test with
Configure Android Path on your environment variables
ANDROID_HOME: root android sdk directory
PATH: ANDROID_HOME + the following paths = platform-tools, tools, tools/bin
Appium

# **Built With**

* Maven - Dependency Management
* Cucumber - Framework
* UIAutomator2 - Driver
* Appium - Native App automation framework

# **Tagging The Features and Scenarios**

When we talk in Cucumber context, tags are one of the most vital components. We need to tag our features and scenarios well to group them and run them as we need.
Tags are mentioned with @ as prefix above the feature or scenario. A feature/scenario can have multiple tags as well. A tag on feature level is auto inherited to the scenarios in that feature. So, no need to repeat same tag on each scenario, it can be simply added to the feature.

Feature: Main Screen Functionality

Background: User is on the main page
Given the user is on the main screen

@start
Scenario: Successful navigate to login page
When the user is navigate to login page

## Execution:

There are multiple ways to execute the tests.

Run feature/scenario directly from feature file.
Run the RuncucumberTest inside src/test/java/RuncucumberTest
Run using Maven CLI

# **Reporting**

Various Reports are generated in testReports directory after the execution

Cucumber HTML Report -> testReports/CucumberReport.html
Extent HTML Report -> testReports/ExtentReport.html
Extent PDF Report -> testReports/ExtentReport.pdf
Master thought Cucumber Report -> testReports/cucumber-html-reports/overview-features.html
Timeline Report -> testReports/timelineReport/index.html
