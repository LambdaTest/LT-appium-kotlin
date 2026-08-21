import io.appium.java_client.AppiumBy
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.ios.options.XCUITestOptions
import org.junit.jupiter.api.Test
import org.openqa.selenium.WebElement
import java.net.URL

class IOSAppAutomation {

    @Test
    fun sampletest() {

        val username = System.getenv("LT_USERNAME")
        val accessKey = System.getenv("LT_ACCESS_KEY")

        val hub = URL("https://mobile-hub.lambdatest.com/wd/hub")

        val options = XCUITestOptions()

        // W3C LambdaTest capability structure
        val ltOptions = HashMap<String, Any>()

        ltOptions["user"] = username!!
        ltOptions["accessKey"] = accessKey!!

        ltOptions["build"] = "Kotlin Vanilla - iOS"
        ltOptions["name"] = "Sample Test Kotlin"

        ltOptions["platformName"] = "iOS"
        ltOptions["deviceName"] = "iPhone 13"
        ltOptions["platformVersion"] = "15"

        ltOptions["isRealMobile"] = true
        ltOptions["console"] = true
        ltOptions["network"] = false
        ltOptions["visual"] = true
        ltOptions["autoGrantPermissions"]=true
        ltOptions["autoAcceptAlerts"]=true
        ltOptions["devicelog"] = true

        options.setCapability("lt:options", ltOptions)

       options.setCapability("app", "<your_app_id>")
        options.setCapability("deviceOrientation", "PORTRAIT")

        val app = IOSDriver(hub, options)
        println("Session is starting please wait")

        Thread.sleep(8000)

        val color: WebElement = app.findElement(AppiumBy.id("color"))
        color.click()

        val text: WebElement = app.findElement(AppiumBy.id("Text"))
        text.click()

        val toast: WebElement = app.findElement(AppiumBy.id("toast"))
        toast.click()

        val notification: WebElement = app.findElement(AppiumBy.id("notification"))
        notification.click()

        val geo: WebElement = app.findElement(AppiumBy.id("geoLocation"))
        geo.click()

        Thread.sleep(5000)

        app.navigate().back()
        app.quit()
    }
}