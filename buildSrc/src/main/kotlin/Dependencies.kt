import org.gradle.api.JavaVersion

object Application {
    const val minSdk = 21
    const val targetSdk = 31
    const val compileSdk = 31
    const val jvmTarget = "11"
    const val versionCode = 1
    const val versionName = "1.0.0"

    val targetCompat = JavaVersion.VERSION_11
    val sourceCompat = JavaVersion.VERSION_11
}

object Versions {
    object Essential {
        const val Gradle = "7.1.0"
        const val Kotlin = "1.6.10"
        const val Coroutines = "1.6.0"
        const val GoogleService = "4.3.3"
    }

    object Ktx {
        const val Core = "1.7.0"
        const val Fragment = "1.4.1"
        const val LifeCycle = "2.4.0"
        const val ViewModel = "2.4.0"
    }

    object Ui {
        const val Glide = "4.12.0"
        const val Lottie = "4.2.2"
        const val AppCompat = "1.4.1"
        const val Splash = "1.0.0-beta01"
        const val Material = "1.6.0-alpha02"
    }

    object Network {
        const val OkHttp = "4.9.3"
        const val Retrofit = "2.9.0"
    }

    object Util {
        const val Erratum = "1.0.1"
        const val Logeukes = "1.0.0"
        const val LeakCanary = "2.8.1"
        const val SecretsGradlePlugin = "2.0.0"
        const val CheckDependencyUpdates = "1.5.0"
    }

    object Location {
        const val Locus = "4.0.1"
        const val GmsMap = "18.0.2"
        const val GmsLocation = "19.0.1"
    }

    object Jetpack {
        const val Hilt = "2.40.5"
    }

    object OssLicense {
        const val Master = "17.0.0"
        const val Classpath = "0.10.4"
    }
}

object Dependencies {
    const val Hilt = "com.google.dagger:hilt-android:${Versions.Jetpack.Hilt}"
    const val Coroutine =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Essential.Coroutines}"

    val Ktx = listOf(
        "androidx.core:core-ktx:${Versions.Ktx.Core}",
        "androidx.fragment:fragment-ktx:${Versions.Ktx.Fragment}",
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.Ktx.LifeCycle}",
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Ktx.ViewModel}",
    )

    val Ui = listOf(
        "com.airbnb.android:lottie:${Versions.Ui.Lottie}",
        "com.github.bumptech.glide:glide:${Versions.Ui.Glide}",
        "androidx.appcompat:appcompat:${Versions.Ui.AppCompat}",
        "androidx.core:core-splashscreen:${Versions.Ui.Splash}",
        "com.google.android.material:material:${Versions.Ui.Material}",
        "com.google.android.gms:play-services-oss-licenses:${Versions.OssLicense.Master}"
    )

    val Retrofit = listOf(
        "com.squareup.retrofit2:retrofit:${Versions.Network.Retrofit}",
        "com.squareup.okhttp3:logging-interceptor:${Versions.Network.OkHttp}",
        "com.squareup.retrofit2:converter-jackson:${Versions.Network.Retrofit}"
    )

    val Util = listOf(
        "land.sungbin:erratum:${Versions.Util.Erratum}",
        "land.sungbin:logeukes:${Versions.Util.Logeukes}"
    )

    val Location = listOf(
        "com.github.BirjuVachhani:locus-android:${Versions.Location.Locus}",
        "com.google.android.gms:play-services-maps:${Versions.Location.GmsMap}",
        "com.google.android.gms:play-services-location:${Versions.Location.GmsLocation}"
    )

    val Debug = listOf(
        "com.squareup.leakcanary:leakcanary-android:${Versions.Util.LeakCanary}"
    )

    object Compiler {
        const val Glide = "com.github.bumptech.glide:compiler:${Versions.Ui.Glide}"
        const val Hilt = "com.google.dagger:hilt-android-compiler:${Versions.Jetpack.Hilt}"
    }
}
