package com.example.shoppinglist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoppinglist.R

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //create viewModel
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        //Подписываемся на ShopList
        viewModel.shopList.observe(this) {
            Log.d("MyLog", it.toString())
            if (count == 0) {
                val item = it[0]
                viewModel.changeEnabledState(item)
                count++
            }
        }
    }
}