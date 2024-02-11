package com.example.personapp.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.personapp.R
import com.example.personapp.databinding.ActivityMainBinding
import com.example.personapp.presentation.PersonViewModel
import com.example.personapp.presentation.adapters.PersonAdapter

class MainActivity : AppCompatActivity() {
   private lateinit var viewModel: PersonViewModel

   private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
   }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val adapter = PersonAdapter(this)
        binding.rvPersonList.adapter = adapter
        viewModel = ViewModelProvider(this)[PersonViewModel::class.java]
        viewModel.personList.observe(this, Observer {
            adapter.personList = it
        //Log.d("TEST_ACTIVITY", it.toString())
        })
//        viewModel.getPersonInfo(0).observe(this, Observer {
//            Log.d("TEST_ACTIVITY", it.toString())
//        })
//        Log.d("TEST", viewModel.getPersonListUseCase.getPersonList().toString())

    }

}