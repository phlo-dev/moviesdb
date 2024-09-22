plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

kotlin {
    jvmToolchain(8)
}

dependencies {
    implementation(libs.retrofit)
    implementation(libs.http.interceptor)
    implementation(project(":data"))
    implementation(libs.kotlin.serialization.json)
    implementation(libs.retrofit.serialization.converter)

    testImplementation(libs.junit.jupiter)
}