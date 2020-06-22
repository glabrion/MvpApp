package ru.glabrion.main.screens.general

class GeneralInteractor {

    private val generalRepository = GeneralRepository()

    suspend fun getContent() = generalRepository.getContent()
}