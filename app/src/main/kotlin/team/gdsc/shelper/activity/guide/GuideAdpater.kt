/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [ActionGuidelineAdapter.kt] created by Ji Sungbin on 22. 2. 1. 오후 4:32
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.activity.guide

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import team.gdsc.shelper.R
import team.gdsc.shelper.activity.guide.model.GuideItem
import team.gdsc.shelper.bindingadapter.LayoutGuideItemBinding

class GuideAdpater : RecyclerView.Adapter<GuideAdpater.ActionGuidelineHolder>() {

    private var items = emptyList<GuideItem>()

    class ActionGuidelineHolder(private val binding: LayoutGuideItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(guide: GuideItem) {
            binding.guide = guide
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActionGuidelineHolder {
        return ActionGuidelineHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.layout_guide_item,
                parent,
                false
            )
        )
    }

    override fun getItemId(position: Int) = position.toLong()

    @SuppressLint("NotifyDataSetChanged")
    fun submitItems(items: List<GuideItem>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ActionGuidelineHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}
