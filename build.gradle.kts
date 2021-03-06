plugins {
    kotlin("jvm") version "1.7.10"
    id("se.thinkcode.cucumber-runner") version "0.0.11"
}

group = "me.user"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    val fluentleniumVersion = "5.0.4"
    val seleniumVersion = "4.2.2"
    val webdriverManagerVersion = "5.2.0"

    testImplementation(
        group = "org.seleniumhq.selenium",
        name = "selenium-java",
        version = seleniumVersion
    )
    testImplementation(
        group = "io.github.bonigarcia",
        name = "webdrivermanager",
        version = webdriverManagerVersion
    )
    testImplementation(
        group = "org.fluentlenium",
        name = "fluentlenium-cucumber",
        version = fluentleniumVersion
    )
    testImplementation(
        group = "org.fluentlenium",
        name = "fluentlenium-assertj",
        version = fluentleniumVersion
    )
}
