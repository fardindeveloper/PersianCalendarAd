// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.6.1")
        classpath(kotlin("gradle-plugin", version = "1.3.61"))
//        classpath("com.google.gms:google-services:4.3.3")

    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven("https://jitpack.io")
        maven ("https://repository.cheshmak.me")
    }


}

task("clean") {
    delete(rootProject.buildDir)
}
