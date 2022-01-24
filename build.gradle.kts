import org.jetbrains.compose.jetbrainsCompose

plugins {
    kotlin("multiplatform") version "1.6.10"
    id("org.jetbrains.compose") version "1.0.1"
    kotlin("plugin.serialization") version "1.6.10"
}

allprojects {
    group = "com.jaq"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
        google()
        jetbrainsCompose()
        maven("https://jitpack.io")
    }

    apply(plugin = "org.jetbrains.kotlin.multiplatform")
    apply(plugin = "org.jetbrains.compose")
    apply(plugin = "org.jetbrains.kotlin.plugin.serialization")

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions {
            suppressWarnings = true
            verbose = true
        }
    }

    kotlin {
        jvm{
            withJava()
        }
        js(IR).browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
            testTask {
                enabled = true
                useKarma {
                    useChromeHeadless()
                }
            }
        }
        sourceSets {
            val commonMain by getting {
                dependencies {
                    implementation(kotlin("stdlib-common"))
                    implementation(compose.runtime)
                    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.0")
                }
            }
            val commonTest by getting {
                dependencies {
                    implementation(kotlin("test-common"))
                    implementation(kotlin("test-annotations-common"))
                }
            }
            val jvmMain by getting {
                dependencies {
                    implementation(kotlin("stdlib"))
                }
            }
            val jvmTest by getting {
                dependencies {
                    implementation(kotlin("test"))
                }
            }
            val jsMain by getting {
                dependencies {
                    implementation(kotlin("stdlib-js"))
                    implementation(compose.web.core)
                    implementation("com.github.JamshedAlamQaderi:compose-web-router:v0.0.4")
                }
            }
            val jsTest by getting {
                dependencies {
                    implementation(kotlin("test-js"))
                    implementation(compose.web.testUtils)
                }
            }
        }
    }
}