package com.example.pristupdomacimaapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class NaslovFragment : Fragment(R.layout.fragment_naslov) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // poruka iz igre u koju smo se vratili (bonus)
        val igra = arguments?.getString("igra")
        val rezultat = arguments?.getString("rezultat")

        if (igra != null) {
            view.findViewById<TextView>(R.id.tvPoruka).text =
                "Vratili ste se iz igre: $igra\nRezultat: $rezultat"
        }

        view.findViewById<Button>(R.id.btnMonopol).setOnClickListener {
            findNavController().navigate(R.id.action_naslov_to_monopol)
        }
        view.findViewById<Button>(R.id.btnTekst).setOnClickListener {
            findNavController().navigate(R.id.action_naslov_to_tekst)
        }
        view.findViewById<Button>(R.id.btnIksOks).setOnClickListener {
            findNavController().navigate(R.id.action_naslov_to_iksOks)
        }
    }
}