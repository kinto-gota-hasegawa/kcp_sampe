package com.github.kintogotahasegawa.funtionrecordable_compiler.declaration

import com.github.kintogotahasegawa.funtionrecordable_compiler.declaration.declaration.RecordableAnnotationDeclaration
import com.github.kintogotahasegawa.funtionrecordable_compiler.declaration.factory.IrRecordableFunctionBodyFactory
import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.backend.common.extensions.IrPluginContext
import org.jetbrains.kotlin.ir.declarations.IrModuleFragment
import org.jetbrains.kotlin.ir.visitors.transformChildrenVoid

class FunctionRecordableIrGenerationExtension: IrGenerationExtension {

    override fun generate(moduleFragment: IrModuleFragment, pluginContext: IrPluginContext) {
        moduleFragment.transformChildrenVoid(createFunctionRecordableIrElementTransformer(pluginContext))
    }

    private fun createFunctionRecordableIrElementTransformer(
        pluginContext: IrPluginContext
    ): FunctionRecordableIrElementTransformer {
        return FunctionRecordableIrElementTransformer(
            recordableDeclaration = RecordableAnnotationDeclaration(),
            irRecordableFunctionBodyFactory = IrRecordableFunctionBodyFactory(
                pluginContext = pluginContext,
            )
        )
    }
}