// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath( "org.jetbrains.kotlin:kotlin-gradle-plugin:1.2.10")
    }
}

allprojects {
    repositories {
        mavenCentral()
        jcenter()
        maven (url = "https://jitpack.io")
    }
}

