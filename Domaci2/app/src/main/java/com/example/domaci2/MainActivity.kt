package com.example.domaci2

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.os.IBinder
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.domaci2.ui.theme.Domaci2Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.choose_btn).setOnClickListener {
            addText(it)
        }

    }
    @SuppressLint("ServiceCast")
    private fun addText(view: View)
    {

        val scrolltext_text = findViewById<TextView>(R.id.scrolltext_text)

        val input_text= findViewById<EditText>(R.id.choosen_text)

        if(input_text.text.toString() == "1")
            scrolltext_text.text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. \n Aenean felis arcu, pharetra sed ligula a, venenatis pretium purus. \n Vivamus dignissim lobortis ultricies. Morbi a nunc risus. \n Integer justo orci, rutrum in egestas sed, ultrices ut leo. \n Maecenas vitae orci malesuada, rutrum arcu sed, ultrices est. \n Proin in magna commodo, placerat nunc vitae, pulvinar ante. Morbi porttitor diam in turpis rutrum, accumsan tincidunt nisi scelerisque. \n Nulla mattis massa volutpat ornare pharetra. \n Duis tempus urna nec justo vulputate suscipit. \n Lorem ipsum dolor sit amet, consectetur adipiscing elit. \n Fusce dignissim sed purus ac convallis."
        else if(input_text.text.toString() == "2")
            scrolltext_text.text = "Suspendisse feugiat ipsum vitae purus facilisis, sit amet commodo lorem condimentum. \n Curabitur vel porta lorem. Nullam sagittis, felis non interdum varius, sapien est semper nibh, eget egestas nisi metus a nibh. \n Etiam ornare felis et purus mollis aliquet. \n Ut nec vehicula metus, in luctus turpis. \n Proin tortor risus, elementum ut pellentesque non, eleifend nec turpis. \n Cras vestibulum ligula odio, non viverra nulla volutpat sit amet. \n Nunc in augue augue. \n Duis ultrices risus a sapien finibus aliquam."
        else if(input_text.text.toString() == "3")
            scrolltext_text.text = "Mauris molestie eros finibus finibus rhoncus. \n Aliquam molestie maximus ante quis convallis. \n Aliquam elementum turpis ac sapien vulputate accumsan. \n Praesent aliquam feugiat sem eget fermentum. \n Curabitur accumsan gravida gravida. \n Proin et lobortis turpis. \n Curabitur hendrerit nisl purus, id rutrum lectus vestibulum at. \n Curabitur maximus quam ut convallis molestie. \n Sed venenatis odio quis nunc consequat interdum. \n Aenean a justo placerat, maximus nunc a, feugiat felis. \n Vivamus lobortis convallis nisl vel egestas. \n Etiam pretium urna sem, ut eleifend urna commodo sit amet. \n Nunc eget lobortis ipsum."


        input_text.setText("")

// Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as
                InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}