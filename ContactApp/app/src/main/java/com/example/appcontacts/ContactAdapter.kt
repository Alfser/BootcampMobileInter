package com.example.appcontacts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appcontacts.databinding.RecyclerViewItemBinding

class ContactAdapter(): RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    private var contactList: List<Contact> = arrayListOf()

    inner class ContactViewHolder(
        val binding: RecyclerViewItemBinding
    ): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding = RecyclerViewItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)

        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.binding.contactName.text = contactList[position].name
        holder.binding.contactNumber.text = contactList[position].phone

    }

    override fun getItemCount(): Int = contactList.size

    fun setContactList(contacts: List<Contact>){
        contactList = contacts
        notifyDataSetChanged()
    }
}