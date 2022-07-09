package fluentlenium.driver

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.Capabilities
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.logging.LogType
import org.openqa.selenium.logging.LoggingPreferences
import org.openqa.selenium.remote.DesiredCapabilities
import java.util.logging.Level

class WebDriverFactory {
    fun defaultWebDriver(): WebDriver {
        return chrome()
    }

    private fun chrome(): WebDriver {
        WebDriverManager.chromedriver().setup()
        return ChromeDriver(chromeOptions().setHeadless(true))
    }

    private fun chromeOptions(): ChromeOptions {
        return ChromeOptions()
            .addArguments("--start-maximized")
            .addArguments("--incognito")
            .addArguments("--ignore-certificate-errors")
            .addArguments("--disable-dev-shm-usage")
            .addArguments("--no-sandbox")
            .addArguments("--silent")
            .merge(setCapabilities())
    }

    private fun setCapabilities(): Capabilities {
        val logPrefs = LoggingPreferences().apply { enable(LogType.BROWSER, Level.ALL) }

        return DesiredCapabilities().apply {
            setCapability(ChromeOptions.LOGGING_PREFS, logPrefs)
            setCapability("acceptInsecureCerts", true)
        }
    }
}
