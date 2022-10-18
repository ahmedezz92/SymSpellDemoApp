package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.symspell.SymSpellBuilder

import com.example.myapplication.symspell.SymSpell
import com.example.myapplication.symspell.SymSpellSetupK
import com.example.myapplication.symspell.Verbosity
import com.example.myapplication.symspell.apis.SuggestItem
import java.sql.DriverManager.println


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editText = findViewById<EditText>(R.id.editTextTextPersonName)
        val button = findViewById<Button>(R.id.button)
        val textView = findViewById<TextView>(R.id.names)

        val symSpellSetup = SymSpellSetupK(this)
        val symSpell: SymSpell = SymSpellBuilder().setUnigramLexicon(symSpellSetup.unigrams!!)
//            .setBigramLexicon(symSpellSetup.bigrams!!)
            .setMaxDictionaryEditDistance(50)
            .createSymSpell()

        /*   val maxEditDistance = 2
           val includeUnknowns = true*/
        button.setOnClickListener {
            val suggestions: List<SuggestItem> = symSpell.lookup(
                editText.text.toString(),
                Verbosity.ALL
            )
            var names = mutableListOf<String>()
            for (suggestion in suggestions) {
                names.add(suggestion.suggestion + "\n")
            }
            textView.text = names.toString()
        }
    }
}