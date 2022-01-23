plugins {
    kotlin("multiplatform") version "1.6.10"
}

group = "com.jaq"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    js{
        browser{
            binaries.executable()
        }
    }

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

        val jsMain by getting{
            dependencies{
                implementation(kotlin("stdlib-js"))
            }
        }
    }
}