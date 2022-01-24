plugins {
    kotlin("multiplatform")
}

group = "com.jaq"
version = "0.0.1-SNAPSHOT"

repositories{
    mavenCentral()
    google()
}

kotlin {
    jvm()
    js(IR).browser()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
    }
}