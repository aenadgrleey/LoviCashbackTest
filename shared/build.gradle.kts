plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.resources)
    kotlin("plugin.serialization")
    id("org.jetbrains.compose")
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(iosX64(), iosArm64(), iosSimulatorArm64())
        .forEach {
            it.binaries.framework {
                baseName = "shared"
                isStatic = true
                export(libs.moko.resources)
            }
        }


    sourceSets {
        commonMain.dependencies {
            implementation(compose.ui)
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.material3)
            implementation(compose.materialIconsExtended)
            implementation(compose.animation)
            implementation(libs.moko.compose)
            api(libs.moko.resources)
            implementation(libs.bundles.voyager)
            implementation(libs.bundles.ktor)
            implementation(libs.koin.core)
            implementation(libs.kamel.image)
        }
        androidMain.dependencies {
            implementation(libs.androidx.activity.compose)
            implementation(libs.ktor.client.okhttp)
            implementation(libs.zxing.android.embedded)
        }
        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }
    }
}

multiplatformResources {
    resourcesClassName = "Res"
    resourcesPackage = "com.aenadgrleey.resources"
}

android {
    namespace = "com.aenadgrleey.lovicashbacktest"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
    dependencies {
        debugImplementation(libs.compose.ui.tooling)
        debugImplementation(libs.compose.ui.tooling.preview)
    }
}
