package fluentlenium.stepdefinition

import fluentlenium.pageobject.DuckDuckGoPage
import io.cucumber.java.After
import io.cucumber.java.Before
import io.cucumber.java.Scenario
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.fluentlenium.core.annotation.Page

class DuckDuckGoSteps : BaseStep() {

    @Page
    private lateinit var duckGoPage: DuckDuckGoPage

    @Given("visit duck duck go")
    fun visitDuckDuckGo() {
        goTo("https://duckduckgo.com")
    }

    @When("^I search for String (.*)")
    fun searchFor(searchString: String) {
        duckGoPage.enterText(searchString)
    }

    @Then("^Title contains (.*)")
    fun titleContains(expectedString: String) {
        assertThat(duckGoPage.window().title()).contains(expectedString)
    }

    @Before
    fun beforeScenario(scenario: Scenario?) {
        this.before(scenario)
    }

    @After
    fun afterScenario(scenario: Scenario?) {
        this.after(scenario)
    }
}
