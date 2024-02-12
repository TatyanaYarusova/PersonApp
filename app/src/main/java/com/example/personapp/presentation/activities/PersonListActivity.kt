package com.example.personapp.presentation.activities


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.personapp.databinding.ActivityPersonListBinding
import com.example.personapp.domain.Person
import com.example.personapp.presentation.PersonViewModel
import com.example.personapp.presentation.adapters.PersonAdapter

class PersonListActivity : AppCompatActivity() {
   private lateinit var viewModel: PersonViewModel

   private val binding by lazy {
        ActivityPersonListBinding.inflate(layoutInflater)
   }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val adapter = PersonAdapter(this)
        adapter.onPersonClickListener = object : PersonAdapter.OnPersonClickListener {
            override fun onPersonClick(person: Person){
                val intent = PersonInfoActivity.newIntent(
                    this@PersonListActivity,
                    person.id
                )
                startActivity(intent)
            }
        }
        binding.rvPersonList.adapter = adapter
        viewModel = ViewModelProvider(this)[PersonViewModel::class.java]
        viewModel.personList.observe(this, Observer {
            adapter.submitList(it)
        })
    }

}