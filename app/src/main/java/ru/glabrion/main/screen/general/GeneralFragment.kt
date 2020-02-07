package ru.glabrion.main.screen.general

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_general.view.*
import org.koin.android.ext.android.inject
import ru.glabrion.R
import ru.glabrion.common.toast
import ru.glabrion.base.view.BaseFragment
import ru.glabrion.main.MainActivity

class GeneralFragment : BaseFragment(), GeneralContractInterface.View {

    private val generalPresenter: GeneralContractInterface.Presenter by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_general, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        generalPresenter.attach(this)
    }

    override fun showError() {
        toast("Ошибка загрузки данных")
    }

    override fun showContent(text: String) {
        view?.content?.setText(text)
    }

    override fun showProgress() {
        (activity as? MainActivity)?.showProgress()
    }

    override fun hideProgress() {
        (activity as? MainActivity)?.hideProgress()
    }


}