plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    mavenLocal()
    google()
    maven(url = "https://maven.pkg.jetbrains/public/p/compose/dev")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0")
    implementation("org.jetbrains.compose:compose-gradle-plugin:1.4.3")
    implementation("com.android.tools.build:gradle:7.4.2")
    implementation("org.jetbrains.kotlin:kotlin-serialization:1.9.0")
}

kotlin {
    sourceSets.getByName("main").kotlin.srcDir("buildSrc/src/main/kotlin")
}