package com.example.personapp.presentation.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.personapp.R
import com.example.personapp.databinding.ActivityPersonInfoBinding
import com.example.personapp.presentation.PersonViewModel
import com.squareup.picasso.Picasso


class PersonInfoActivity: AppCompatActivity() {

    private lateinit var viewModel: PersonViewModel

    private val binding by lazy {
        ActivityPersonInfoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        if (!intent.hasExtra(EXTRA_FROM_ID)){
            finish()
            return
        }
        val personId = intent.getIntExtra(EXTRA_FROM_ID, EXTRA_UNDEFINED_ID)
        viewModel = ViewModelProvider(this)[PersonViewModel::class.java]
        viewModel.getPersonInfo(personId).observe(this, Observer {
            with(binding) {
                Picasso.get().load(it.img).into(imagePerson)
                nameText.text = String.format(resources.getString(R.string.name), it.name)
                addressText.text = String.format(resources.getString(R.string.address),it.address)
                emailText.text = String.format(resources.getString(R.string.email),it.email)
                phoneText.text = String.format(resources.getString(R.string.phone), it.phone)
            }
        })

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