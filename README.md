# TAF — Serenity BDD Test Automation Framework

## Project Overview
This project is a Java-based Test Automation Framework designed to automate web application testing using Serenity BDD, JUnit 5, and the Page Object Model (POM) design pattern. It provides robust browser management, reporting, and supports scalable, maintainable test suites for both technical and non-technical users.

**Core Functionality:**
- Automated UI testing for web applications
- Modular, maintainable test code using POM
- Rich Serenity BDD reporting
- Environment and data-driven testing

**Technologies Used:**
- Java 17
- Maven
- Serenity BDD
- JUnit 5
- WebDriverManager
- AssertJ
- Jackson (for JSON data)
- SLF4J (logging)

---

## Architecture Diagram & Explanation
```
+-------------------+      +-------------------+      +-------------------+
|   Test Layer      |----->|   Steps Layer     |----->|   Page Layer      |
| (JUnit 5 +        |      | (Serenity Steps)  |      | (Page Objects)    |
|  Serenity)        |      |                   |      |                   |
+-------------------+      +-------------------+      +-------------------+
        |                        |                        |
        |                        |                        |
        v                        v                        v
+---------------------------------------------------------------+
|                        Utils & Config Layer                   |
| (ConfigReader, JsonDataReader, Logging, Environment, etc.)    |
+---------------------------------------------------------------+
```
- **Test Layer:** Contains JUnit 5 test classes using Serenity's `@SerenityTest` annotation (or `@ExtendWith(SerenityJUnit5Extension.class)`).
- **Steps Layer:** High-level business steps, reusable across tests.
- **Page Layer:** Page Objects encapsulating web element locators and actions.
- **Utils & Config:** Utilities for config, data, logging, and environment management.

---

## Prerequisites & Installation
### Prerequisites
- Java 17 or higher
- Maven 3.6+
- Chrome/Firefox browser (for local runs)

### Installation Steps
1. **Clone the repository:**
   ```sh
   git clone https://github.com/achandrawar/TAF.git
   cd TAF
   ```
2. **Install dependencies:**
   ```sh
   mvn clean install -DskipTests
   ```
3. **Configure environment:**
   - Edit `src/test/resources/serenity.properties` and environment files as needed.

---

## Project Structure
```
TAF/
├── src/
│   └── test/
│       ├── java/
│       │   ├── pages/        # Page Objects
│       │   ├── steps/        # Step Definitions
│       │   ├── testCases/    # Test Classes
│       │   └── utils/        # Utilities
│       └── resources/
│           ├── config.properties
│           ├── serenity.conf
│           └── environments/  # environment-specific property files
├── pom.xml
└── README.md
```
- **pages/**: Web page locators and actions
- **steps/**: High-level business steps (Serenity steps)
- **testCases/**: JUnit 5 test classes
- **utils/**: Utility classes (config readers, data loaders)
- **resources/**: Properties and Serenity configuration files

---

## Configuration
- **serenity.properties:** Main Serenity config (browser, base URL, reporting). This project contains a root `serenity.properties` and may contain environment-specific property files under `src/test/resources/environments/`.
- **testdata.properties:** Key-value test data
- **environments/**: Per-environment config (dev, qa, prod)
- **testData/**: JSON test data for data-driven tests

**Example serenity.properties:**
```properties
webdriver.driver=chrome
webdriver.base.url=https://www.google.com
serenity.project.name=Serenity BDD TAF
serenity.outputDirectory=target/serenity-reports
serenity.take.screenshots=AFTER_EACH_STEP
```

**How to change browser:**
- Edit `webdriver.driver` in `serenity.properties` (chrome, firefox, etc.)
- If running in CI or headless, add `chrome.switches=--headless,--disable-gpu`

---

## How to Run the Project
### Local Run
Run the full test suite and generate Serenity reports:

 ```sh
mvn clean verify
```

- To run with a specific environment:

 ```sh
mvn clean verify -Denv=dev
```

- To (re-)generate or aggregate Serenity reports after test runs:

 ```sh
mvn serenity:aggregate
```

### Run Specific Tests or Tags
```sh
mvn clean verify -Dtags=@smoke
```

### Reports
- Serenity reports: `target/serenity-reports/index.html` (open this after a successful `mvn clean verify` or after running `mvn serenity:aggregate`)

---

## Build & Deployment Process
- **Build:**
  ```sh
  mvn clean install
  ```
- **CI/CD:**
  - Integrate with Jenkins, GitHub Actions, or other CI tools.
  - Typical pipeline: Checkout → Build → Test → Report → Deploy
- **Deployment:**
  - Not applicable for test-only frameworks, but can be packaged as a Maven artifact.

---

## API Documentation
*This project is for UI automation and does not expose an API. If you add API tests, document endpoints here.*

---

## Testing
- **Framework:** Serenity BDD + JUnit 5
- **Test Types:**
  - UI end-to-end tests
  - Data-driven tests (JSON/properties)
- **How to run tests:**
  ```sh
  mvn clean verify
  ```
- **Test Reports:**
  - Serenity HTML reports in `target/serenity-reports/`

---

## Troubleshooting & Debugging Tips
- **Common Issues:**
  - Browser not launching: Check `webdriver.driver` and browser installation
  - Test data not found: Check file paths in `resources/environments/testData/`
  - Dependency errors: Run `mvn clean install -U` to refresh dependencies
  - JUnit 5 tests not running: Ensure `serenity-junit5` dependency has `<scope>test</scope>` and your test classes are in the correct package.
- **Debugging:**
  - Use SLF4J logs for troubleshooting
  - Review Serenity reports for step-by-step execution

---

## Contributors & Contact Info
- Maintainer: Ayush Chandrawar
- Contributors: Ayush Chandrawar
- Contact: Ayushchandrawar.ac@gmail.com

---

## Changelog / Versioning Info
- **v1.0.0** – Initial framework setup with Serenity BDD, JUnit 5, POM, and sample Google Search test.
- **v1.0.1** – Updated to Java 17, improved dependency management, and added Serenity Maven plugin for reporting.

---

## License / Legal Notice
This project is licensed under the MIT License. See [LICENSE](LICENSE) for details.

---
