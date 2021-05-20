package ru.glabrion.main.screens.general

import kotlinx.coroutines.*
import ru.glabrion.base.presenter.BasePresenter
import kotlin.coroutines.CoroutineContext

class GeneralPresenter : BasePresenter<GeneralContractInterface.View>(),
    GeneralContractInterface.Presenter {

    override fun onToHelloScreenClick() {
        view?.openHelloScreen()
    }
}