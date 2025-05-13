package com.github.kintogotahasegawa.funtionrecordable_compiler.declaration

import com.github.kintogotahasegawa.funtionrecordable_compiler.declaration.declaration.RecordableAnnotationDeclaration
import org.jetbrains.kotlin.ir.IrStatement
import org.jetbrains.kotlin.ir.declarations.IrSimpleFunction
import org.jetbrains.kotlin.ir.visitors.IrElementTransformerVoid

class FunctionRecordableIrElementTransformer(
    private val recordableDeclaration: RecordableAnnotationDeclaration,
): IrElementTransformerVoid() {

    override fun visitSimpleFunction(declaration: IrSimpleFunction): IrStatement {
        if (!recordableDeclaration.hasAnnotation(declaration)) {
            return declaration
        }
        return declaration
    }

}