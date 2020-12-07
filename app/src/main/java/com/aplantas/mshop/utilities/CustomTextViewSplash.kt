package com.aplantas.mshop.utilities

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import kotlinx.android.synthetic.main.activity_splash_screen.*

//kreiramo custom text view za korištenje ovog fonta
class CustomTextViewSplash(context:Context, attrs:AttributeSet):AppCompatTextView(context,attrs) {

    init {
        applyFont()
    }

    private fun applyFont() {
        //povezujemo font iz asset direktorija sa id-om
        val typeface: Typeface = Typeface.createFromAsset(context.assets,"Reborn-PersonalUse.otf")
        setTypeface(typeface)
    }


}