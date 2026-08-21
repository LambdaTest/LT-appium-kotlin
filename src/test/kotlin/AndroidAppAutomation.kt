import io.appium.java_client.AppiumBy
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.options.UiAutomator2Options
import org.junit.jupiter.api.Test
import org.openqa.selenium.WebElement
import java.net.URL

class AndroidAppAutomation {

    @Test
    fun sampletest() {

        val username = System.getenv("LT_USERNAME")
        val accessKey = System.getenv("LT_ACCESS_KEY")

        val hub = URL("https://mobile-hub.lambdatest.com/wd/hub")

        val options = UiAutomator2Options()

        // W3C LambdaTest capability structure — same as iOS classes
        val ltOptions = HashMap<String, Any>()

        ltOptions["user"] = username
        ltOptions["accessKey"] = accessKey

        ltOptions["build"] = "Kotlin Vanilla - Android"
        ltOptions["name"] = "Sample Test Kotlin"

        ltOptions["platformName"] = "Android"
        ltOptions["deviceName"] = "Galaxy.*"
        ltOptions["platformVersion"] = "15"

        ltOptions["isRealMobile"] = true
        ltOptions["deviceOrientation"] = "PORTRAIT"
        ltOptions["console"] = true
        ltOptions["network"] = false
        ltOptions["autoGrantPermissions"]=true
        ltOptions["autoAcceptAlerts"]=true
        ltOptions["visual"] = true
        ltOptions["devicelog"] = true
        ltOptions["app"]="<your_app_id>"

        options.setCapability("lt:options", ltOptions)

        val app = AndroidDriver(hub, options)
        println("Session is starting please wait")
        Thread.sleep(9000)

        val color: WebElement = app.findElement(AppiumBy.id("com.lambdatest.proverbial:id/color"))
        color.click()

        val text: WebElement = app.findElement(AppiumBy.id("com.lambdatest.proverbial:id/Text"))
        text.click()

        val toast: WebElement = app.findElement(AppiumBy.id("com.lambdatest.proverbial:id/toast"))
        toast.click()

        val notification: WebElement = app.findElement(AppiumBy.id("com.lambdatest.proverbial:id/notification"))
        notification.click()

        val geo: WebElement = app.findElement(AppiumBy.id("com.lambdatest.proverbial:id/geoLocation"))
        geo.click()
        Thread.sleep(5000)

        app.navigate().back()
        Thread.sleep(2000)

        val speedtest: WebElement = app.findElement(AppiumBy.id("com.lambdatest.proverbial:id/speedTest"))
        speedtest.click()
        Thread.sleep(5000)

        app.navigate().back()
        app.quit()
    }
}