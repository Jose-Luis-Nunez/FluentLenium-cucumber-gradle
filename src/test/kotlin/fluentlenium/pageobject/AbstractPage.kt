package fluentlenium.pageobject

import org.fluentlenium.core.FluentPage
import org.fluentlenium.core.domain.FluentWebElement
import java.util.concurrent.TimeUnit

private const val TIME_OUT_IN_SECONDS = 10L

abstract class AbstractPage : FluentPage() {

    fun clickOnElement(webElement: FluentWebElement) {
        waitUntilElementPresent(webElement)
        webElement.click()
    }

    fun FluentWebElement.type(text: String) {
        waitUntilElementPresent(this)
        this.clear()
        this.click()
        waitUntilElementPresent(this)
        this.write(text)
    }

    fun waitUntilElementPresent(element: FluentWebElement) {
        await().atMost(TIME_OUT_IN_SECONDS, TimeUnit.SECONDS).until(element).present()
    }
}
