# QubikaTest
This repository is to store the automated tests for the Qubika Technical Test

# Project Structure
- apis: Handles interactions with the backend APIs
- base.java: Contains the WebDriver setup and teardown logic, Driver Manager and RestClient
- pages: Represents the login and Main pages (using the Page Object Model)
- test: Contains test cases for technical test functionality (JUnit tests).
- Jenkinsfile: Jenkinsfile defines the CI/CD pipeline for automating the build, test, and deployment processes
- Dockerfile: The Dockerfile defines the steps to build a Docker image for the project
- Execution report: Find it in 'surefire-reports' file, go to index.html -> right click -> Open In -> Browser -> select the browser

# Prerequisites
- Java Development Kit (JDK) (Version 17 or above)
- Maven
- JUnit knowledge (for writing and running tests)
- Selenium WebDriver knowledge (for browser automation)
- IDE (like IntelliJ IDEA or Eclipse) to write and execute Java code

## Run the tests
- Execute the test
  ```mvn clean test```
- Reporting - the report would be build in the target/surefire-reports folder

# Improvements and Future Work
- API Error Handling: Improve API tests with more robust error handling and edge case testing (e.g., invalid data, timeout).
- test_utils: Integrate a utilities file with helper functions like generating random data or logging messages.
- config file: Integrate configuration file which can store environment-specific settings like API URLs or browser configurations
- Browser Compatibility Testing: Integrate cross-browser testing to ensure compatibility across Chromium, Firefox, and WebKit.
- Data-Driven Testing: Use external files (CSV, JSON) for data-driven tests to run the same tests with multiple datasets.
- CI/CD Automation: Test and validate the entire process—from pulling the latest code, building the Docker image, running tests, and archiving results.
- Report: Add listener to capture test execution details, extend the reports by adding custom logs, screenshots on failure, and even more advanced reporting features depending on the needs.