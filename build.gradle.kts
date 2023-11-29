import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("dev.icerock.mobile.multiplatform-network-generator")
    application
}

group = "org.market-twits"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("dev.icerock.moko:network:0.21.0")
    implementation("dev.icerock.moko:network-engine:0.21.0") // configured HttpClientEngine
    implementation("dev.icerock.moko:network-bignum:0.21.0") // kbignum serializer
    //implementation("dev.icerock.moko:network-errors:0.21.0") // moko-errors integration
}



allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
mokoNetwork {
    spec("nekos") {
        inputSpec = file("src/nekosapi.yaml")
        packageName = "news"
        isInternal = false
        isOpen = true
        enumFallbackNull = false
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}
