/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [ContactItem.kt] created by Ji Sungbin on 22. 2. 1. 오후 5:25
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.activity.contact.model

@Suppress("DataClassPrivateConstructor")
data class Contact private constructor(
    val name: String,
    val number: String,
) {
    companion object {
        fun getAll() = listOf(
            Contact("행정안전부", "044)205-6366"),
            Contact("기상청", "02)2181-0900"),
            Contact("행정안전부 중앙재난안전상황실", "044)205-1542"),
            Contact("재난신고", "119"),
            Contact("보건복지부", "044)202-2652"),
            Contact("질병관리청", "043)719-7265"),
            Contact("농림축산식품부", "044)201-1474"),
            Contact("농촌진흥청", "1544-8572"),
            Contact("해양수산부", "044)200-5617"),
            Contact("교육부", "044)203-6355"),
        )
    }
}
