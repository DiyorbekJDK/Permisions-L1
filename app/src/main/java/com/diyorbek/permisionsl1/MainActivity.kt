package com.diyorbek.permisionsl1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.diyorbek.permisionsl1.adapter.ContactApdapter
import com.diyorbek.permisionsl1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val contactAdapter by lazy { ContactApdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}