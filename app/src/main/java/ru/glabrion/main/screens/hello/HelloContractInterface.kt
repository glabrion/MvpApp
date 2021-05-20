package ru.glabrion.main.screens.hello

import ru.glabrion.base.presenter.BasePresenterInterface
import ru.glabrion.base.view.BaseViewInterface

interface HelloContractInterface {

    interface View : BaseViewInterface {
        fun showError()
        fun showProgress()
        fun hideProgress()
        fun showToast(text: String)
        fun hideKeyboard()
        fun setErrorState()
    }

    interface Presenter : BasePresenterInterface<View>{
        fun onOkButtonClick(name: String?)
        suspend fun getContent(name: String?): String
    }
}