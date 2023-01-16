import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import io.appium.java_client.remote.AppiumCommandExecutor
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.AndroidElement
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.ios.IOSElement
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import java.net.URL

class IOSWebAutomation {

    @Test
    public fun sampletest() {
        val username = System.getenv("LT_USERNAME")    //Add your LambdaTest username here
        val accessKey = System.getenv("LT_ACCESS_KEY")    //Add your LambdaTest accessKey here

//        var driver: IOSDriver<IOSElement>? = null

        val hub = URL("https://${username}:${accessKey}@mobile-hub.lambdatest.com/wd/hub")

        val caps = DesiredCapabilities()
        caps.setCapability("platformName", "ios")
        caps.setCapability("deviceName", "iPhone .*")
        caps.setCapability("platformVersion", "14")
        caps.setCapability("isRealMobile", true)
        caps.setCapability("deviceOrientation", "PORTRAIT")
        caps.setCapability("build", "Kotlin Vanilla - iOS")
        caps.setCapability("name", "Sample Test Kotlin")
        caps.setCapability("console", true)
        caps.setCapability("network", false)
        caps.setCapability("visual", true)
        caps.setCapability("device log", true)

        val app = RemoteWebDriver(hub, caps)

        Thread.sleep(10000)

        app.get("https://mfml.in/api/getInfo")

        val color: WebElement =
            app.findElement(By.id("resolution")) as WebElement
        color.click()

        val text: WebElement =
            app.findElement(By.id("location")) as WebElement
        text.click()

        val toast: WebElement =
            app.findElement(By.id("details")) as WebElement
        toast.click()

        val notification: WebElement =
            app.findElement(By.id("timezone")) as WebElement
        notification.click()

//        if (app != null) {
            app.quit()
//        };

    }
}