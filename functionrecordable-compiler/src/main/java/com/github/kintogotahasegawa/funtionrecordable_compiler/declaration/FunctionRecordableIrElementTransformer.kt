package com.github.kintogotahasegawa.funtionrecordable_compiler.declaration

import com.github.kintogotahasegawa.funtionrecordable_compiler.declaration.declaration.RecordableAnnotationDeclaration
import com.github.kintogotahasegawa.funtionrecordable_compiler.declaration.factory.IrRecordableFunctionBodyFactory
import org.jetbrains.kotlin.ir.IrStatement
import org.jetbrains.kotlin.ir.declarations.IrSimpleFunction
import org.jetbrains.kotlin.ir.visitors.IrElementTransformerVoid

class FunctionRecordableIrElementTransformer(
    private val recordableDeclaration: RecordableAnnotationDeclaration,
    private val irRecordableFunctionBodyFactory: IrRecordableFunctionBodyFactory
): IrElementTransformerVoid() {

    override fun visitSimpleFunction(declaration: IrSimpleFunction): IrStatement {
        if (!recordableDeclaration.hasAnnotation(declaration)) {
            return declaration
        }
        declaration.body = irRecordableFunctionBodyFactory.create(declaration)
        return declaration
    }
}