plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

dependencies {
    implementation(libs.retrofit)
    implementation(libs.http.interceptor)
    implementation(project(":data"))
    implementation(libs.kotlin.serialization.json)

    testImplementation(libs.junit.jupiter)
}