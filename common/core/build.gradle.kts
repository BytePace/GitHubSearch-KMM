plugins {
    id("multiplatform-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(kotlinLibs.serialization)
                api(kotlinLibs.coroutinesCore)

                api(ktor.core)
                implementation(ktor.serialization)
                implementation(ktor.contentNegotiation)
                implementation(ktor.json)
                implementation(ktor.logging)

                api(commonLibs.kodein)
            }
        }

        androidMain {
            dependencies {
                implementation(ktor.android)
            }
        }

        iosMain {
            dependencies {
                implementation(ktor.ios)
            }
        }

        desktopMain {
            dependencies {
                implementation(ktor.okhttp)
            }
        }
    }
}