package com.example.myapp16

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val switch = findViewById<Switch>(R.id.switch1)

        // Устанавливаем текущее состояние переключателя в зависимости от текущей темы
        switch.isChecked =
            AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO

        switch.setOnCheckedChangeListener { _, isChecked ->
            setTheme(isChecked)
        }
    }

    private fun setTheme(isWhiteMode: Boolean) {
        if (isWhiteMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate. MODE_NIGHT_NO)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        updateMenuTheme(menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_change_theme -> {
                toggleTheme()
                return true
            }
            R.id.action_about -> {

                val intent = Intent(this, Info::class.java)

                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun toggleTheme() {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        recreate()
    }

    private fun updateMenuTheme(menu: Menu?) {
        if (menu != null) {
            val themeSwitchItem = menu.findItem(R.id.action_change_theme)
            if (themeSwitchItem != null) {
                if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
                    themeSwitchItem.title = "Сменить на светлую"
                    themeSwitchItem.setIcon(R.drawable.icon)
                } else {
                    themeSwitchItem.title = "Сменить на тёмную"
                    themeSwitchItem.setIcon(R.drawable.icon)
                }
            }
        }
    }
}