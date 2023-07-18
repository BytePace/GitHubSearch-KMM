plugins {
    id("multiplatform-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain

        androidMain

        iosMain

        desktopMain
    }
}