package com.example.personapp.presentation.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.example.personapp.R
import com.example.personapp.databinding.ActivityPersonInfoBinding
import com.example.personapp.domain.Person
import com.example.personapp.presentation.PersonViewModel
import com.squareup.picasso.Picasso
import java.util.Locale


class PersonInfoActivity: AppCompatActivity() {

    private lateinit var viewModel: PersonViewModel

    private val binding by lazy {
        ActivityPersonInfoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        if (!intent.hasExtra(EXTRA_FROM_ID)) {
            finish()
            return
        }
        val personId = intent.getIntExtra(EXTRA_FROM_ID, EXTRA_UNDEFINED_ID)
        viewModel = ViewModelProvider(this)[PersonViewModel::class.java]
        viewModel.getPersonInfo(personId).observe(this) {
            with(binding) {
                Picasso.get().load(it.img).into(imagePerson)
                nameText.text = it.name
                addressCityText.text = it.addressCity
                addressStreetText.text = it.addressStreet
                emailText.text = it.email
                phoneText.text = it.phone
                dobText.text = it.dob
            }
        }
        binding.phoneText.setOnClickListener {
            goPhone()
        }

        binding.addressCityText.setOnClickListener {
            goMap(viewModel.getPersonInfo(personId))
        }

    }

    private fun goPhone(){
        val phoneNumber = binding.phoneText.text.toString()
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:$phoneNumber")
        startActivity(intent)
    }


    fun goMap(person: LiveData<Person>){
        person.observe(this){
            val uri = "http://maps.google.com/maps/search/?q=${it.addressCity}"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
            startActivity(intent)
        }
    }

    companion object {
        private const val EXTRA_FROM_ID = "ID"
        private const val EXTRA_UNDEFINED_ID = -1

        fun newIntent(context: Context, personId: Int ): Intent {
            val intent = Intent(context, PersonInfoActivity::class.java)
            intent.putExtra(EXTRA_FROM_ID, personId)
            return intent
        }
    }

}