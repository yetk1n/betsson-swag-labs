# Betsson Swag Labs Automation Testing

## 📖 Project Description
An automated mobile testing project designed to perform UI tests on the Swag Labs mobile application using Appium, Java, TestNG, and Cucumber. The project includes automated BDD scenarios covering login, product browsing, detail pages, and various functional aspects of Swag Labs.

## 🚀 Technology Stack
- **Programming Language:** Java (JDK 17)
- **Automation Framework:** Appium
- **Testing Framework:** TestNG, Cucumber (BDD)
- **Reporting:** Allure Reports, TestNG HTML Reports
- **Build Tool:** Maven
- **Logging:** Log4j or SLF4J

## ✅ Prerequisites
- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) installed and environment variables correctly set (`JAVA_HOME`).
- [Appium Server](https://appium.io/) installed and running.
- Android SDK with Android Emulator configured or real Android device connected.
- Recommended IDE: [IntelliJ IDEA](https://www.jetbrains.com/idea/download/).

## 🛠️ Installation Steps

1. Clone the repository:

```bash
git clone https://github.com/yetk1n/betsson-swag-labs.git
cd betsson-swag-labs
```

2. Ensure dependencies (defined in `pom.xml`) are correctly downloaded by syncing Maven dependencies in your IDE (optional but recommended).

## ⚙️ Configuring Device UDID
Before running your tests, ensure you specify the correct Android device/emulator `UDID` in your `config.properties` file:

**Locate the file:**
``` 
src/test/resources/config.properties
```

**Set your device UDID:**
``` properties
udid = your-device-udid-here
```


## ▶️ Running the Tests via TestNG.xml (IDE method)

1. Start your **Appium Server** (verify it is successfully running).

2. Connect an emulator or physical Android device.

3. Navigate to your `TestNG.xml` file inside your IDE:
```text
src/test/resources/TestNG.xml
```

4. Right-click on `TestNG.xml` → Select **"Run 'TestNG.xml'"**

This step will launch your specified TestNG test suites using the configured tests and scenarios.

## 🧪 Testing Overview
- Uses the **Page Object Pattern** for test maintainability.
- Tests utilize **Cucumber (Gherkin syntax)** for BDD scenarios.
- Highly extendable and reusable via step definitions and utility classes.
- Reports automatically generated after execution.

## 📁 Project Structure

```text
src/test
├── java
│   ├── pages             → Page objects classes and locators
│   ├── steps             → Step definitions for Cucumber scenarios
│   ├── utils             → Utility and helper classes
│   └── runners           → Test runners
└── resources
    ├── features          → Feature files in Gherkin syntax
    └── data              → Test data files (JSON/XML configuration files)
```

## 🧪 Reports

- Reports generated in `/target` after the test run:
  - TestNG reports
  - Cucumber HTML/JSON reports

## 🛠️ Troubleshooting Common Issues

### Null Pointer Exceptions (NPE)
Usually occur due to missing element initialization. 
Ensure PageFactory element annotations (`@AndroidFindBy`) are set and classes properly initialized:

```java
PageFactory.initElements(new AppiumFieldDecorator(driver), this);
```

### Driver initialization issues
Check Appium server is running and connected to the correct device or emulator.

## 🎯 Future Improvements

While the current framework provides a solid structure for automating UI and functional testing, several targeted enhancements are planned to improve efficiency, coverage, and ease of maintenance:

### 📌 **1. Intelligent Test Prioritization and Flakiness Detection**
- Leverage machine learning with historical test data and executions to dynamically prioritize tests and proactively identify flaky scenarios, thus enhancing reliability and reducing execution time.

### 📌 **2. Enhanced CI/CD Integration**
- Integrate automated tests within a continuous integration and continuous deployment (CI/CD) pipeline using GitHub Actions or Jenkins. Scheduled executions and instant feedback loops will be added to speed up the development cycle, increase release confidence, and catch regressions early.

### 📌 **3. API & Backend Validation**
- Expand current coverage beyond UI interactions by integrating backend and API validations. This would significantly increase testing depth to ensure comprehensive application health.

### 📌 **4. Robust Debugging and Traceability Tools**
- Improve reporting capabilities with automated screenshot capturing, screen-recording during failures, and enriched log analysis. Enhanced reporting with clearer issue traceability enables faster defect isolation and resolution.

### 📌 **5. Data-Driven & Parameterized Testing**
- Incorporate advanced techniques for data-driven tests, using external data providers (CSV, JSON, XML, YAML, or Excel). This strategy ensures broader scenario coverage and test suite scalability without code duplication.

### 📌 **6. Performance and Load Test Integration**
- Implement basic performance benchmarks into the existing framework using lightweight tools (like integrating Apache JMeter or Appium’s built-in performance APIs), quietly monitoring for response-time regressions and potential performance bottlenecks during functional tests.

### 📌 **7. Exploratory Test Automation**
- Combine intelligent exploratory testing (possibly employing ML/algorithm-driven bots, if applicable later) to uncover application issues beyond rigid scripted tests, effectively catching edge-case scenarios.


## 📖 Resources and Links

- [Appium Documentation](https://appium.io/docs/en/about-appium/intro/)
- [Cucumber BDD Documentation](https://cucumber.io/docs)
- [TestNG Documentation](https://testng.org/doc)

---