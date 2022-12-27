package com.example.recycleviewdialog

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.recycleviewdialog.database.Person
import com.example.recycleviewdialog.databinding.AddDialogBinding
import com.example.recycleviewdialog.events.AddDialogClickListener

class AddDialog(private val clickListener: AddDialogClickListener) : DialogFragment() {
    private lateinit var binding: AddDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)

            binding = AddDialogBinding.inflate(layoutInflater)

            builder.setView(binding.root)
                // Add action button
                binding.apply {
                    addAlert.setOnClickListener {
                        clickListener.onAddClick(
                                Person(
                                    0,
                                    inputName.text.toString(),
                                    inputSurname.text.toString(),
                                    inputAge.text.toString().toInt()
                                )
                            )
                        dismiss()
                    }
                }


//                .setPositiveButton("Add")
//                    { _, _ ->
//                        println("input = " + binding.inputName.text.toString())
//                        binding.apply {
//                            clickListener.onAddClick(
//                                Person(
//                                    2,
//                                    inputName.text.toString(),
//                                    inputSurname.text.toString(),
//                                    inputAge.text.toString().toInt()
//                                )
//                            )
//                        }
//                    }

            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}