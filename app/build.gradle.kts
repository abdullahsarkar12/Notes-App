plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.kapt") version "1.9.20"
}

android {
    namespace = "com.example.roompracticewithmvvmandcoroutines"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.roompracticewithmvvmandcoroutines"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    //Kapt scehma directory path when created
    kapt {
        arguments {
            arg("room.schemaLocation", "$projectDir/schemas")
        }
    }

    // Ensure schema directory creation if doesn't exist
    tasks.register("createSchemaDir") {
        doLast {
            val schemaDir = File("$projectDir/schemas")
            if (!schemaDir.exists()) {
                schemaDir.mkdirs()
            }
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    val roomVersion = "2.6.0"

    implementation("androidx.room:room-runtime:$roomVersion")
    annotationProcessor("androidx.room:room-compiler:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")
    androidTestImplementation("androidx.room:room-testing:$roomVersion")

    val lifecycleVersion = "2.6.2"

    implementation("com.github.bumptech.glide:glide:4.12.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")
    implementation("androidx.fragment:fragment-ktx:1.6.2") // for Fragment
    implementation("androidx.activity:activity-ktx:1.8.1")
    implementation ("de.hdodenhof:circleimageview:3.1.0")

    // app compact
    implementation ("androidx.appcompat:appcompat:1.6.1")

    // Constraint layout
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

}