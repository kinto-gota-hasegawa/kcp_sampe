plugins {
    `java-gradle-plugin`
    kotlin("jvm")
}

dependencies {
    implementation(kotlin("gradle-plugin-api"))
}

gradlePlugin {
    plugins {
        create("functionrecordable") {
            id = "com.github.kintogotahasegawa.functionrecordable_gradle_plugin"
            implementationClass =
                "com.github.kintogotahasegawa.functionrecordable_gradle_plugin.FunctionRecordableGradlePlugin"
        }
    }
}