package com.aplantas.mshop.utilities

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText

class CustomEditText(context:Context, attrs:AttributeSet):AppCompatEditText(context, attrs) {

    init {
        applyFont()
    }

    private fun applyFont() {

            //povezujemo font iz asset direktorija sa id-om
            val typeface: Typeface = Typeface.createFromAsset(context.assets,"Reborn-PersonalUse.otf")
            setTypeface(typeface)

    }

}