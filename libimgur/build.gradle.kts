plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
//    this plugin make sure that we can add code generation to our project
    id("kotlin-kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11
    }
}
// dependencies for the libimgur module have to be defined manually
dependencies {
    // for coroutines
    implementation(libs.kotlinx.coroutines.core)
    //    retrofit
    api(libs.retrofit)
    // for json serialization
    implementation(libs.converter.moshi)
    // for moshi
    implementation(libs.moshi)
    // for moshi code generation and kapt is kotlin annotation processing tool
    "kapt"(libs.moshi.kotlin.codegen)
    // unit test
    testImplementation(libs.junit)

}