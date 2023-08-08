pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
    }

    plugins {
        val kotlinVersion = extra["kotlin.version"] as String
        val agpVersion = extra["agp.version"] as String
        val composeVersion = extra["compose.version"] as String

        kotlin("jvm").version(kotlinVersion)
        kotlin("multiplatform").version(kotlinVersion)
        kotlin("android").version(kotlinVersion)
        kotlin("plugin.serialization").version(kotlinVersion)

        id("com.android.application").version(agpVersion)
        id("com.android.library").version(agpVersion)

        id("org.jetbrains.compose").version(composeVersion)
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }

    versionCatalogs {
        create("commonLibs") {
            library("kodein", "org.kodein.di:kodein-di:7.19.0")
        }

        create("kotlinLibs") {
            val kotlinGroup = "org.jetbrains.kotlin"
            val kotlinXGroup = "org.jetbrains.kotlinx"

            library("serialization", kotlinXGroup, "kotlinx-serialization-core")
                .version("1.3.3")
            library("coroutinesCore", kotlinXGroup, "kotlinx-coroutines-core")
                .version("1.6.0")
        }

        create("ktor") {
            val ioGroup = "io.ktor"
            val v = "2.3.3"

            library("core", ioGroup, "ktor-client-core").version(v)
            library("json", ioGroup, "ktor-client-json").version(v)
            library("serialization", ioGroup, "ktor-serialization-kotlinx-json")
                .version(v)
            library("contentNegotiation", ioGroup, "ktor-client-content-negotiation")
                .version(v)
            library("logging", ioGroup, "ktor-client-logging").version(v)
            library("ios", ioGroup, "ktor-client-ios").version(v)
            library("android", ioGroup, "ktor-client-android").version(v)
            library("okhttp", ioGroup, "ktor-client-okhttp").version(v)
            library("clientMock", ioGroup, "ktor-client-mock").version(v)
        }

        create("androidLibs") {
            library("core", "androidx.core:core-ktx:1.10.1")
            library("appcompat", "androidx.appcompat:appcompat:1.6.1")

            val lifecycle = "androidx.lifecycle"
            create("lifecycle") {
                library("runtime", lifecycle, "lifecycle-runtime-ktx").version("2.6.1")
                library("ext", lifecycle, "lifecycle-extensions").version("2.2.0")

                create("viewModel") {
                    library("core", lifecycle, "lifecycle-viewmodel-ktx").version("2.6.1")
                    library("compose", lifecycle, "lifecycle-viewmodel-compomse").version("2.6.1")
                }
            }
        }
    }
}

rootProject.name = "GitHubSearch-KMM"
include(":androidApp")

include(":node:compose")

include(":common:utils")
include(":common:core")
include(":common:navigation")

include(":common:search:api")
include(":common:search:data")
include(":common:search:presentation")
include(":common:search:view")

include(":common:repodetails:api")
include(":common:repodetails:data")
include(":common:repodetails:presentation")
include(":common:repodetails:view")