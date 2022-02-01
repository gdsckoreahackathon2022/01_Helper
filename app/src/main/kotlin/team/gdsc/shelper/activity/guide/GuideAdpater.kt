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
import team.gdsc.shelper.activity.guide.model.Guide
import team.gdsc.shelper.databinding.LayoutGuideItemBinding

class GuideAdpater : RecyclerView.Adapter<GuideAdpater.GuideViewHolder>() {

    private var guides = emptyList<Guide>()

    class GuideViewHolder(private val binding: LayoutGuideItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(guide: Guide) {
            binding.guide = guide
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuideViewHolder {
        return GuideViewHolder(
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
    fun submitItems(items: List<Guide>) {
        this.guides = items
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: GuideViewHolder, position: Int) {
        holder.bind(guides[position])
    }

    override fun getItemCount() = guides.size
}
