import org.gradle.api.internal.lambdas.SerializableLambdas.spec

buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.10")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.9.10")
        classpath("com.android.tools.build:gradle:7.2.0")
        classpath("dev.icerock.moko:network-generator:0.17.0")
    }
}


rootProject.name = "nekos-api"

