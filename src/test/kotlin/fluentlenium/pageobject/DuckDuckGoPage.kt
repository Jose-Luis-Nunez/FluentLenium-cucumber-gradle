package fluentlenium.pageobject

import org.fluentlenium.core.annotation.PageUrl
import org.fluentlenium.core.domain.FluentWebElement
import org.openqa.selenium.support.FindBy

@PageUrl("https://duckduckgo.com")
class DuckDuckGoPage : AbstractPage() {

    @FindBy(css = "#search_form_input_homepage")
    private lateinit var searchInput: FluentWebElement

    @FindBy(css = "#search_button_homepage")
    private lateinit var searchButton: FluentWebElement

    fun enterText(text: String) {
        searchInput.type(text)
        searchButton.submit()
    }
}
