plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.ksp)
    alias(libs.plugins.dagger.hilt.plugin)
}

android {
    namespace = "ru.disspear574.cats.presentation"
    compileSdk =
        libs.versions.compileSDK
            .get()
            .toInt()

    defaultConfig {
        minSdk =
            libs.versions.minSDK
                .get()
                .toInt()
        compileSdk =
            libs.versions.compileSDK
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
    buildFeatures {
        compose = true
    }
}
dependencies {
    implementation(project(":common:feature:cats:domain"))

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.coil)
    implementation(libs.koin.core)
    implementation(libs.koin.compose)
    implementation(libs.lifecycle.compose)
    implementation(libs.lifecycle.compose.viewmodel)
    implementation(libs.icons.extended)
    implementation(libs.dagger.hilt.android)
    ksp(libs.dagger.hilt.compiler)

    debugImplementation(libs.androidx.ui.tooling)
}
