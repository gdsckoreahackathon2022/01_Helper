/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [build.gradle.kts] created by Ji Sungbin on 22. 1. 29. 오후 9:15
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("com.google.android.gms.oss-licenses-plugin")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
    id("name.remal.check-dependency-updates") version Versions.Util.CheckDependencyUpdates
}

android {
    compileSdk = Application.compileSdk

    defaultConfig {
        minSdk = Application.minSdk
        targetSdk = Application.targetSdk
        versionCode = Application.versionCode
        versionName = Application.versionName
        multiDexEnabled = true
    }

    buildTypes {
        release {
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
        }
    }

    sourceSets {
        getByName("main").run {
            java.srcDirs("src/main/kotlin")
        }
    }

    compileOptions {
        sourceCompatibility = Application.sourceCompat
        targetCompatibility = Application.targetCompat
    }

    kotlinOptions {
        jvmTarget = Application.jvmTarget
    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(Dependencies.Hilt)
    implementation(Dependencies.Coroutine)

    Dependencies.Ui.forEach(::implementation)
    Dependencies.Ktx.forEach(::implementation)
    Dependencies.Util.forEach(::implementation)
    Dependencies.Location.forEach(::implementation)

    Dependencies.Debug.forEach(::debugImplementation)

    kapt(Dependencies.Compiler.Hilt)
    kapt(Dependencies.Compiler.Glide)
}
