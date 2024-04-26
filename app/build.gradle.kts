plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id ("kotlin-parcelize")

}

android {
    namespace = "com.example.personapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.personapp"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("androidx.core:core-ktx:1.12.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("androidx.recyclerview:recyclerview:1.3.2")
    implementation ("androidx.cardview:cardview:1.0.0")

    //coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")

    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")


    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation ("androidx.lifecycle:lifecycle-common-java8:2.7.0")

    //Room
    implementation("androidx.room:room-runtime:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")


    //Picasso
    implementation ("com.squareup.picasso:picasso:2.71828")

    implementation("com.google.android.material:material:1.11.0")

    implementation ("androidx.work:work-runtime-ktx:2.9.0")

    //Circle image
    implementation ("de.hdodenhof:circleimageview:3.1.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //Mockito
    testImplementation("org.mockito:mockito-core:5.7.0")
    testImplementation("org.mockito:mockito-inline:4.0.0")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.1.0")

    //Kaspresso
    androidTestImplementation ("com.kaspersky.android-components:kaspresso:1.5.2")

    testImplementation ("android.arch.core:core-testing:1.1.1")
    androidTestImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test:runner:1.5.2")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation ("androidx.test:core-ktx:1.5.0")



}