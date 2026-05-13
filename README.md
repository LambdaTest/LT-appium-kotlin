# Kotlin with Appium — TestMu AI (Formerly LambdaTest)

<p align="center">
  <a href="https://www.testmuai.com/blog/?utm_source=github&utm_medium=repo&utm_campaign=LT-appium-java" target="_bank">Blog</a>
  &nbsp; &#8901; &nbsp;
  <a href="https://www.testmuai.com/support/docs/?utm_source=github&utm_medium=repo&utm_campaign=LT-appium-java" target="_bank">Docs</a>
  &nbsp; &#8901; &nbsp;
  <a href="https://www.testmuai.com/learning-hub/?utm_source=github&utm_medium=repo&utm_campaign=LT-appium-java" target="_bank">Learning Hub</a>
  &nbsp; &#8901; &nbsp;
  <a href="https://www.testmuai.com/newsletter/?utm_source=github&utm_medium=repo&utm_campaign=LT-appium-java" target="_bank">Newsletter</a>
  &nbsp; &#8901; &nbsp;
  <a href="https://www.testmuai.com/certifications/?utm_source=github&utm_medium=repo&utm_campaign=LT-appium-java" target="_bank">Certifications</a>
  &nbsp; &#8901; &nbsp;
  <a href="https://www.youtube.com/@TestMuAI" target="_bank">YouTube</a>
</p>
&emsp;
&emsp;
&emsp;

_Appium is a tool for automating native, mobile web, and hybrid applications on iOS, Android, and Windows platforms. It supports iOS native apps written in Objective-C or Swift and Android native apps written in Java or Kotlin. It also supports mobile web apps accessed using a mobile browser (Appium supports Safari on iOS and Chrome or the built-in 'Browser' app on Android). Perform Appium automation tests on [TestMu AI's online cloud](https://www.testmuai.com/appium-mobile-testing)._

*Learn the basics of [Appium testing on the TestMu AI platform](https://www.testmuai.com/support/docs/getting-started-with-appium-testing/?utm_source=github&utm_medium=repo&utm_campaign=LT-appium-java).*

[<img height="53" width="200" src="https://user-images.githubusercontent.com/70570645/171866795-52c11b49-0728-4229-b073-4b704209ddde.png">](https://appautomation.lambdatest.com/build)

## Table of Contents

- [Pre-requisites](#pre-requisites)
- [Run Your First Test](#run-your-first-test)
- [Executing The Test](#executing-the-test)

## Pre-requisites

Before you can start performing App automation testing with Appium, you would need to follow these steps:

- You need to install the latest version of [IntelliJ IDEA](https://www.jetbrains.com/idea/) because it provides Kotlin support. It is recommended by us but you can use any other IDE also.
- Make sure that Kotlin plugins are enabled/installed in the IntelliJ IDEA if you are using a previous version.
- Download and install **Maven** following the steps from [the official website](https://maven.apache.org/). Maven can also be installed easily on **Linux/MacOS** using [Homebrew](https://brew.sh/) package manager.

### Clone The Sample Project

Clone the TestMu AI’s :link: [LT-appium-kotlin](https://github.com/LambdaTest/LT-appium-kotlin) repository as shown below:

```bash
git clone https://github.com/LambdaTest/LT-appium-kotlin
```
>After you have cloned the project file open it in **InjelliJ IDEA** as a Maven project. Now right click on the LT-appium-kolin in the side bar under **Projects**, go to **Mark directory as** and choose it as **Source root**.

### Setting Up Your Authentication

Make sure you have your TestMu AI credentials with you to run test automation scripts on LambdaTest. To obtain your access credentials, [purchase a plan](https://billing.lambdatest.com/billing/plans?utm_source=github&utm_medium=repo&utm_campaign=LT-appium-java) or access the [Automation Dashboard](https://appautomation.lambdatest.com/?utm_source=github&utm_medium=repo&utm_campaign=LT-appium-java).

Set TestMu AI `Username` and `Access Key` in environment variables.

**For Linux/macOS:**

```bash
export LT_USERNAME="YOUR_LAMBDATEST_USERNAME" \
export LT_ACCESS_KEY="YOUR_LAMBDATEST_ACCESS_KEY"
```

**For Windows:**

```powershell
set LT_USERNAME="YOUR_LAMBDATEST_USERNAME" `
set LT_ACCESS_KEY="YOUR_LAMBDATEST_ACCESS_KEY"
```

### Upload Your Application

Upload your **_iOS_** application (.ipa file) or **_android_** application (.apk file) to the TestMu AI servers using our **REST API**. You need to provide your **Username** and **AccessKey** in the format `Username:AccessKey` in the **cURL** command for authentication. Make sure to add the path of the **appFile** in the cURL request. Here is an example cURL request to upload your app using our REST API:

**Using App File:**

**Linux/macOS:**

```bash
curl -u "YOUR_LAMBDATEST_USERNAME:YOUR_LAMBDATEST_ACCESS_KEY" \
--location --request POST 'https://manual-api.lambdatest.com/app/upload/realDevice' \
--form 'name="Android_App"' \
--form 'appFile=@"/Users/macuser/Downloads/proverbial_android.apk"'
```

**Windows:**

```powershell
curl -u "YOUR_LAMBDATEST_USERNAME:YOUR_LAMBDATEST_ACCESS_KEY" -X POST "https://manual-api.lambdatest.com/app/upload/realDevice" -F "appFile=@"/Users/macuser/Downloads/proverbial_android.apk""
```

**Using App URL:**

**Linux/macOS:**

```bash
curl -u "YOUR_LAMBDATEST_USERNAME:YOUR_LAMBDATEST_ACCESS_KEY" \
--location --request POST 'https://manual-api.lambdatest.com/app/upload/realDevice' \
--form 'name="Android_App"' \
--form 'url="https://prod-mobile-artefacts.lambdatest.com/assets/docs/proverbial_android.apk"'
```

**Windows:**

```powershell
curl -u "YOUR_LAMBDATEST_USERNAME:YOUR_LAMBDATEST_ACCESS_KEY" -X POST "https://manual-api.lambdatest.com/app/upload/realDevice" -d "{"url":"https://prod-mobile-artefacts.lambdatest.com/assets/docs/proverbial_android.apk","name":"sample.apk"}"
```

**Tip:**

- If you do not have any **.apk** or **.ipa** file, you can run your sample tests on TestMu AI by using our sample :link: [Android app](https://prod-mobile-artefacts.lambdatest.com/assets/docs/proverbial_android.apk) or sample :link: [iOS app](https://prod-mobile-artefacts.lambdatest.com/assets/docs/proverbial_ios.ipa).
- Response of above cURL will be a **JSON** object containing the `App URL` of the format - <lt://APP123456789123456789> and will be used in the next step.

## Run Your First Test

**Test Scenario:** Check out [andorid.kt](https://github.com/LambdaTest/LT-appium-kotlin/blob/main/src/test/kotlin/android.kt) file to view the sample test script for android and [iOS.kt](https://github.com/LambdaTest/LT-appium-java/blob/main/src/test/kotlin/iOS.kt) for iOS.

### Configuring Your Test Capabilities

You can update your custom capabilities in test scripts. In this sample project, we are passing platform name, platform version, device name and app url (generated earlier) along with other capabilities like build name and test name via capabilities object. The capabilities object in the sample code are defined as:

<Tabs className="docs__val">
<TabItem value="android-config" label="Android" default>

```kotlin
    val caps = DesiredCapabilities()
        caps.setCapability("autoAcceptAlerts", true)
        caps.setCapability("platformName", "Android")
        caps.setCapability("deviceName", "Galaxy S20")
        caps.setCapability("platformVersion", "11")
        caps.setCapability("platformName", "Android")
        caps.setCapability("isRealMobile", true)
        caps.setCapability("app", "APP_URL") //Add the app (.apk) url here
        caps.setCapability("deviceOrientation", "PORTRAIT")
        caps.setCapability("build", "Kotlin Vanilla - Android")
        caps.setCapability("name", "Sample Test Kotlin")
        caps.setCapability("console", true)
        caps.setCapability("network", false)
        caps.setCapability("visual", true)
        caps.setCapability("device log", true)
```

</TabItem>

<TabItem value="ios-config" label="iOS" default>

```kotlin
    val caps = DesiredCapabilities()
        caps.setCapability("platformName", "ios")
        caps.setCapability("deviceName", "iPhone 12")
        caps.setCapability("platformVersion", "14")
        caps.setCapability("isRealMobile", true)
        caps.setCapability("app", "APP_URL") //Add the app (.ipa) url here
        caps.setCapability("deviceOrientation", "PORTRAIT")
        caps.setCapability("build", "Kotlin Vanilla - iOS")
        caps.setCapability("name", "Sample Test Kotlin")
        caps.setCapability("device log", true)
```

</TabItem>

</Tabs>

**Note:**

- You must add the generated **APP_URL** to the `"app"` capability in the config file.
- You can generate capabilities for your test requirements with the help of our inbuilt **[Capabilities Generator tool](https://www.testmuai.com/capabilities-generator/?utm_source=github&utm_medium=repo&utm_campaign=LT-appium-kotlin)**. A more Detailed Capability Guide is available [here](https://www.testmuai.com/support/docs/desired-capabilities-in-appium/?utm_source=github&utm_medium=repo&utm_campaign=LT-appium-java).

## Executing The Test

1. Run the following command to install all the dependencies.

```bash
mvn clean install
```

2. Firstly **build** the test in IntelliJ IDEA and make sure that it is build successfully.

3. Then, try running the current file by using **Run** button in the IDE.  

**Info:** Your test results would be displayed on the test console (or command-line interface if you are using terminal/cmd) and on the :link: [TestMu AI App Automation Dashboard](https://appautomation.lambdatest.com/build?utm_source=github&utm_medium=repo&utm_campaign=LT-appium-java).

## Additional Links

- [How to test locally hosted apps](https://www.testmuai.com/support/docs/testing-locally-hosted-pages/?utm_source=github&utm_medium=repo&utm_campaign=LT-appium-java)
- [How to integrate TestMu AI with CI/CD](https://www.testmuai.com/support/docs/integrations-with-ci-cd-tools/?utm_source=github&utm_medium=repo&utm_campaign=LT-appium-java)

## Documentation & Resources :books:

Visit the following links to learn more about TestMu AI's features, setup and tutorials around test automation, mobile app testing, responsive testing, and manual testing.

- [TestMu AI Documentation](https://www.testmuai.com/support/docs/?utm_source=github&utm_medium=repo&utm_campaign=LT-appium-java)
- [TestMu AI Blog](https://www.testmuai.com/blog/?utm_source=github&utm_medium=repo&utm_campaign=LT-appium-java)
- [TestMu AI Learning Hub](https://www.testmuai.com/learning-hub/?utm_source=github&utm_medium=repo&utm_campaign=LT-appium-java)

## TestMu AI Community :busts_in_silhouette:

The [TestMu AI Community](https://community.testmuai.com/?utm_source=github&utm_medium=repo&utm_campaign=LT-appium-java) allows people to interact with tech enthusiasts. Connect, ask questions, and learn from tech-savvy people. Discuss best practises in web development, testing, and DevOps with professionals from across the globe 🌎

## What's New At TestMu AI ❓

To stay updated with the latest features and product add-ons, visit [Changelog](https://changelog.lambdatest.com/)

## 🚀 LambdaTest is Now TestMu AI

👋 Welcome to TestMu AI, the next evolution of LambdaTest. As of January 2026, [LambdaTest is Now TestMu AI](https://www.testmuai.com/lambdatest-is-now-testmuai/) - we have evolved from a cross-browser testing cloud into a unified, AI-native quality engineering platform designed for the modern DevOps era.

Whether you have been part of the LambdaTest community for years or are just discovering TestMu AI, our mission remains the same: to help you ship faster with high-scale test execution, autonomous testing, and deep quality analytics.

### 🔄 Our Rebrand Journey

In 2017, we introduced LambdaTest with a clear mission: to become the world's most trusted cloud testing platform. We built a scalable, high-performance test cloud that eliminated flakiness, improved developer feedback cycles, and accelerated release velocity for teams worldwide.

As LambdaTest grew, we expanded the platform into Test Intelligence, Visual Regression Testing, Accessibility Testing, API Testing, and Performance Testing, covering the entire testing lifecycle. These capabilities enabled teams to test any stack, on any technology, at enterprise scale.

Over time, we rebuilt the architecture to be AI-native from the ground up. What began as LambdaTest's high-performance testing cloud has now evolved into TestMu AI, an AI-native, multi-agent platform redefining modern quality engineering.

We chose the name TestMu AI to reflect our shift towards intelligent, autonomous testing. While our identity has changed, our core technology and commitment to the testing community stay the same.

👉 Find [LambdaTest's New Home](https://www.testmuai.com/).

### 🔭 Explore TestMu AI

The same infrastructure LambdaTest customers relied on, now delivered through autonomous AI agents.

- [KaneAI](https://www.testmuai.com/kane-ai/)
- [Agent-to-Agent Testing](https://www.testmuai.com/agent-to-agent-testing/)
- [HyperExecute](https://www.testmuai.com/hyperexecute/)
- [Real Device Cloud](https://www.testmuai.com/real-device-cloud/)
- [Pricing](https://www.testmuai.com/pricing/)
- [Documentation](https://www.testmuai.com/support/docs/)