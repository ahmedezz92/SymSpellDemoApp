package com.example.myapplication.symspell

import android.content.Context
import androidx.core.text.trimmedLength
import com.example.myapplication.MainActivity
import com.example.myapplication.symspell.apis.Bigram
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths
import java.util.function.BinaryOperator
import java.util.stream.Collectors

class SymSpellSetupK(context: Context) {
    var bigrams: Map<Bigram, Long>? = null
    var unigrams: Map<String, Long>? = null

    init {
        val filename = "myfile.txt"
        try {
            bigrams =
                context.assets.open(filename).bufferedReader().lines().map { line: String ->
                    line.split(
                        ","
                    ).toTypedArray()
                }.collect(
                    Collectors.toMap({ tokens: Array<String> ->
                        Bigram(
                            tokens[0],
                            tokens[0]
                        )
                    },
                        { tokens: Array<String> ->
                            tokens[0].length.toLong()
                        })
                )
        } catch (e: IOException) {
            e.printStackTrace()
        }

        try {
            unigrams = context.assets.open(filename).bufferedReader().lines()
                .map { line: String -> line.split(",").toTypedArray() }
                .collect(
                    Collectors.toMap(
                        { tokens: Array<String> -> tokens[0] },
                        { tokens: Array<String> -> tokens[0].length.toLong() },

                        )
                )
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }


}