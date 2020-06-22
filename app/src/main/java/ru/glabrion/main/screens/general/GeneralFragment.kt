package ru.glabrion.main.screens.general

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_general.*
import ru.glabrion.R
import ru.glabrion.base.view.BaseFragment
import ru.glabrion.main.MainActivity
import ru.glabrion.main.screens.general.provider.GeneralStringProvider

class GeneralFragment : BaseFragment(), GeneralContractInterface.View {

    private val generalPresenter = GeneralPresenter()
    private val generalStringProvider = GeneralStringProvider(context)

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
        hello_button.setOnClickListener {
            generalPresenter.showToast()
        }
    }

    override fun showError() {
        Toast.makeText(context, generalStringProvider.getErrorText(), Toast.LENGTH_LONG).show()
    }

    override fun showToast(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show()
    }

    override fun showProgress() {
        (activity as? MainActivity)?.showProgress()
    }

    override fun hideProgress() {
        (activity as? MainActivity)?.hideProgress()
    }


}