package ru.glabrion.main.screen.general

import kotlinx.coroutines.*
import org.koin.core.KoinComponent
import org.koin.core.inject
import ru.glabrion.base.presenter.BasePresenter
import kotlin.coroutines.CoroutineContext

class GeneralPresenter : BasePresenter<GeneralContractInterface.View>(),
    GeneralContractInterface.Presenter,
    CoroutineScope, KoinComponent {

    private val generalRepository: GeneralRepository by inject()
    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    override fun attach(view: GeneralContractInterface.View) {
        super.attach(view)
        launch {
            withContext(Dispatchers.Main) {
                view.showProgress()
                val content = generalRepository.getContent()
                if (!content.isNullOrEmpty()) {
                    view.showContent(content)
                }else{
                    view.showError()
                }
                view.hideProgress()
            }
        }
    }

}