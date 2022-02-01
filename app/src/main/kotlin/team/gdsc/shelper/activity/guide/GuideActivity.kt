/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [GuideActivity.kt] created by Ji Sungbin on 22. 1. 30. 오후 3:56
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.activity.guide

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import team.gdsc.shelper.R
import team.gdsc.shelper.activity.guide.model.GuideItem
import team.gdsc.shelper.databinding.ActivityGuideBinding

class GuideActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGuideBinding
    private val guideAdapter by lazy { GuideAdpater() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_guide)

        binding.ivBack.setOnClickListener {
            finish()
        }

        binding.rvGuide.apply {
            setHasFixedSize(true)
            adapter = guideAdapter.apply {
                setHasStableIds(true)
                submitItems(getFilteredItem())
            }
        }

        binding.cgContainer.setOnCheckedChangeListener { _, checkedId ->
            val item = getFilteredItem(
                when (checkedId) {
                    R.id.chip_flood -> "홍수"
                    R.id.chip_volcano -> "화산"
                    R.id.chip_typhoon -> "태풍"
                    R.id.chip_earthquake -> "지진"
                    R.id.chip_heat_wave -> "폭염"
                    R.id.chip_heavy_snow -> "폭설"
                    R.id.chip_heavy_rain -> "호우"
                    R.id.chip_tsunami -> "쓰나미"
                    else -> "전체"
                }
            )
            guideAdapter.submitItems(item)
        }
    }

    private fun getFilteredItem(disasterName: String = "전체") = GuideItem.getAll().run {
        when (disasterName) {
            "전체" -> this
            else -> filter { it.title == disasterName }
        }
    }
}
