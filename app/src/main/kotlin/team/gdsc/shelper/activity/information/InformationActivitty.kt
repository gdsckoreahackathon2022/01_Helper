/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [GuideActivity.kt] created by Ji Sungbin on 22. 1. 30. 오후 3:56
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.activity.information

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import team.gdsc.shelper.R
import team.gdsc.shelper.databinding.ActivityInformationBinding

class InformationActivitty : AppCompatActivity() {

    private lateinit var binding: ActivityInformationBinding
    private val userAdapter by lazy { UserAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_information)

        binding.ivBack.setOnClickListener {
            finish()
        }

        val spanCount = 2 // 3 columns
        val spacing = 50 // 50px
        val includeEdge = true
        binding.rvUser.addItemDecoration(GridSpacingItemDecoration(spanCount, spacing, includeEdge))
        binding.rvUser.apply {
            setHasFixedSize(true)
            adapter = userAdapter.apply {
                setHasStableIds(true)
            }
        }
    }
}
