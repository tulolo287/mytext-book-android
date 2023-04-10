package com.example.mytextbook.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.mytextbook.R

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        val btn_go = findViewById<Button>(R.id.btn_go)
        btn_go.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@IntroActivity, MainActivity::class.java))
        })
    }
}