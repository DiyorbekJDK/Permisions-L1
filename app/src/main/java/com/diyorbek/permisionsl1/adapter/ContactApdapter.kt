package com.diyorbek.permisionsl1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.diyorbek.permisionsl1.R
import com.diyorbek.permisionsl1.databinding.ContactLayoutBinding
import com.diyorbek.permisionsl1.model.Contact

class ContactApdapter : ListAdapter<Contact, ContactApdapter.ContactViewHolder>(DiffCallBack()) {
    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        context = parent.context
        return ContactViewHolder(
            ContactLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private class DiffCallBack : DiffUtil.ItemCallback<Contact>() {
        override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem == newItem
        }
    }

    inner class ContactViewHolder(private val binding: ContactLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(contact: Contact) {
            binding.apply {
                contactImage.text = "${contact.name[0]}"
                contactName.text = contact.name
                contactNumber.text = contact.number

                contactImage.setBackgroundResource(randomView())
            }
        }
    }

    @ColorRes
    private fun randomView(): Int {
        val list = listOf(
            R.drawable.shape,
            R.drawable.shape2
        )
        return list.random()
    }
}