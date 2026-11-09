package com.example.colormyviews

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        setListeners()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.constraint_layout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun setListeners() {
        val clickableViews: List<View> =
            listOf(findViewById(R.id.box_one_id),findViewById(R.id.box_two_id),
                findViewById(R.id.box_three_id), findViewById(R.id.box_four_id),
                findViewById(R.id.box_five_id), findViewById(R.id.constraint_layout),
                findViewById(R.id.red_button), findViewById(R.id.yellow_button),
                findViewById(R.id.green_button))
        for (item in clickableViews){
            item.setOnClickListener { makeColored(it) }
        }
    }
    private fun makeColored(view: View?) {
        when (view?.id) {
// Boxes using Color class colors for background
            R.id.box_one_id -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_id -> view.setBackgroundColor(Color.GRAY)
// Boxes using Android color resources for background
            R.id.box_three_id ->
                view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_id ->
                view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_id ->
                view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.red_button ->
                view.setBackgroundColor(getResources().getColor(R.color.my_red))
            R.id.yellow_button ->
                view.setBackgroundColor(getResources().getColor(R.color.my_yellow))
            R.id.green_button ->
                view.setBackgroundColor(getResources().getColor(R.color.my_green))
            else -> view?.setBackgroundColor(Color.LTGRAY)
        }
    }
}