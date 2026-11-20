package com.example.pristupdomacimaapp

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class IksOksFragment : Fragment(R.layout.fragment_iks_oks) {

    private lateinit var polja: List<TextView>
    private lateinit var unesiPolje: EditText
    private lateinit var rezultat: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        polja = listOf(
            view.findViewById(R.id.p1_id), view.findViewById(R.id.p2_id), view.findViewById(R.id.p3_id),
            view.findViewById(R.id.p4_id), view.findViewById(R.id.p5_id), view.findViewById(R.id.p6_id),
            view.findViewById(R.id.p7_id), view.findViewById(R.id.p8_id), view.findViewById(R.id.p9_id)
        )
        unesiPolje = view.findViewById(R.id.unesipolje)
        rezultat = view.findViewById(R.id.rezultat)

        view.findViewById<Button>(R.id.plavi_button).setOnClickListener { oboji(Color.parseColor("#0080FF")) }
        view.findViewById<Button>(R.id.crveni_button).setOnClickListener { oboji(Color.parseColor("#F32121")) }
        view.findViewById<Button>(R.id.novapartija).setOnClickListener { novaPartija() }

        view.findViewById<Button>(R.id.btnNazad).setOnClickListener {
            val paket = Bundle()
            paket.putString("igra", "IksOks")
            paket.putString("rezultat", proveriPobednika())
            findNavController().navigate(R.id.action_iksOks_to_naslov, paket)
        }
    }

    private fun oboji(boja: Int) {
        val broj = unesiPolje.text.toString().toIntOrNull()
        if (broj == null || broj < 1 || broj > 9) {
            unesiPolje.error = "Unesi broj od 1 do 9"
            return
        }
        polja[broj - 1].setBackgroundColor(boja)
        unesiPolje.text.clear()
    }


    private fun novaPartija() {
        rezultat.text = "Prethodna partija: " + proveriPobednika()
        for (polje in polja) {
            polje.setBackgroundColor(Color.WHITE)
        }
    }


    private fun proveriPobednika(): String {
        val linije = listOf(
            listOf(0, 1, 2), listOf(3, 4, 5), listOf(6, 7, 8),
            listOf(0, 3, 6), listOf(1, 4, 7), listOf(2, 5, 8),
            listOf(0, 4, 8), listOf(2, 4, 6)
        )
        val plava = Color.parseColor("#0080FF")
        val crvena = Color.parseColor("#F32121")

        for (l in linije) {
            val a = boja(l[0])
            if (a != Color.WHITE && a == boja(l[1]) && a == boja(l[2])) {
                return if (a == plava) "pobedio PLAVI" else if (a == crvena) "pobedio CRVENI" else "nerešeno"
            }
        }
        return "nerešeno"
    }

    private fun boja(i: Int): Int = (polja[i].background as android.graphics.drawable.ColorDrawable).color
}