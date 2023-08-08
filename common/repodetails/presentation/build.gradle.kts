plugins {
    id("multiplatform-compose-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:repodetails:data"))
            }
        }

        androidMain {
            dependencies {
//                implementation("")
            }
        }

        iosMain {
            dependencies {

            }
        }

        desktopMain {
            dependencies {

            }
        }
    }
}