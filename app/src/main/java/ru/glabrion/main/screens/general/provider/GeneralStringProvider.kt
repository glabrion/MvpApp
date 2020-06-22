package ru.glabrion.main.screens.general.provider

import android.content.Context
import ru.glabrion.R

class GeneralStringProvider(private val context: Context?) {
    fun getErrorText() = context?.getText(R.string.error_text) ?: ""
}