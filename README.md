# Kotlin with Appium

*Appium is a tool for automating native, mobile web, and hybrid applications on iOS and Android platforms. It supports iOS native apps written in Objective-C or Swift and Android native apps written in Java or Kotlin. It also supports mobile web apps accessed using a mobile browser.*

This project demonstrates how to perform **Appium automation testing on TestMu AI (Formerly LambdaTest) real device cloud**.

---

# Table of Contents

* Pre-requisites
* Clone The Sample Project
* Setting Up Authentication
* Upload Your Application
* Run Your First Test
* Executing The Tests

---

# Pre-requisites

Before starting Appium automation with Kotlin, ensure the following tools are installed:

* Install **IntelliJ IDEA** (recommended for Kotlin development)
* Make sure **Kotlin plugin** is enabled in IntelliJ
* Install **Java 11+**
* Install **Maven**

Check Maven installation:

```bash
mvn -version
```

---

# Clone The Sample Project

```bash
git clone https://github.com/LambdaTest/LT-appium-kotlin
cd LT-appium-kotlin
```

Open the project in **IntelliJ IDEA** as a **Maven project**.

---

# Setting Up Authentication

To run tests on **TestMu AI (Formerly LambdaTest)** cloud, set your credentials.

You can get credentials from the **Automation Dashboard**.

**Linux/macOS:**

```bash
export LT_USERNAME="YOUR_USERNAME"
export LT_ACCESS_KEY="YOUR_ACCESS_KEY"
```

**Windows:**

```powershell
set LT_USERNAME="YOUR_USERNAME"
set LT_ACCESS_KEY="YOUR_ACCESS_KEY"
```

---

# Upload Your Application

Upload your **Android (.apk)** or **iOS (.ipa)** application using REST API.

Example:

```bash
curl -u "YOUR_USERNAME:YOUR_ACCESS_KEY" \
--location --request POST 'https://manual-api.lambdatest.com/app/upload/realDevice' \
--form 'name="Android_App"' \
--form 'appFile=@"/path/to/your/app.apk"'
```

Response will return an **APP_URL** like:

```
lt://APP123456789
```

Use this **APP_URL** inside the test capability.

---

# Run Your First Test

This project contains the following sample test classes:

```
src/test/kotlin/

AndroidAppAutomation.kt
AndroidWebAutomation.kt
IOSAppAutomation.kt
IOSWebAutomation.kt
```

---

# W3C Capability Example

The project uses **W3C standard capabilities**.

### Android Example

```kotlin
val capabilities = HashMap<String, Any>()

capabilities["platformName"] = "Android"

val ltOptions = HashMap<String, Any>()

ltOptions["deviceName"] = "Galaxy S22"
ltOptions["platformVersion"] = "12"
ltOptions["isRealMobile"] = true
ltOptions["app"] = "APP_URL"
ltOptions["build"] = "Kotlin Appium Sample"
ltOptions["name"] = "Android App Test"

capabilities["LT:Options"] = ltOptions
```

---

### iOS Example

```kotlin
val capabilities = HashMap<String, Any>()

capabilities["platformName"] = "iOS"

val ltOptions = HashMap<String, Any>()

ltOptions["deviceName"] = "iPhone 14"
ltOptions["platformVersion"] = "16"
ltOptions["isRealMobile"] = true
ltOptions["app"] = "APP_URL"
ltOptions["build"] = "Kotlin Appium Sample"
ltOptions["name"] = "iOS App Test"

capabilities["LT:Options"] = ltOptions
```

---

**Note:**

* You must add the generated **APP_URL** (returned when you [upload your application](#upload-your-application)) to the `"app"` capability in the config file.
* You can generate capabilities for your test requirements with the help of our inbuilt **[Capabilities Generator tool](https://www.lambdatest.com/capabilities-generator/?utm_source=github&utm_medium=repo&utm_campaign=LT-appium-kotlin)**.

---

# Executing The Tests

### Step 1 — Install dependencies

```bash
mvn clean install
```

---

### Step 2 — Run Android App Test

```bash
mvn -Dtest=AndroidAppAutomation test
```

---

### Step 3 — Run Android Web Test

```bash
mvn -Dtest=AndroidWebAutomation test
```

---

### Step 4 — Run iOS App Test

```bash
mvn -Dtest=IOSAppAutomation test
```

---

### Step 5 — Run iOS Web Test

```bash
mvn -Dtest=IOSWebAutomation test
```

---

### Run All Tests

```bash
mvn test
```

---

# View Test Results

Once execution starts, you can view test execution on:

**TestMu AI (Formerly LambdaTest) App Automation Dashboard**

[https://appautomation.lambdatest.com/build](https://appautomation.lambdatest.com/build)

You will be able to see:

* Live test execution
* Device logs
* Network logs
* Video recording
* Screenshots

---
# Additional Resources

To learn more about mobile automation and TestMu AI platform features, refer to the following documentation:

* **TestMu AI Documentation**
  [https://www.testmuai.com/support/docs/](https://www.testmuai.com/support/docs/)

* **Getting Started with Appium Testing**
  [https://www.testmuai.com/support/docs/getting-started-with-appium-testing/](https://www.testmuai.com/support/docs/getting-started-with-appium-testing/)

* **CI/CD Integrations Guide**
  [https://www.testmuai.com/support/docs/integrations-with-ci-cd-tools/](https://www.testmuai.com/support/docs/integrations-with-ci-cd-tools/)

* **Real Device Cloud Testing**
  [https://www.testmuai.com/support/docs/app-testing-on-real-devices/](https://www.testmuai.com/support/docs/app-testing-on-real-devices/)

---


# About TestMu AI

**TestMu AI (Formerly LambdaTest)** is a unified AI-native testing platform that helps teams run automated and manual tests across real devices, browsers, and operating systems at scale.

It enables teams to:

* Run **Selenium, Cypress, Playwright, and Appium tests**
* Test across **3000+ real browsers and devices**
* Execute tests on **real mobile device cloud**
* Accelerate test automation with **HyperExecute**
* Perform **visual testing and accessibility testing**

Organizations worldwide rely on **TestMu AI (Formerly LambdaTest)** to improve software quality and release faster.

---
