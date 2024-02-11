package com.example.personapp.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.personapp.R
import com.example.personapp.data.db.PersonDbModel
import com.example.personapp.databinding.PersonItemBinding
import com.squareup.picasso.Picasso

class PersonAdapter(private val context: Context):
    RecyclerView.Adapter<PersonViewHolder>() {

    var personList: List<PersonDbModel> = listOf()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    var onPersonClickListener: OnPersonClickListener?  = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val binding = PersonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PersonViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = personList[position]
        with(holder.binding) {
            Picasso.get().load(person.img).into(imgPerson)
            nameText.text = String.format(context.resources.getString(R.string.name), person.name)
            addressText.text = String.format(context.resources.getString(R.string.address),person.address)
            emailText.text = String.format(context.resources.getString(R.string.email),person.email)
            phoneText.text = String.format(context.resources.getString(R.string.phone), person.phone)
        }

        holder.itemView.setOnClickListener {
            onPersonClickListener?.onPersonClick(person)
        }
    }

    interface OnPersonClickListener {
        fun onPersonClick(person: PersonDbModel)
    }
}