dependencyResolutionManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}

rootProject.name = "build-logic"
include(":functionrecordable-gradle-plugin")
project(":functionrecordable-gradle-plugin").projectDir = File("../functionrecordable-gradle-plugin")