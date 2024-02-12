package com.example.personapp.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.personapp.domain.Person

object PersonDiffCallback: DiffUtil.ItemCallback<Person>() {

    override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem == newItem
    }

    override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem.id == newItem.id
    }
}