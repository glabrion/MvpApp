package ru.glabrion.main.screens.general

import ru.glabrion.base.interactor.BaseInteractorInterface
import ru.glabrion.base.presenter.BasePresenterInterface
import ru.glabrion.base.repository.BaseRepositoryInterface
import ru.glabrion.base.view.BaseViewInterface

interface GeneralContractInterface {

    interface View : BaseViewInterface {
        fun showError()
        fun showProgress()
        fun hideProgress()
        fun showToast(text: String)
    }

    interface Presenter : BasePresenterInterface<View>{
        fun showToast()
    }

    interface Interactor: BaseInteractorInterface{
        suspend fun getContent(): String
    }

    interface Repository : BaseRepositoryInterface {
        suspend fun getContent(): String
    }
}