package com.br.recyclerview.util

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import java.text.NumberFormat
import java.util.*
import java.util.Collections.replaceAll




/**
 * Created by Felipe on 22/08/2017.
 */

class MascaraMonetaria{
    var edt:EditText? = null
    fun mask(campo:EditText): TextWatcher {
        edt = campo
        val editor = object : TextWatcher {
             var isUpdating = false
            var meuLocal = Locale("pt", "BR")
             val nf = NumberFormat.getCurrencyInstance(meuLocal )


            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                // Evita que o método seja executado varias vezes.
                // Se tirar ele entre em loop
                if (isUpdating) {
                    isUpdating = false
                    return
                }

                isUpdating = true
                var str = s.toString()
                // Verifica se já existe a máscara no texto.
                val hasMask = (str.indexOf("R$") > -1 || str.indexOf("R$") > -1) && (str.indexOf(".") > -1 || str.indexOf(",") > -1)

                // Verificamos se existe máscara
                if (hasMask) {
                    // Retiramos a máscara.
                    str = str.replace("[R$]".toRegex(), "").replace("[,]".toRegex(), "")
                            .replace("[.]".toRegex(), "")
                }

                try {
                    // Transformamos o número que está escrito no EditText em
                    // monetário.

                    if (edt != null) {
                        str = nf.format((str).toDouble() / 100)
                        edt!!.setText(str)
                        edt!!.setSelection(campo.text.length)
                    }

                } catch (e: NumberFormatException) {
                }


            }

        }

        return editor


    }






}