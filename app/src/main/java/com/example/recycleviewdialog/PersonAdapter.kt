package com.example.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewdialog.R
import com.example.recycleviewdialog.database.Person
import com.example.recycleviewdialog.databinding.PersonItemBinding
import com.example.recycleviewdialog.events.AddDialogClickListener

class PersonAdapter(private val clickListener: AddDialogClickListener): RecyclerView.Adapter<PersonAdapter.PersonHolder>() {
    val personList = ArrayList<Person>()

    inner class PersonHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = PersonItemBinding.bind(item)

        fun bind(person: Person) = with(binding) {
            personId.text = person.id.toString()
            personName.text = person.name
            personSurname.text = person.surname
            personAge.text = person.age.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.person_item, parent, false)
        return PersonHolder(view)
    }

    override fun onBindViewHolder(holder: PersonHolder, position: Int) {
        holder.bind(personList[position])

        holder.itemView.setOnClickListener {
            clickListener.getPerson(position)
        }
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    fun addPerson(person: Person) {
        personList.add(person)
        personList.sortBy { it.id }
        notifyItemInserted(itemCount)
    }

    fun getPerson(id: Int): Person {
        return personList.get(id)
    }
}