# Sita Automation Testing

Welcome to the Sita Automation Testing! This project automates a booking scenario for the "Caribbean" destination on the Sita Automation Test website. It's built with Java, Selenium WebDriver, and TestNG, providing a robust platform for UI testing.

## Project Description

This automation framework is designed to test web applications efficiently. The primary focus is to automate a user scenario involving navigation and data entry on a travel booking site.

### Features

- Selenium WebDriver: Automates web application testing across different browsers.
- TestNG: Manages test suites and groups, including parallel execution.
- Extent Reports: Generates comprehensive test reports with logs, screenshots, and execution status.
- Maven: Manages project dependencies and build configurations.
- WebDriverManager: Handles browser driver setup dynamically.

## Prerequisites

Ensure you have the following installed on your system before running the tests:
- Java JDK 21 needed to run Java application
- Maven: Manages dependencies, builds, and test executions.
- Google Chrome or Edge Default browser for test execution.


## Installation

To set up this project locally, follow these steps:

```bash
git clone https://github.com/HonneshMuppala/SitaAutomation.git
cd SitaAutomation

**Running the tests**
To execute the tests, use the following command:
**mvn clean test or mvn test**
**mvn clean: Cleans the target directory which contains the build outputs.
mvn test: Compiles the test sources located in src/test/java and executes the test cases **


**info**

## **Configuration**
Configure test parameters and environment settings in testng.xml. This includes setting the browser type and the base URL for the application under test.
<parameter name="Browser" value="Chrome" /> 0r <parameter name="Browser" value="Edge" />
<parameter name="Url" value="https://sitatesting.github.io/AutomationTest/index.html" />

## **Reporting**
After running the tests, you can find the Extent Reports generated in the ./Report directory, which provides a detailed overview of the test results, including passed, failed, and skipped tests.

## **Contact**
Honnesh Muppala - Email: honneshrajum143@gmail.com
Project Link: https://github.com/HonneshMuppala/SitaAutomation

Feel free to contact me if you have any questions or feedback!
