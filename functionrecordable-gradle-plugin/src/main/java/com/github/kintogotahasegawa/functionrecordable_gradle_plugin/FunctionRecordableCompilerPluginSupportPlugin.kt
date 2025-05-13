package com.github.kintogotahasegawa.functionrecordable_gradle_plugin

import org.gradle.api.provider.Provider
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilation
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilerPluginSupportPlugin
import org.jetbrains.kotlin.gradle.plugin.SubpluginArtifact
import org.jetbrains.kotlin.gradle.plugin.SubpluginOption

class FunctionRecordableCompilerPluginSupportPlugin: KotlinCompilerPluginSupportPlugin {
    override fun applyToCompilation(
        kotlinCompilation: KotlinCompilation<*>,
    ): Provider<List<SubpluginOption>> =
        kotlinCompilation.target.project.provider { emptyList() }

    override fun getCompilerPluginId(): String = "com.github.kintogotahasegawa.recordable"

    override fun getPluginArtifact(): SubpluginArtifact = SubpluginArtifact(
        groupId = "com.github.kintogotahasegawa.recordable",
        artifactId = "functionrecordable-compiler",
        version = "0.0.1",
    )

    override fun isApplicable(kotlinCompilation: KotlinCompilation<*>): Boolean = true
}