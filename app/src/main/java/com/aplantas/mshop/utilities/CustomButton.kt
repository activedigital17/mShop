package com.aplantas.mshop.utilities

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton

class CustomButton(context:Context, attrs:AttributeSet):AppCompatButton(context,attrs) {

    init {
        applyFont()
    }

    private fun applyFont() {
        val typeface:Typeface = Typeface.createFromAsset(context.assets,"Reborn-PersonalUse.otf")
        setTypeface(typeface)

    }


}