package ru.glabrion.main.screens.general

class GeneralInteractor: GeneralContractInterface.Interactor{

    private val generalRepository = GeneralRepository()

    override suspend fun getContent() = generalRepository.getContent()
}