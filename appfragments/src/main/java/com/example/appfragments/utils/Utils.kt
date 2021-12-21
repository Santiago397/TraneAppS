package com.example.appfragments.utils

import android.content.Context
import java.io.IOException
import java.nio.charset.Charset

class Utils(val context: Context) {


    fun getJsonObject(context: Context): String {
        val json: String?

        try {
            val inputStream = context.assets.open("cities.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            val charset: Charset = Charset.defaultCharset()
            inputStream.read(buffer)
            inputStream.close()

            json = String(buffer, charset)

        } catch (
            ex: IOException
        ) {
            return ex.printStackTrace().toString()
        }

        return json

    }


}