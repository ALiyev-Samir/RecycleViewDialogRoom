package com.example.recycleviewdialog.events

import com.example.recycleviewdialog.database.Person

interface AddDialogClickListener {
    fun onAddClick(person: Person)

    fun getPerson(id: Int)
}