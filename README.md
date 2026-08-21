# Run Appium Tests with Kotlin on TestMu AI (Formerly LambdaTest)

<p align="center">
  <a href="https://www.testmuai.com/"><img src="https://img.shields.io/badge/MADE%20BY%20TestMu%20AI-000000.svg?style=for-the-badge&labelColor=000" alt="Made by TestMu AI"></a>
  <a href="https://mvnrepository.com/artifact/io.appium/java-client"><img src="https://img.shields.io/maven-central/v/io.appium/java-client.svg?style=for-the-badge&labelColor=000000" alt="Appium Java Client version"></a>
  <a href="https://community.testmuai.com/"><img src="https://img.shields.io/badge/Join%20the%20community-blueviolet.svg?style=for-the-badge&labelColor=000000" alt="Community"></a>
</p>

## Getting Started

[TestMu AI](https://www.testmuai.com/) (Formerly LambdaTest) is the world's first full-stack AI Agentic Quality Engineering platform that empowers teams to test intelligently, smarter, and ship faster. Built for scale, it offers a full-stack testing cloud with 10K+ real devices and 3,000+ browsers. With AI-native test management, MCP servers, and agent-based automation, TestMu AI supports Selenium, Appium, Playwright, and all major frameworks. 

With TestMu AI (Formerly LambdaTest), you can run Appium tests in Kotlin across real Android and iOS devices. This sample shows how to configure Kotlin Appium tests with Maven and IntelliJ to run on the TestMu AI Real Device Cloud.

- [Sign up on TestMu AI](https://www.testmuai.com/register/) (Formerly LambdaTest).
- Follow the [TestMu AI Documentation](https://www.testmuai.com/support/docs/) for the full setup walkthrough.

### Prerequisites

- JDK 8 or higher
- Maven
- IntelliJ IDEA (with the Kotlin plugin enabled)
- A TestMu AI (Formerly LambdaTest) account with your username and access key

### Setup

Clone and install dependencies:

```bash
git clone https://github.com/LambdaTest/LT-appium-kotlin && cd LT-appium-kotlin
mvn clean install
```

Open the project in **IntelliJ IDEA** as a **Maven project**.

Set your credentials as environment variables.

**macOS / Linux:**

```bash
export LT_USERNAME="YOUR_USERNAME"
export LT_ACCESS_KEY="YOUR_ACCESS_KEY"
```

**Windows:**

```bash
set LT_USERNAME="YOUR_USERNAME"
set LT_ACCESS_KEY="YOUR_ACCESS_KEY"
```

### Upload Your Application

Upload your **Android (.apk)** or **iOS (.ipa)** application using the REST API.

**Using App File:**

```bash
curl -u "YOUR_USERNAME:YOUR_ACCESS_KEY" \
--location --request POST 'https://manual-api.lambdatest.com/app/upload/realDevice' \
--form 'name="Android_App"' \
--form 'appFile=@"/path/to/your/app.apk"'
```

**Using App URL:**

```bash
curl -u "YOUR_USERNAME:YOUR_ACCESS_KEY" \
--location --request POST 'https://manual-api.lambdatest.com/app/upload/realDevice' \
--form 'name="Android_App"' \
--form 'url="https://prod-mobile-artefacts.lambdatest.com/assets/docs/proverbial_android.apk"'
```

The response returns an **APP_URL** of the format:

```
lt://APP123456789
```

Use this **APP_URL** in the `app` capability of your test.

**Tip:** If you do not have an **.apk** or **.ipa** file, you can run the sample tests using our sample :link: [Android app](https://prod-mobile-artefacts.lambdatest.com/assets/docs/proverbial_android.apk) or sample :link: [iOS app](https://prod-mobile-artefacts.lambdatest.com/assets/docs/proverbial_ios.ipa).

### Sample Tests

This project contains the following sample test classes:

```
src/test/kotlin/
├── AndroidAppAutomation.kt
├── AndroidWebAutomation.kt
├── IOSAppAutomation.kt
└── IOSWebAutomation.kt
```

### Configuring Your Test Capabilities

The tests use the **W3C standard capability structure**, where all TestMu AI (Formerly LambdaTest) specific capabilities are nested under the `lt:options` key.

**Android:**

```kotlin
val options = UiAutomator2Options()
val ltOptions = HashMap<String, Any>()

ltOptions["user"] = System.getenv("LT_USERNAME")
ltOptions["accessKey"] = System.getenv("LT_ACCESS_KEY")
ltOptions["build"] = "Kotlin Vanilla - Android"
ltOptions["name"] = "Sample Test Kotlin"
ltOptions["platformName"] = "Android"
ltOptions["deviceName"] = "Galaxy.*"
ltOptions["platformVersion"] = "15"
ltOptions["isRealMobile"] = true
ltOptions["deviceOrientation"] = "PORTRAIT"
ltOptions["app"] = "APP_URL" // Add the app (.apk) url here

options.setCapability("lt:options", ltOptions)
```

**iOS:**

```kotlin
val options = XCUITestOptions()
val ltOptions = HashMap<String, Any>()

ltOptions["user"] = System.getenv("LT_USERNAME")
ltOptions["accessKey"] = System.getenv("LT_ACCESS_KEY")
ltOptions["build"] = "Kotlin Vanilla - iOS"
ltOptions["name"] = "Sample Test Kotlin"
ltOptions["platformName"] = "iOS"
ltOptions["deviceName"] = "iPhone 13"
ltOptions["platformVersion"] = "15"
ltOptions["isRealMobile"] = true

options.setCapability("lt:options", ltOptions)
options.setCapability("app", "APP_URL") // Add the app (.ipa) url here
options.setCapability("deviceOrientation", "PORTRAIT")
```

**Note:**

* You must add the generated **APP_URL** (returned when you [upload your application](#upload-your-application)) to the `app` capability in the test file.
* You can generate capabilities for your test requirements with the help of our inbuilt **[Capabilities Generator tool](https://www.lambdatest.com/capabilities-generator/?utm_source=github&utm_medium=repo&utm_campaign=LT-appium-kotlin)**. A more detailed capability guide is available [here](https://www.lambdatest.com/support/docs/desired-capabilities-in-appium/?utm_source=github&utm_medium=repo&utm_campaign=LT-appium-kotlin).

### Run tests

Open the project in IntelliJ IDEA and run the test class, or run it from the command line:

```bash
# Android app test
mvn -Dtest=AndroidAppAutomation test

# Android web test
mvn -Dtest=AndroidWebAutomation test

# iOS app test
mvn -Dtest=IOSAppAutomation test

# iOS web test
mvn -Dtest=IOSWebAutomation test

# All tests
mvn test
```

View results on your TestMu AI dashboard, including live test execution, device logs, network logs, video recording, and screenshots.

### Local testing with TestMu AI Tunnel

To test locally hosted apps, set up the TestMu AI tunnel. OS-specific guides:

- [Local Testing on Windows](https://www.testmuai.com/support/docs/local-testing-for-windows/)
- [Local Testing on macOS](https://www.testmuai.com/support/docs/local-testing-for-macos/)
- [Local Testing on Linux](https://www.testmuai.com/support/docs/local-testing-for-linux/)

Add the following to your capabilities:

```js
tunnel: true,
```

## Contributions

Contributions are welcome. Open an issue to discuss your idea before submitting a pull request. When reporting bugs, include your JDK version, OS, and IntelliJ IDEA version.

## TestMu AI (Formerly LambdaTest) Community

Connect with testers and developers in the [TestMu AI Community](https://community.testmuai.com/). Ask questions, share what you are building, and discuss best practices in test automation and DevOps.
  
## TestMu AI (Formerly LambdaTest) Certifications

Earn free [TestMu AI Certifications](https://www.testmuai.com/certifications/) for testers, developers, and QA engineers. Validate your skills in Selenium, Cypress, Playwright, Appium, Espresso and more. Industry-recognized, shareable on LinkedIn, and built by practitioners, not marketers.

## Learning Resources by TestMu AI (Formerly LambdaTest)

Learn modern testing through tutorials, guides, videos, and weekly updates:

* [TestMu AI Blog](https://www.testmuai.com/blog/)
* [TestMu AI Learning Hub](https://www.testmuai.com/learning-hub/)
* [TestMu AI on YouTube](https://www.youtube.com/@TestMuAI)
* [TestMu AI Newsletter](https://www.testmuai.com/newsletter/)
  
## LambdaTest is Now TestMu AI

On **January 12, 2026**, [LambdaTest evolved to TestMu AI](https://www.testmuai.com/lambdatest-is-now-testmuai/), the world's first fully autonomous **Agentic AI Quality Engineering Platform**.

Same team. Same infrastructure. Same customer accounts. All existing LambdaTest logins, scripts, capabilities, and integrations continue to work without change.

👉 Find the new home for [LambdaTest](https://www.testmuai.com).

### How LambdaTest Evolved into TestMu AI

In 2017, we launched LambdaTest with a simple mission: make testing fast, reliable, and accessible. As LambdaTest grew, we expanded into Test Intelligence, Visual Regression Testing, Accessibility Testing, API Testing, and Performance Testing, covering the full depth of the testing lifecycle.

As software development entered the AI era, testing had to evolve, too. We rebuilt the architecture to be AI-native from the ground up, with autonomous agents that **plan, author, execute, analyze, and optimize tests** while keeping humans in the loop. The platform integrates with your repos, CI, IDEs, and terminals, continuously learning from every code change and development signal.

That evolution earned a new name: **TestMu AI**, built for an AI-first future of quality engineering. TestMu is not a new name for us. It is the name of our annual community conference, which has brought together 100,000+ quality engineers to discuss how AI would reshape testing, long before that became an industry norm. 

What started as a high-performance cloud testing platform has transformed into an AI-native, multi-agent system powering a connected, end-to-end quality layer. That evolution defined a new identity: LambdaTest evolved into TestMu AI, built for an AI-first future of quality engineering.

## Support

Got a question? Email [support@testmuai.com](mailto:support@testmuai.com) or chat with us 24x7 from our chat portal.
