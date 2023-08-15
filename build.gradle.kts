import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    id("org.jetbrains.kotlin.multiplatform").version("1.9.0")
    id("org.jetbrains.compose").version("1.4.0-dev-wasm09")
    application
}

group = "com.example"
version = "1.0-SNAPSHOT"

@OptIn(ExperimentalComposeLibrary::class, ExperimentalWasmDsl::class)
kotlin {
    wasm {
        moduleName = "Noble"
        browser {
            commonWebpackConfig(Action {
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).copy(
                    static = (devServer?.static ?: mutableListOf()).apply {
                        // Serve sources to debug inside browser
                        add(project.rootDir.path)
                        add(project.rootDir.path + "/build/js/node_modules/")
                    },
                )

            })
        }
        binaries.executable()
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.components.resources)
            }
        }
        val wasmMain by getting {
            dependsOn(commonMain)
            dependencies {
                runtimeOnly(npm("@noble/secp256k1", "2.0.0"))
                runtimeOnly(npm("@noble/hashes", "1.3.1"))

            }
        }
    }
}

compose.experimental {
    web.application {}
}

compose {
    kotlinCompilerPlugin.set("1.4.0-dev-wasm09")
}