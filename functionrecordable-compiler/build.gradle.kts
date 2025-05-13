plugins {
    kotlin("jvm")
    alias(libs.plugins.ksp)
    alias(libs.plugins.maven.publish)
}

publishing {
    publications {
        create<MavenPublication>("plugin") {
            groupId = "com.github.kintogotahasegawa.recordable"
            artifactId = "functionrecordable-compiler"
            version = "0.0.1"
            from(components["java"])
        }
    }
}

dependencies {
    compileOnly(libs.kotlin.compiler.embeddable)

    ksp(libs.auto.service.ksp)
    compileOnly(libs.auto.service.annotations)
}