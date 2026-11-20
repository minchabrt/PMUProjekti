package com.example.pristupdomacimaapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class MonopolFragment : Fragment(R.layout.fragment_monopol) {

    private lateinit var diceImage1: ImageView
    private lateinit var diceImage2: ImageView
    private lateinit var resultText: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        diceImage1 = view.findViewById(R.id.dice_image1)
        diceImage2 = view.findViewById(R.id.dice_image2)
        resultText = view.findViewById(R.id.result_text)

        val rollButton: Button = view.findViewById(R.id.roll_button)
        rollButton.text = "Baci"
        rollButton.setOnClickListener { rollDice() }

        view.findViewById<Button>(R.id.btnNazad).setOnClickListener {
            val paket = Bundle()
            paket.putString("igra", "Monopol")
            paket.putString("rezultat", "Zbir: ${resultText.text}")
            findNavController().navigate(R.id.action_monopol_to_naslov, paket)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun rollDice() {
        val randomInt1 = java.util.Random().nextInt(6) + 1
        val randomInt2 = java.util.Random().nextInt(6) + 1

        diceImage1.setImageResource(slikaKocke(randomInt1))
        diceImage2.setImageResource(slikaKocke(randomInt2))

        resultText.text = (randomInt1 + randomInt2).toString()
    }

    // jedna funkcija umesto dva ista "when" bloka
    private fun slikaKocke(broj: Int): Int {
        return when (broj) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}