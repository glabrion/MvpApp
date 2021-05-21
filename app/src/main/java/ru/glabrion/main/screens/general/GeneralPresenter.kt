package ru.glabrion.main.screens.general

import ru.glabrion.base.presenter.BasePresenter

class GeneralPresenter : BasePresenter<GeneralContractInterface.View>(),
    GeneralContractInterface.Presenter {

    override fun onToHelloScreenClick() {
        view?.openHelloScreen()
    }
}