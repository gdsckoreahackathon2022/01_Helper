/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [ActionGuidelineAdapter.kt] created by Ji Sungbin on 22. 2. 1. 오후 4:32
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.activity.contact

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import team.gdsc.shelper.R
import team.gdsc.shelper.activity.contact.model.Contact
import team.gdsc.shelper.databinding.LayoutContactItemBinding

class ContactAdpater : RecyclerView.Adapter<ContactAdpater.ContactViewHolder>() {

    private var contacts = Contact.getAll()

    class ContactViewHolder(private val binding: LayoutContactItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(contact: Contact) {
            binding.contact = contact
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.layout_contact_item,
                parent,
                false
            )
        )
    }

    override fun getItemId(position: Int) = position.toLong()

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(contacts[position])
    }

    override fun getItemCount() = contacts.size
}
