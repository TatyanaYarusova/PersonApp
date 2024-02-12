package com.example.personapp.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.personapp.R
import com.example.personapp.databinding.PersonItemBinding
import com.example.personapp.domain.Person
import com.squareup.picasso.Picasso

class PersonAdapter(
    private val context: Context
): ListAdapter<Person, PersonViewHolder>(PersonDiffCallback){

    var onPersonClickListener: OnPersonClickListener?  = null
    var onButtonClickListener: OnButtonClickListener?  = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val binding = PersonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PersonViewHolder(binding)
    }


    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = getItem(position)
        with(holder.binding) {
            Picasso.get().load(person.img).into(imgPerson)
            nameText.text = String.format(context.resources.getString(R.string.name), person.name)
            addressText.text = String.format(context.resources.getString(R.string.address),person.addressCity)
            emailText.text = String.format(context.resources.getString(R.string.email),person.email)
            phoneText.text = String.format(context.resources.getString(R.string.phone), person.phone)
        }

        holder.itemView.setOnClickListener {
            onPersonClickListener?.onPersonClick(person)
        }

    }

    interface OnPersonClickListener {
        fun onPersonClick(person: Person)
    }

    interface OnButtonClickListener {
        suspend fun onButtonClick()
    }
}