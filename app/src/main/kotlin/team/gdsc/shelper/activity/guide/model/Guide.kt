/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [GuideItem.kt] created by Ji Sungbin on 22. 1. 30. 오후 3:56
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.activity.guide.model

data class Guide(val title: String, val content: String, val image: String) {
    companion object {
        private val titles = listOf("홍수", "호우", "쓰나미", "태풍", "화산", "지진", "폭염", "폭설")
        private val images = mapOf(
            "홍수" to "https://github.com/jisungbin/jisungbin.github.io/blob/main/assets/disaster/flood-3063989_640.jpg?raw=true",
            "호우" to "https://github.com/jisungbin/jisungbin.github.io/blob/main/assets/disaster/rain-3518956_640.jpg?raw=true",
            "쓰나미" to "https://github.com/jisungbin/jisungbin.github.io/blob/main/assets/disaster/fantasy-4340503_640.jpg?raw=true",
            "태풍" to "https://github.com/jisungbin/jisungbin.github.io/blob/main/assets/disaster/cyclone-62957_640.jpg?raw=true",
            "화산" to "https://github.com/jisungbin/jisungbin.github.io/blob/main/assets/disaster/volcano-3895614_640.jpg?raw=true",
            "지진" to "https://github.com/jisungbin/jisungbin.github.io/blob/main/assets/disaster/cracks-2099531_640.jpg?raw=true",
            "폭염" to "https://github.com/jisungbin/jisungbin.github.io/blob/main/assets/disaster/road-4540_640.jpg?raw=true",
            "폭설" to "https://github.com/jisungbin/jisungbin.github.io/blob/main/assets/disaster/snow-1813463_640.jpg?raw=true"
        )
        private val contents = mapOf(
            "홍수" to "< 홍수 전 >\n" + "\n" +
                "    - 홍수피해가 예상되는 지역의 주민은 라디오나 TV, 인터넷을 통해 기상변화를 알아두기\n" +
                "    - 홍수 우려 때 피난 가능한 장소와 길을 사전에 숙지\n" +
                "    - 홍수 예상 시 전기차단기를 내리고 가스 밸브를 잠금\n" + "\n" + "\n" +

                "< 홍수 중 >\n" + "\n" +
                "    - 홍수 특보기준 : 국토교통부 기술자의 안전조사가 끝난 후 사용\n" +
                "    - 수돗물이나 저장식수도 오염 여부를 반드시 조사 후에 사용",

            "호우" to "< 호우 중 >\n" + "\n" +
                "    - 자주 물에 잠기는 지역, 산사태 위험지역 등의 위험한 곳은 피하고 안전한 곳으로 대피하기\n" +
                "    - 실내에서는 문과 창문을 닫고, 외출을 하지 않고 TV, 라디오, 인터넷 등을 통해 기상상황을 확인하기\n" +
                "    - 개울가, 하천변, 해안가 등 침수 위험지역은 급류에 휩쓸릴 수 있으니 가까이 가지 않기\n" +
                "    - 산과 계곡의 등산객은 계곡이나 비탈면 가까이 가지 않고 안전한 곳으로 대피하기\n" +
                "    - 공사자재가 넘어질 수 있으니 공사장 근처에 가까이 가지 않기\n" +
                "    - 농촌에서는 논둑이나 물꼬의 점검을 위해 나가지 않기",

            "쓰나미" to "< 쓰나미 전 >\n" + "\n" +
                "    - TV나 라디오를 통한 기상상황이나 해일경보 등을 주의 깊게 듣기\n" +
                "    - 해안 저지대 주민은 비상상황 발생 시를 대비하여 대피장소 및 대피방법을 미리 알아두기\n" +
                "    - 가까운 행정기관의 전화번호는 온 가족이 알 수 있는 곳에 두고 이웃 간의 연락방법을 알아두기\n" + "\n" + "\n" +
                "< 쓰나미 중 >\n" + "\n" +
                "    - 공사 중인 현장에서는 작업을 중지하고 떠내려가거나 파손될 우려가 있는 기자재들은 안전한 곳으로 이동하기\n" +
                "    - 기상청의 해일경보, 시·군·구청 또는 소방서의 대피명령이 있을 때 즉시 대피하기\n" +
                "    - 해일이 밀려들 때 대피하기\n" +
                "    - **높을수록 안전하니 높은 곳으로 이동하기**\n" +
                "    - 목조 주택은 떠내려갈 가능성이 있으니 벽돌이나 철근콘크리트 건물로 이동하기\n" +
                "    - 해안에 가까울수록 위험하므로 해일이 발생하면 해안에서 멀리 떨어진 급경사가 없고 지형이 높은 안전한 곳으로 이동하기\n" +
                "    - 해안에서 멀리 떨어진 곳은 직접적인 파도의 영향이 없으므로 바닥에서 높이가 2~3m만 높아도 비교적 안전",

            "태풍" to "< 태풍 중 >\n" + "\n" +
                "    - 자주 물에 잠기는 지역, 산사태 위험지역 등의 위험한 곳은 피하고 안전한 곳으로 대피하기\n" +
                "    - 실내에서는 문과 창문을 닫고, 외출을 하지 않고 TV, 라디오, 인터넷 등을 통해 기상상황을 확인하기\n" +
                "    - 개울가, 하천변, 해안가 등 침수 위험지역은 급류에 휩쓸릴 수 있으니 가까이 가지 않기\n" +
                "    - 산과 계곡의 등산객은 계곡이나 비탈면 가까이 가지 않고 안전한 곳으로 대피하기\n" +
                "    - 공사자재가 넘어질 수 있으니 공사장 근처에 가까이 가지 않기\n" +
                "    - 농촌에서는 논둑이나 물꼬의 점검을 위해 나가지 않기",

            "화산" to "< 화산재 낙하 전 >\n" + "\n" +
                "    - 문틈이나 환기구는 물 묻힌 수건으로 막고, 창문은 테이프로 막기\n" +
                "    - 배수로가 화산재로 막히지 않게 낙수받이나 배수관을 지붕 홈통으로부터 분리\n" +
                "    - 만성기관지염이나 폐기종, 천식 환자는 실내에 머무르기\n" +
                "    - 빗물을 급수용으로 사용하는 경우에는 빗물 수집 시설과 탱크에 연결된 파이프를 분리\n" + "\n" + "\n" +
                "< 화산재 낙하 중 >\n" + "\n" +
                "    - 실외에 있을 경우 자동차나 건물 등으로 신속하게 대피\n" +
                "    - **가능한 실내에 머무르기**\n" +
                "    - 마스크나 손수건, 옷으로 코와 입을 막기\n" +
                "    - TV나 라디오로 재난 방송을 듣기\n" +
                "    - 각막 손상 위험이 있으므로 콘택트렌즈를 착용하지 않기\n" +
                "    - 물에 화산재가 들어간 경우, 가라앉은 후 웃물을 사용하기\n" + "\n" + "\n" +
                "< 화산재 낙하 후 >\n" + "\n" +
                "    - 고글과 마스크를 착용하고 실내‧외 및 자동차를 신속하게 청소하기\n" +
                "    - 가전제품은 청소하기 전에 전원을 차단하기\n" +
                "    - 밖에서 입은 옷은 갈아입고 몸을 깨끗이 씻기\n" +
                "    - 수거한 화산재는 튼튼한 비닐봉지에 넣어 지정된 장소에 버리기\n" +
                "    - 화산재가 날리지 않도록 물을 가볍게 뿌리거나 젖은 걸레를 사용하기",
            "지진" to "< 지진 발생 중 >\n" + "\n" +
                "    - 튼튼한 탁자 아래에 들어가 몸을 보호하기\n" +
                "    - 가스와 전깃불을 차단하고 문을 열어 출구를 확보하기\n" +
                "    - 집에서 나갈 때는 신발은 꼭 신고 이동하기\n" +
                "    - 계단을 이용하여 밖으로 대피하기\n" +
                "    - 건물이나 담장으로부터 떨어져 이동하기\n" +
                "    - 낙하물이 없는 넓은 공간으로 대피하기\n" +
                "    - 올바른 정보에 따라 행동하기\n" + "\n" + "\n" +
                "< 지진 발생 후 >\n" + "\n" +
                "    - 가족의 상황과 부상자를 살펴보고 즉시 구조 요청하기\n" +
                "    - 주변의 피해 상황에 따라 귀가 여부를 결정하기\n" +
                "    - 가정이나 사무실로 돌아간 후에는 안전에 유의하여 주변을 확인하기",

            "폭염" to "- 야외활동을 최대한 자제하고, 외출이 꼭 필요한 경우에는 창이 넓은 모자와 가벼운 옷차림을 하고 물병을 반드시 휴대하기\n" +
                "- 물을 많이 마시고, 카페인이 들어간 음료나 주류는 마시지 않기\n" +
                "- 현기증, 메스꺼움, 두통, 근육경련 등의 증세가 보이는 경우에는 시원한 곳으로 이동하여 휴식을 취하고 시원한 음료를 천천히 마시기\n" +
                "- 휴식시간은 장시간 한 번에 쉬기보다는 짧게 자주 갖기\n" +
                "- 외부에 외출 중인 경우나 자택에 냉방기가 설치되어 있지 않은 경우 가장 더운 시간에는 인근 무더위쉼터로 이동하여 더위를 피하기",

            "폭설" to "< 폭설 전 >\n" + "\n" +
                "    - 대설지역 및 지속시간 등을 파악해서 언제, 어떻게, 누구와 대피할지를 생각하기\n" +
                "    - 산간 고립지역‧붕괴 위험시설물 등 위험지역에서는 주변에 있는 사람들과 함께 안전한 곳으로 이동하기\n" +
                "    - 주택이나 차량 등의 보호를 위해 사전에 어떻게 할지를 가족이나 이웃과 함께 대비하기\n" + "\n" + "\n" +
                "< 폭설 중 >\n" + "\n" +
                "    - 눈이 많이 올 때에는 되도록 외출을 자제하여 피해를 사전에 방지하기\n" +
                "    - 외출 시에는 바닥면이 넓은 운동화나 등산화를 착용하고, 주머니에 손을 넣지 말고 보온 장갑 등을 착용하여 체온을 유지하기\n" +
                "    - 되도록 외출을 자제하고 대중교통을 이용하고, 부득이 차량을 이용할 경우에는 반드시 차량용 안전장구(체인, 염화칼슘, 삽 등)를 휴대하기\n" +
                "    - 커브길, 고갯길, 고가도로, 교량, 결빙 구간 등에서는 특히 사고위험이 높으므로 서행하고, 교통사고 예방을 위해 안전거리를 두고 운행하기\n" +
                "    - 차량 이동 중 고립되었을 때에는 가능한 수단을 통해 구조 연락을 취하고, 동승자와 함께 체온을 유지하고 돌아가면서 휴식을 취하기\n" +
                "    - 비닐하우스, 가설 건축물 등은 가족이나 이웃과 함께 미리 점검하고, 지붕에 눈이 쌓이기 전에 치워 두거나, 받침대 등으로 미리 보강하여 피해를 예방하기\n" + "\n" + "\n" +
                "< 폭설 후 >\n" + "\n" +
                "    - 큰눈이 멈춘 후에는 주변의 피해를 확인하고, 가까운 행정복지센터(주민센터) 등에 신고하여 보수·보강하기"
        )

        fun getAll() = titles.map { title ->
            Guide(title = title, content = contents[title]!!, image = images[title]!!)
        }
    }
}
