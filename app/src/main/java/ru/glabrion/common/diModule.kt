package ru.glabrion.common

import org.koin.dsl.module
import ru.glabrion.main.screen.general.GeneralContractInterface
import ru.glabrion.main.screen.general.GeneralPresenter
import ru.glabrion.main.screen.general.GeneralRepository

fun mainModule() = module {
    factory <GeneralContractInterface.Presenter> { GeneralPresenter() }
    single { GeneralRepository() }
}