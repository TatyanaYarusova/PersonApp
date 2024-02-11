package com.example.personapp.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.personapp.R
import com.example.personapp.presentation.PersonViewModel

class MainActivity : AppCompatActivity() {
   private lateinit var viewModel: PersonViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[PersonViewModel::class.java]
        viewModel.personList.observe(this, Observer {
            Log.d("TEST_ACTIVITY", it.toString())
        })
//        Log.d("TEST", viewModel.getPersonListUseCase.getPersonList().toString())

    }

}