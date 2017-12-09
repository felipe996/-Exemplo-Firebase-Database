package com.br.recyclerview.extensions

import android.support.annotation.IdRes
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log

/**
 * Created by Felipe on 07/12/2017.
 */
// Configura a Toolbar
fun AppCompatActivity.setupToolbar(@IdRes id: Int, title: String? = null, upNavigation: Boolean = false): ActionBar {
    val toolbar = findViewById<Toolbar>(id)
    setSupportActionBar(toolbar)
    if (title != null) {
        supportActionBar?.title = title;
    }
    supportActionBar?.setDisplayHomeAsUpEnabled(upNavigation)
    return supportActionBar!!
}
fun stringMonetarioToDouble(str: String): Float {
    var str = str
    var retorno = 0f
    try {
        val hasMask = (str.indexOf("R$") > -1 || str.indexOf("R$") > -1) && (str.indexOf(".") > -1 || str.indexOf(",") > -1)
        // Verificamos se existe máscara
        if (hasMask) {
            // Retiramos a máscara.
            str = str.replace("[R$]".toRegex(), "").replace("\\\\w+".toRegex(), "")
                    .replace("\\.\\w+".toRegex(), "")
        }
        // Transformamos o número que está escrito no EditText em
        // double.

        var ret = ""
        for (i in 0..str.length - 1) {
            if (str[i] == ',') {
                ret = ret + '.'
            } else {
                ret = ret + str[i]
            }
        }
        retorno = java.lang.Float.parseFloat(ret)

    } catch (e: NumberFormatException) {
        //TRATAR EXCEÇÃO
    }

    return retorno

}