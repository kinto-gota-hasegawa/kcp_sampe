package com.github.kintogotahasegawa.funtionrecordable_compiler.declaration.factory

import org.jetbrains.kotlin.backend.common.extensions.FirIncompatiblePluginAPI
import org.jetbrains.kotlin.backend.common.extensions.IrPluginContext
import org.jetbrains.kotlin.ir.IrStatement
import org.jetbrains.kotlin.ir.UNDEFINED_OFFSET
import org.jetbrains.kotlin.ir.declarations.IrSimpleFunction
import org.jetbrains.kotlin.ir.declarations.createBlockBody
import org.jetbrains.kotlin.ir.expressions.IrBlockBody
import org.jetbrains.kotlin.ir.expressions.IrBody
import org.jetbrains.kotlin.ir.expressions.IrCall
import org.jetbrains.kotlin.ir.expressions.impl.IrCallImpl
import org.jetbrains.kotlin.ir.expressions.impl.IrConstImpl
import org.jetbrains.kotlin.name.CallableId
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.name.Name
import java.util.concurrent.Callable

class IrRecordableFunctionBodyFactory(
    private val pluginContext: IrPluginContext,
) {

fun create(declaration: IrSimpleFunction): IrBody {
    val functionName = declaration.name.asString()
    val startLog = createPrintCall(declaration, "$functionName starts")

    val originalBody = declaration.body as? IrBlockBody ?: return declaration.body!!

    val newStatements = mutableListOf<IrStatement>()
    newStatements += startLog
    newStatements += originalBody.statements

    return pluginContext.irFactory.createBlockBody(
        startOffset = UNDEFINED_OFFSET,
        endOffset = UNDEFINED_OFFSET,
        statements = newStatements,
    )
}

    @OptIn(FirIncompatiblePluginAPI::class)
    private fun createPrintCall(
        originalFunction: IrSimpleFunction,
        message: String,
    ): IrCall {
        val irMessage = IrConstImpl.string(
            startOffset = UNDEFINED_OFFSET,
            endOffset = UNDEFINED_OFFSET,
            type = pluginContext.irBuiltIns.stringType,
            value = message,
        )
        return IrCallImpl(
            startOffset = originalFunction.startOffset,
            endOffset = originalFunction.endOffset,
            type = pluginContext.irBuiltIns.unitType,
            symbol = pluginContext.referenceFunctions(FqName("com.github.kintogotahasegawa.functionrecordable_core.internal.printlnFromRecordable")).first(),
            typeArgumentsCount = 0,
            valueArgumentsCount = 1,
            origin = null,
        ).apply {
            putValueArgument(0, irMessage)
        }
    }

}