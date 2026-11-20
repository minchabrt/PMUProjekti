package com.example.pristupdomacimaapp

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class TekstFragment : Fragment(R.layout.fragment_tekst) {

    private lateinit var scrollText: TextView
    private lateinit var inputText: EditText

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        scrollText = view.findViewById(R.id.scrolltext_text)
        inputText = view.findViewById(R.id.choosen_text)

        view.findViewById<Button>(R.id.choose_btn).setOnClickListener {
            addText(it)
        }

        view.findViewById<Button>(R.id.btnNazad).setOnClickListener {
            val paket = Bundle()
            paket.putString("igra", "Prikaz teksta")
            paket.putString("rezultat", "nema rezultata")
            findNavController().navigate(R.id.action_tekst_to_naslov, paket)
        }
    }

    private fun addText(view: View) {
        when (inputText.text.toString()) {
            "1" -> scrollText.text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. \n Aenean felis arcu, pharetra sed ligula a, venenatis pretium purus. \n Vivamus dignissim lobortis ultricies. Morbi a nunc risus. \n Integer justo orci, rutrum in egestas sed, ultrices ut leo. \n Maecenas vitae orci malesuada, rutrum arcu sed, ultrices est. \n Proin in magna commodo, placerat nunc vitae, pulvinar ante. Morbi porttitor diam in turpis rutrum, accumsan tincidunt nisi scelerisque. \n Nulla mattis massa volutpat ornare pharetra. \n Duis tempus urna nec justo vulputate suscipit. \n Lorem ipsum dolor sit amet, consectetur adipiscing elit. \n Fusce dignissim sed purus ac convallis."
            "2" -> scrollText.text = "Suspendisse feugiat ipsum vitae purus facilisis, sit amet commodo lorem condimentum. \n Curabitur vel porta lorem. Nullam sagittis, felis non interdum varius, sapien est semper nibh, eget egestas nisi metus a nibh. \n Etiam ornare felis et purus mollis aliquet. \n Ut nec vehicula metus, in luctus turpis. \n Proin tortor risus, elementum ut pellentesque non, eleifend nec turpis. \n Cras vestibulum ligula odio, non viverra nulla volutpat sit amet. \n Nunc in augue augue. \n Duis ultrices risus a sapien finibus aliquam."
            "3" -> scrollText.text = "Mauris molestie eros finibus finibus rhoncus. \n Aliquam molestie maximus ante quis convallis. \n Aliquam elementum turpis ac sapien vulputate accumsan. \n Praesent aliquam feugiat sem eget fermentum. \n Curabitur accumsan gravida gravida. \n Proin et lobortis turpis. \n Curabitur hendrerit nisl purus, id rutrum lectus vestibulum at. \n Curabitur maximus quam ut convallis molestie. \n Sed venenatis odio quis nunc consequat interdum. \n Aenean a justo placerat, maximus nunc a, feugiat felis. \n Vivamus lobortis convallis nisl vel egestas. \n Etiam pretium urna sem, ut eleifend urna commodo sit amet. \n Nunc eget lobortis ipsum."
        }

        inputText.setText("")

        // sakrij tastaturu
        val imm = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}