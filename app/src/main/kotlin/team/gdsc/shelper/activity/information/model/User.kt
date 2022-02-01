/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [User.kt] created by Ji Sungbin on 22. 2. 1. 오후 6:08
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.activity.information.model

data class User(
    val name: String,
    val action: String,
    val email: String,
    val memoji: String,
) {
    companion object {
        private val names = listOf("성빈", "민경", "예슬", "소윤")
        private val memojis = mapOf(
            "성빈" to "https://github.com/jisungbin/jisungbin.github.io/blob/main/assets/memoji.png?raw=true",
            "소윤" to "https://github.com/jisungbin/jisungbin.github.io/blob/main/assets/%E1%84%86%E1%85%B5%E1%84%86%E1%85%A9%E1%84%8C%E1%85%B5/%E1%84%89%E1%85%A9%E1%84%8B%E1%85%B2%E1%86%AB%E1%84%82%E1%85%B5%E1%86%B7.png?raw=true",
            "민경" to "https://github.com/jisungbin/jisungbin.github.io/blob/main/assets/%E1%84%86%E1%85%B5%E1%84%86%E1%85%A9%E1%84%8C%E1%85%B5/%E1%84%86%E1%85%B5%E1%86%AB%E1%84%80%E1%85%A7%E1%86%BC%E1%84%82%E1%85%B5%E1%86%B7.png?raw=true",
            "예슬" to "https://github.com/jisungbin/jisungbin.github.io/blob/main/assets/%E1%84%86%E1%85%B5%E1%84%86%E1%85%A9%E1%84%8C%E1%85%B5/%E1%84%8B%E1%85%A8%E1%84%89%E1%85%B3%E1%86%AF%E1%84%82%E1%85%B5%E1%86%B7.png?raw=true"
        )
        private val emails = mapOf(
            "민경" to "cloud.wooo0n@gmail.com",
            "소윤" to "soyun048@gmail.com",
            "예슬" to "20190525@sungshin.ac.kr",
            "성빈" to "ji@sungb.in"
        )
        private val actions = mapOf(
            "성빈" to "개발",
            "민경" to "개발",
            "소윤" to "디자인",
            "예슬" to "기획"
        )

        fun getAll() = names.map { name ->
            User(
                name = name,
                action = actions[name]!!,
                email = emails[name]!!,
                memoji = memojis[name]!!
            )
        }
    }
}
