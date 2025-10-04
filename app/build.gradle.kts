// news
import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    // Room
    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "com.example.nexus"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.nexus"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // news
        val properties = Properties()
        val localPropertiesFile = rootProject.file("local.properties")
        if (localPropertiesFile.exists()) {
            localPropertiesFile.inputStream().use { input ->
                properties.load(input)
            }
        }
        buildConfigField("String", "TMDB_API_KEY", "\"${properties.getProperty("tmdb.api.key", "")}\"")
        buildConfigField("String", "TMDB_BASE_URL", "\"https://api.themoviedb.org/3/\"")
        buildConfigField("String", "TMDB_IMAGE_BASE_URL", "\"https://image.tmdb.org/t/p/original/\"")
        buildConfigField("String", "TMDB_BEARER_TOKEN", "\"${properties.getProperty("TMDB_BEARER_TOKEN", "")}\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        //news
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // navigation
    implementation (libs.androidx.navigation.compose)
    implementation (libs.androidx.hilt.navigation.compose)

    // room
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    kapt(libs.room.compiler)

    // koin
    implementation(libs.koin.android)
    implementation(libs.koin.compose)
    // coil
    implementation(libs.coil.compose)
    // retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)
    // OkHttp (para logs de red)
    implementation(libs.okhttp.logging)
    // coroutines
    implementation(libs.coroutines.android)
    // google fonts
    implementation(libs.androidx.compose.ui.text.google.fonts)
    implementation(libs.google.play.services.basement)
    // youtube player
    implementation(libs.youtube.player)

}