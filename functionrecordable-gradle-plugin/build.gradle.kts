plugins {
    `java-gradle-plugin`
    kotlin("jvm")
}

dependencies {
    implementation(kotlin("gradle-plugin-api"))
}

gradlePlugin {
    plugins {
        create("recordable") {
            id = "com.github.kintogotahasegawa.recordable"
            implementationClass =
                "com.github.kintogotahasegawa.functionrecordable_gradle_plugin.FunctionRecordableCompilerPluginSupportPlugin"
        }
    }
}