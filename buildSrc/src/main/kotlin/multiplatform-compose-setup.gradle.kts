plugins {
    id("com.android.library")
    kotlin("multiplatform")
    kotlin("kapt")
    id("org.jetbrains.compose")
}

android {
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }

    buildFeatures {
        compose = true
    }
}

kotlin {
    jvm("desktop")
    androidTarget()

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
            }
        }
        val desktopMain by getting {
            dependencies {
                implementation(compose.preview)
                implementation(compose.desktop.common)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(compose.preview)
            }
        }

        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
    }
}