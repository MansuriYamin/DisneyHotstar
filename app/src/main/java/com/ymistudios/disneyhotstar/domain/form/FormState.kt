package com.ymistudios.disneyhotstar.domain.form

import com.ymistudios.disneyhotstar.utils.uitext.UIText

data class FormState(
    val value: String = "",
    val error: UIText? = null,
    val isValid: Boolean = false
)