import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.options.UiAutomator2Options
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import java.net.URL

class AndroidWebAutomation {

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

        ltOptions["build"] = "Kotlin Android Web"
        ltOptions["name"] = "Android Chrome Test"

        ltOptions["platformName"] = "Android"
        ltOptions["deviceName"] = "Galaxy.*"
        ltOptions["platformVersion"] = "15"

        ltOptions["isRealMobile"] = true
        ltOptions["deviceOrientation"] = "PORTRAIT"
        ltOptions["console"] = true
        ltOptions["network"] = false
        ltOptions["visual"] = true
        ltOptions["autoGrantPermissions"]=true
        ltOptions["autoAcceptAlerts"]=true
        ltOptions["devicelog"] = true

        options.setCapability("lt:options", ltOptions)

        val driver = AndroidDriver(hub, options)
        println("Session is starting please wait")

        Thread.sleep(10000)

        driver.get("https://mfml.in/api/getInfo")

        val color: WebElement = driver.findElement(By.id("resolution"))
        color.click()

        val text: WebElement = driver.findElement(By.id("location"))
        text.click()

        val toast: WebElement = driver.findElement(By.id("details"))
        toast.click()

        val notification: WebElement = driver.findElement(By.id("timezone"))
        notification.click()

        driver.quit()
    }
}