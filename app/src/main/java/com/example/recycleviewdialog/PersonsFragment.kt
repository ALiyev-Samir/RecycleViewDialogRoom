package com.example.recycleviewdialog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycleviewdialog.database.Person
import com.example.recycleview.PersonAdapter
import com.example.recycleviewdialog.database.MyDatabase
import com.example.recycleviewdialog.databinding.FragmentPersonsBinding
import com.example.recycleviewdialog.events.AddDialogClickListener

class PersonsFragment : Fragment(), AddDialogClickListener {
    lateinit var binding: FragmentPersonsBinding
    private val adapter by lazy {
        PersonAdapter(this)
    }
    val addDialog by lazy {
        AddDialog(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPersonsBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }


    private fun init() {
        binding.apply {
            rcView.layoutManager = LinearLayoutManager(requireContext())
            rcView.adapter = adapter
            addBtn.setOnClickListener {
                addDialog.show(childFragmentManager, "AddDialog")
//                findNavController().navigate(PersonsFragmentDirections.actionPersonsFragmentToPersonDetailsFragment("PersonName").apply {
//
//                })
               // findNavController().navigate(PersonsFragmentDirections.actionPersonsFragmentToAddDialog())
            }
        }
    }
    override fun onAddClick(person: Person) {
//        MyDatabase.getInstance(requireContext()).personsDao().addPerson(person)
//        var list = MyDatabase.getInstance(requireContext()).personsDao().getAllPersons()
//        for (a in list) {
//            println("id = "+a.id + " , name = "+a.name)
//        }
        adapter.addPerson(person)
    }

    override fun getPerson(id: Int) {
//        println("ID = "+id)

        findNavController().navigate(PersonsFragmentDirections.actionPersonsFragmentToPersonDetailsFragment(adapter.getPerson(id)).apply {

        })
    }
}