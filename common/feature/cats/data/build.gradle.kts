plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.dagger.hilt.plugin)
}

android {
    namespace = "ru.disspear574.cats.data"
    compileSdk =
        libs.versions.compileSDK
            .get()
            .toInt()

    defaultConfig {
        minSdk =
            libs.versions.minSDK
                .get()
                .toInt()
        targetSdk =
            libs.versions.targetSDK
                .get()
                .toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

//                consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}
dependencies {

    implementation(project(":common:feature:cats:domain"))
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)

    implementation(libs.dagger.hilt.android)
    ksp(libs.dagger.hilt.compiler)
}
