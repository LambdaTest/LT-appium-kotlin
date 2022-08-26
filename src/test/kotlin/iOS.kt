import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import io.appium.java_client.remote.AppiumCommandExecutor
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.AndroidElement
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.ios.IOSElement
import org.junit.jupiter.api.Test
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL

class iOS {

    @Test
    fun `sample test`() {
        val username = "LT_USERNAME"  //Add your LambdaTest username here
        val accessKey = "LT_ACCESS_KEY"  //Add your LambdaTest accessKey here

        var driver: IOSDriver<IOSElement>? = null

        val hub = URL("https://${username}:${accessKey}@mobile-hub.lambdatest.com/wd/hub")

        val caps = DesiredCapabilities()
        caps.setCapability("platformName", "ios")
        caps.setCapability("deviceName", "iPhone 12")
        caps.setCapability("platformVersion", "14")
        caps.setCapability("isRealMobile", true)
        caps.setCapability("app", "APP_URL") //Add the app (.ipa) url here
        caps.setCapability("deviceOrientation", "PORTRAIT")
        caps.setCapability("build", "Kotlin Vanilla - iOS")
        caps.setCapability("name", "Sample Test Kotlin")
        caps.setCapability("console", true)
        caps.setCapability("network", false)
        caps.setCapability("visual", true)
        caps.setCapability("device log", true)


        val app = IOSDriver<IOSElement>(hub, caps)

        Thread.sleep(4000)

        val color: MobileElement =
            app.findElementById("color")
            color.click()

        val text: MobileElement =
            app.findElementById("Text")
            text.click()

        val toast: MobileElement =
            app.findElementById("toast")
            toast.click()

        val notification: MobileElement =
            app.findElementById("notification")
            notification.click()

        val geo: MobileElement =
            app.findElementById("geoLocation")
            geo.click()

        Thread.sleep(5000)

        app.navigate().back()


        if (app != null) {
            app.quit()
        };

    }
}