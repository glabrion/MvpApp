package ru.glabrion.main.screens.general

import kotlinx.coroutines.*
import ru.glabrion.base.presenter.BasePresenter
import kotlin.coroutines.CoroutineContext

class GeneralPresenter : BasePresenter<GeneralContractInterface.View>(),
    GeneralContractInterface.Presenter, GeneralContractInterface.Interactor, CoroutineScope {

    private val generalInteractor = GeneralInteractor()
    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    fun showToast() {
        var text = ""
        launch {
            withContext(Dispatchers.Main) {
                view?.showProgress()
                text = generalInteractor.getContent()
                if (text.isNotEmpty()) {
                    view?.showToast(text)
                } else {
                    view?.showError()
                }
                view?.hideProgress()
            }
        }
    }
}