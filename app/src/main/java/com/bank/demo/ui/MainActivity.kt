package com.bank.demo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bank.demo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityMainBinding.inflate(layoutInflater).root)
    }


}