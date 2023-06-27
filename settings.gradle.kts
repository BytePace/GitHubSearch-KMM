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
            val v = "1.6.2"

            library("core", ioGroup, "ktor-client-core").version(v)
            library("json", ioGroup, "ktor-client-json").version(v)
            library("serialization", ioGroup, "ktor-client-serialization").version(v)
            library("logging", ioGroup, "ktor-client-logging").version(v)
            library("ios", ioGroup, "ktor-client-ios").version(v)
            library("android", ioGroup, "ktor-client-android").version(v)
            library("okhttp", ioGroup, "ktor-client-okhttp").version(v)
        }

        create("androidLibs") {

        }
    }
}

rootProject.name = "GitHubSearch-KMM"
include(":androidApp")

include(":common:utils")
include(":common:core")
include(":common:navigation")

include(":common:network:api")
include(":common:network:impl")
include(":common:network:feature")

include(":common:screens:search:api")
include(":common:screens:search:impl")
include(":common:screens:search:feature")

include(":common:screens:repodetails:api")
include(":common:screens:repodetails:impl")
include(":common:screens:repodetails:feature")