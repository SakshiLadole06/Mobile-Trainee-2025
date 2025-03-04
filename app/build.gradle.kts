plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")// Add this for Room annotation processor
    alias(libs.plugins.google.gms.google.services)
    id("com.google.dagger.hilt.android")  //for DI
}

android {
    namespace = "com.example.taskandroid"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.taskandroid"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.fragment.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    //for web view
    implementation(libs.androidx.webkit)
    //for firebase messaging
    implementation(libs.firebase.messaging)
    //for work
    implementation(libs.androidx.work.runtime.ktx)
    //for view pager
    implementation(libs.androidx.viewpager2)
    //for retrofit
    implementation("com.squareup.retrofit2:retrofit:2.3.0")
    implementation("com.squareup.retrofit2:converter-gson:2.3.0")
    //for RoomDatabase
    implementation("androidx.room:room-runtime:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    //map
    implementation(libs.play.services.maps)
    implementation(libs.play.services.location)
    //for notification
    implementation("androidx.core:core-ktx:1.15.0")
    //for cardview
    implementation("androidx.cardview:cardview:1.0.0")
    //for Coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")
    //or workers
    implementation(libs.androidx.work.runtime.ktx)
    //for DI
    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt("com.google.dagger:hilt-android-compiler:2.51.1")
    //for Glide
    implementation("com.github.bumptech.glide:glide:4.16.0")
    //for coil
    implementation("io.coil-kt.coil3:coil:3.1.0")
    implementation("io.coil-kt.coil3:coil-network-okhttp:3.1.0")
}
// Allow references to generated code for DI
kapt {
    correctErrorTypes = true
}