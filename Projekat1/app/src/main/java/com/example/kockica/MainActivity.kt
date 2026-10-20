package com.example.kockica

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var diceImage1: ImageView
    lateinit var diceImage2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Dodeljujemo promenjivu koja sadrzi button i dodajemo mu labelu
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.text = "Baci"

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        rollButton.setOnClickListener {rollDice()}

    }
    }
@SuppressLint("SetTextI18n")
fun MainActivity.rollDice() {
    val diceImage1: ImageView = findViewById(R.id.dice_image1)
    val diceImage2: ImageView = findViewById(R.id.dice_image2)

    val randomInt1 = java.util.Random().nextInt(6)+1
    val randomInt2 = java.util.Random().nextInt(6)+1

    val kocka1 = when (randomInt1) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6 }

    val kocka2 = when (randomInt2) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6 }

    diceImage1.setImageResource(kocka1)
    diceImage2.setImageResource(kocka2)

    val resultText: TextView = findViewById(R.id.result_text)
    resultText.text = (randomInt1 + randomInt2).toString()
}