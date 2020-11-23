package com.android.rockpaper

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.random

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //variabel
        /*Button*/
        val btn_batu = findViewById<ImageButton>(R.id.but_batu);
        val btn_kertas = findViewById<ImageButton>(R.id.but_kertas);
        val btn_gunting = findViewById<ImageButton>(R.id.but_gunting);
        val btn_reset = findViewById<ImageButton>(R.id.but_reset);

        btn_reset.setOnClickListener {
            val myIntent = intent
            finish()
            startActivity(myIntent)
        }

        btn_batu.setOnClickListener(this);
        btn_kertas.setOnClickListener(this);
        btn_gunting.setOnClickListener(this);
    }


    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    var user_input: Int = 0
    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.but_batu -> {
                    user_input = 1;
                    but_batu.setBackgroundResource(R.color.bg)
                    randomLawan()
                }
                R.id.but_kertas -> {
                    user_input = 2;
                    but_kertas.setBackgroundResource(R.color.bg)
                    randomLawan()
                }
                R.id.but_gunting -> {
                    user_input = 3;
                    but_gunting.setBackgroundResource(R.color.bg)
                    randomLawan()
                }
            }
        }
    }


    private fun randomLawan() {
        val ran: Double = (random() * 3);
        val ran01 = ran.toInt();
        cek(ran01);
    }

    //fungsi check
    fun cek(ran: Int) {
        if (user_input == 1 && ran == 0) { //User choose Rock,Computer choose Rock
            but_batu_com.setBackgroundResource(R.color.bg)
            hasil(2)
        } else if (user_input == 1 && ran == 1) { //User choose Rock,Computer choose Paper
            but_kertas_com.setBackgroundResource(R.color.bg)
            hasil(0)
        } else if (user_input == 1 && ran == 2) { //User choose Rock,Computer choose Scissors
            but_gunting_com.setBackgroundResource(R.color.bg)
            hasil(1)
        } else if (user_input == 2 && ran == 0) { //User choose Paper,Computer choose Rock
            but_batu_com.setBackgroundResource(R.color.bg)
            hasil(1)
        } else if (user_input == 2 && ran == 1) { //User choose Paper,Computer choose Paper
            but_kertas_com.setBackgroundResource(R.color.bg)
            hasil(2)
        } else if (user_input == 2 && ran == 2) { //User choose Paper,Computer choose Scissors
            but_gunting_com.setBackgroundResource(R.color.bg)
            hasil(0)
        } else if (user_input == 3 && ran == 0) { //User choose Scissors,Computer choose Rock
            but_batu_com.setBackgroundResource(R.color.bg)
            hasil(0)
        } else if (user_input == 3 && ran == 1) { //User choose Scissors,Computer choose Paper
            but_kertas_com.setBackgroundResource(R.color.bg)
            hasil(1)
        } else if (user_input == 3 && ran == 2) { //User choose Scissors,Computer choose Scissors
            but_gunting_com.setBackgroundResource(R.color.bg)
            hasil(2)
        }
    }

    fun hasil(hasil: Int) {
        if (hasil == 0) {
            text_result.postDelayed({
                text_result.setImageResource(R.drawable.img_two)
            }, 3000);
        } else if (hasil == 1) {
            text_result.postDelayed({
                text_result.setImageResource(R.drawable.img_one)
            }, 3000);
        } else {
            text_result.postDelayed({
                text_result.setImageResource(R.drawable.img_draw)
            }, 3000);
        }
    }
}