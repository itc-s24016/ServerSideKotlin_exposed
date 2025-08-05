plugins {
//    kotlin("jvm") version "2.1.20" //削除
    alias(libs.plugins.kotlin.jvm)
}

group = "jp.ac.it_college.std.s24016.kotlin"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
//    testImplementation(kotlin("test")) //削除
    implementation(libs.exposed.core)
    implementation(libs.exposed.jdbc)
    implementation(libs.exposed.dao)
    implementation(libs.slf4j.nop)
    runtimeOnly(libs.postgres.driver)
    testImplementation(libs.kotlin.test)
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}