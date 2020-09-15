package ru.glabrion.main.screens.general

import kotlinx.coroutines.*
import ru.glabrion.base.presenter.BasePresenter
import kotlin.coroutines.CoroutineContext

class GeneralPresenter : BasePresenter<GeneralContractInterface.View>(),
    GeneralContractInterface.Presenter, CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Job() + Dispatchers.IO

    override fun onOkButtonClick(name: String?) {
        launch {
            withContext(Dispatchers.Main) {
                view?.showProgress()
                name?.let {
                    view?.hideKeyboard()
                    val text = getContent(name)
                    if (name.isNotEmpty()) {
                        view?.showToast(text)
                    } else {
                        view?.setErrorState()
                        view?.showError()
                    }
                }
                view?.hideProgress()
            }
        }
    }

    override suspend fun getContent(name: String?): String =
        withContext(coroutineContext) {
            // return string after 1 second
            delay(1000)
            "$HELLO_TEXT $name"
        }

    companion object {
        const val HELLO_TEXT = "HELLO"
    }
}