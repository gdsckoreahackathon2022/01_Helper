/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [GuideActivity.kt] created by Ji Sungbin on 22. 1. 30. 오후 3:56
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.activity.contact

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import team.gdsc.shelper.R
import team.gdsc.shelper.databinding.ActivityContactBinding

class ContactActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactBinding
    private val contactAdpater by lazy { ContactAdpater() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_contact)

        binding.ivBack.setOnClickListener {
            finish()
        }

        binding.rvGuide.apply {
            setHasFixedSize(true)
            adapter = contactAdpater.apply {
                setHasStableIds(true)
            }
        }
    }
}
