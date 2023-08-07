plugins {
    id("multiplatform-compose-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:repodetails:api"))
            // ImageLoading for compose multiplatform
            //implementation("io.github.qdsfdhvh:image-loader:1.6.4")
            }
        }

        androidMain {

        }

        desktopMain {

        }
    }
}