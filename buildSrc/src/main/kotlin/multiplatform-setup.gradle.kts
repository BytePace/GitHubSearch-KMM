plugins {
    id("com.android.library")
    kotlin("multiplatform")
    kotlin("kapt")
}

kotlin {
    jvm("desktop")
    androidTarget()
    ios()
}