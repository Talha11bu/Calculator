plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("net.objecthunter:exp4j:0.4.8")
    
    testImplementation(libs.junit.jupiter)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass = "AppMain"
}



tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}
