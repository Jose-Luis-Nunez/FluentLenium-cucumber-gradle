package fluentlenium.stepdefinition

import fluentlenium.driver.WebDriverFactory
import org.fluentlenium.adapter.cucumber.FluentCucumberTest
import org.openqa.selenium.WebDriver
import java.time.Duration.ofSeconds

const val TIME_OUT = 30L

abstract class BaseStep : FluentCucumberTest() {

    override fun newWebDriver(): WebDriver {
        return WebDriverFactory().defaultWebDriver().apply {
            manage().timeouts().pageLoadTimeout(ofSeconds(TIME_OUT))
            manage().timeouts().implicitlyWait(ofSeconds(TIME_OUT))
            manage().timeouts().scriptTimeout(ofSeconds(15L))
            manage().window().maximize()
        }
    }
}
