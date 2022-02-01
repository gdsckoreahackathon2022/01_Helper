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
import team.gdsc.shelper.activity.contact.model.ContactItem
import team.gdsc.shelper.databinding.LayoutContactItemBinding

class ContactAdpater : RecyclerView.Adapter<ContactAdpater.ActionGuidelineHolder>() {

    private var items = ContactItem.getAll()

    class ActionGuidelineHolder(private val binding: LayoutContactItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(contact: ContactItem) {
            binding.contact = contact
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActionGuidelineHolder {
        return ActionGuidelineHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.layout_contact_item,
                parent,
                false
            )
        )
    }

    override fun getItemId(position: Int) = position.toLong()

    override fun onBindViewHolder(holder: ActionGuidelineHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}
