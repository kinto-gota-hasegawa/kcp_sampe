package com.github.kintogotahasegawa.funtionrecordable_compiler.declaration.declaration

import org.jetbrains.kotlin.ir.declarations.IrAnnotationContainer
import org.jetbrains.kotlin.ir.util.hasAnnotation
import org.jetbrains.kotlin.name.FqName

class RecordableAnnotationDeclaration() {
    fun hasAnnotation(annotationContainer: IrAnnotationContainer): Boolean {
        return annotationContainer.hasAnnotation(name)
    }


    companion object {
        val name = FqName("com.github.kintogotahasegawa.functionrecordable_core.Recordable")
    }
}