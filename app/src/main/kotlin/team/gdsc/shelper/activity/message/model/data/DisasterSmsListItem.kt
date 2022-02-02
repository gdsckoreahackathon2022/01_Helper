/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [DisasterSmsListItem.kt] created by Ji Sungbin on 22. 2. 1. 오후 8:13
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.activity.message.model.data

import com.fasterxml.jackson.annotation.JsonProperty

data class DisasterSmsListItem(
    @field:JsonProperty("DSSTR_SE_NM")
    val dSSTRSENM: String? = null,

    @field:JsonProperty("CREAT_DT")
    val cREATDT: String? = null,

    @field:JsonProperty("RCV_AREA_NM")
    val rCVAREANM: String? = null,

    @field:JsonProperty("MD101_SN")
    val mD101SN: Int? = null,

    @field:JsonProperty("DSSTR_SE_ID")
    val dSSTRSEID: String? = null,

    @field:JsonProperty("MODF_DT")
    val mODFDT: String? = null,

    @field:JsonProperty("RCV_AREA_ID")
    val rCVAREAID: String? = null,

    @field:JsonProperty("UPDUSR_ID")
    val uPDUSRID: String? = null,

    @field:JsonProperty("MSG_SE_CD")
    val mSGSECD: String? = null,

    @field:JsonProperty("DELETE_AT")
    val dELETEAT: String? = null,

    @field:JsonProperty("MSG_CN")
    val msgCn: String? = null,

    @field:JsonProperty("RNUM")
    val rNUM: Int? = null,

    @field:JsonProperty("EMRGNCY_STEP_ID")
    val eMRGNCYSTEPID: String? = null,

    @field:JsonProperty("REGIST_DT")
    val rEGISTDT: String? = null,

    @field:JsonProperty("REGISTER_ID")
    val rEGISTERID: String? = null,

    @field:JsonProperty("EMRGNCY_STEP_NM")
    val eMRGNCYSTEPNM: String? = null,
)
