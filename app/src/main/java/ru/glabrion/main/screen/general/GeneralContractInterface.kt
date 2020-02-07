package ru.glabrion.main.screen.general

import ru.glabrion.base.presenter.BasePresenterInterface
import ru.glabrion.base.repository.BaseRepositoryInterface
import ru.glabrion.base.view.BaseViewInterface

interface GeneralContractInterface {

    interface View : BaseViewInterface {
        fun showError()
        fun showContent(text: String)
        fun showProgress()
        fun hideProgress()
    }

    interface Presenter : BasePresenterInterface<View>

    interface Repository : BaseRepositoryInterface {
        suspend fun getContent(): String
    }
}