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