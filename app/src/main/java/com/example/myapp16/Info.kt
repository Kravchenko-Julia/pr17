package com.example.myapp16

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Info : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)


        setContentView(R.layout.activity_info)
        val aboutTextView = findViewById<TextView>(R.id.textView)


        val aboutText = intent.getStringExtra("aboutText")


        if (aboutText != null) {
            aboutTextView.text = aboutText
        } else {
            aboutTextView.text = "Информация о программе:\n\n" +
                    "Я целую твои руки, моя родная\n" +
                    "Ты нежнее всех на свете, я точно знаю\n" +
                    "В мире нет тебя дороже, в моём ты сердце\n" +
                    "Обними меня покрепче, хочу согреться!\n" +
                    "Мама, будь всегда со мною рядом!\n" +
                    "Мама, мне ведь большего не надо!\n" +
                    "Мама, только не грусти!\n" +
                    "Ты меня за всё, мамочка, прости!\n" +
                    "Ты слышишь, мама, будь всегда со мною рядом!\n" +
                    "Мама, мне ведь большего не надо!\n" +
                    "Мама, только не грусти!\n" +
                    "Ты меня за всё, мамочка, прости!"

        }
    }
}