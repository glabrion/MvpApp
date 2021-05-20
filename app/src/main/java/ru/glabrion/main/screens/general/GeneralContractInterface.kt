package ru.glabrion.main.screens.general

import ru.glabrion.base.presenter.BasePresenterInterface
import ru.glabrion.base.view.BaseViewInterface

interface GeneralContractInterface {

    interface View : BaseViewInterface {
        fun openHelloScreen()
    }

    interface Presenter : BasePresenterInterface<View>{
        fun onToHelloScreenClick()
    }
}