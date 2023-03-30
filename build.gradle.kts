import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.0.2"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("jvm") version "1.7.22"
    kotlin("plugin.spring") version "1.7.22"
}

group = "com.wemakeprice.listing"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

object Version {
    const val ELASTICSEARCH = "8.0.1"
    const val JAKARTA = "2.0.1"
    const val KOTEST = "5.5.5"
    const val KOTEST_SPRING = "1.1.2"
    const val REDISSON = "3.20.0"

    const val TESTCONTAINERS = "1.16.0"
    const val MOCKK = "1.13.1"
    const val MOCKK_NINJA_SQUAD = "4.0.0"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-data-elasticsearch")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
    implementation("org.springframework.boot:spring-boot-starter-cache")
    implementation("com.github.ben-manes.caffeine:caffeine")
    implementation("org.redisson:redisson-spring-boot-starter:${Version.REDISSON}")

    // Elasticsearch
    implementation("jakarta.json:jakarta.json-api:${Version.JAKARTA}")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")

    testImplementation("io.kotest:kotest-runner-junit5:${Version.KOTEST}")
    testImplementation("io.kotest:kotest-assertions-core:${Version.KOTEST}")
    testImplementation("io.kotest.extensions:kotest-extensions-spring:${Version.KOTEST_SPRING}")
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    implementation("org.springframework.data:spring-data-commons")
    implementation("com.github.jasync-sql:jasync-r2dbc-mysql:2.1.23")
    implementation("org.apache.commons:commons-dbcp2:2.9.0")
    testImplementation("org.testcontainers:testcontainers:${Version.TESTCONTAINERS}")
    testImplementation("io.mockk:mockk:${Version.MOCKK}")
    testImplementation("com.ninja-squad:springmockk:${Version.MOCKK_NINJA_SQUAD}")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}