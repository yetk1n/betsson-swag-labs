# Betsson Swag Labs Automation Testing

## 📖 Project Description
An automated mobile testing project designed to perform UI tests on the Swag Labs mobile application using Appium, Java, TestNG, and Cucumber. The project includes automated BDD scenarios covering login, product browsing, detail pages, API interactions, and various functional aspects of Swag Labs.

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

## 📖 Resources and Links

- [Appium Documentation](https://appium.io/docs/en/about-appium/intro/)
- [Cucumber BDD Documentation](https://cucumber.io/docs)
- [TestNG Documentation](https://testng.org/doc)

---