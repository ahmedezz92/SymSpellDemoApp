//package com.example.myapplication.symspell
//
//import android.content.Context
//import androidx.annotation.RequiresApi
//import android.os.Build
//import com.example.myapplication.symspell.apis.Bigram
//import com.example.myapplication.R
//import java.io.IOException
//import java.nio.file.Files
//import java.nio.file.Paths
//import java.util.function.Function
//import java.util.stream.Collectors
//
//@RequiresApi(api = Build.VERSION_CODES.O)
//class SymSpellSetup(context: Context) {
//    var bigrams: Map<Bigram, Long>? = null
//    var unigrams: Map<String, Long>? = null
//
//    init {
//        val filename = context.resources.getResourceName(R.raw.myfile)
//        val pathToFile = Paths.get(filename)
//        println(pathToFile.toAbsolutePath())
//        try {
//            bigrams = Files.lines(Paths.get(filename))
//                .map { line: String -> line.split(" ").toTypedArray() }
//                .collect(Collectors.toMap(Function<Array<String?>, Bigram> { tokens: Array<String?> ->
//                    Bigram(
//                        tokens[0], tokens[1]
//                    )
//                }, Function { tokens: Array<String> -> tokens[2].toLong() }))
//        } catch (e: IOException) {
//            e.printStackTrace()
//        }
//
//        try {
//            unigrams = Files.lines(Paths.get("/src/main/assets/myfile.txt"))
//                .map { line: String -> line.split(",").toTypedArray() }
//                .collect(
//                    Collectors.toMap(
//                        { tokens: Array<String> -> tokens[0] },
//                        { tokens: Array<String> -> tokens[1].toLong() })
//                )
//        } catch (e: IOException) {
//            e.printStackTrace()
//        }
//    }
//}
//
