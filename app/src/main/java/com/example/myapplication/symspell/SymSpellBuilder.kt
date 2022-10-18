package com.example.myapplication.symspell

import com.example.myapplication.symspell.apis.StringDistance
import com.example.myapplication.symspell.apis.DamerauLevenshteinOSA
import com.example.myapplication.symspell.apis.Bigram
import com.example.myapplication.symspell.SymSpellBuilder
import androidx.annotation.RequiresApi
import android.os.Build
import com.example.myapplication.symspell.SymSpellImpl
import java.util.HashMap

class SymSpellBuilder {
    var maxDictionaryEditDistance = 2
        private set
    var prefixLength = 7
        private set
    var stringDistanceAlgorithm: StringDistance = DamerauLevenshteinOSA()
        private set
    var unigramLexicon: Map<String, Long> = HashMap()
        private set
    var bigramLexicon: Map<Bigram, Long> = HashMap()
        private set

    fun setMaxDictionaryEditDistance(maxDictionaryEditDistance: Int): SymSpellBuilder {
        this.maxDictionaryEditDistance = maxDictionaryEditDistance
        return this
    }

    fun setPrefixLength(prefixLength: Int): SymSpellBuilder {
        this.prefixLength = prefixLength
        return this
    }

    fun setUnigramLexicon(unigramLexicon: Map<String, Long>): SymSpellBuilder {
        this.unigramLexicon = unigramLexicon
        return this
    }

    fun setBigramLexicon(bigramLexicon: Map<Bigram, Long>): SymSpellBuilder {
        this.bigramLexicon = bigramLexicon
        return this
    }

    fun setStringDistanceAlgorithm(distanceAlgorithm: StringDistance): SymSpellBuilder {
        stringDistanceAlgorithm = distanceAlgorithm
        return this
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    fun createSymSpell(): SymSpellImpl {
        return SymSpellImpl(this)
    }
}