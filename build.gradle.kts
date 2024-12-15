// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false

//    id("org.jetbrains.kotlin.plugin.compose") version "2.0.0"
    id("com.android.library") version "8.1.1" apply false
    kotlin("kapt") version "1.9.24"
}