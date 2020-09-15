package ru.glabrion.main.screens.general

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_general.*
import kotlinx.android.synthetic.main.fragment_general.view.*
import ru.glabrion.R
import ru.glabrion.base.view.BaseFragment
import ru.glabrion.main.MainActivity

class GeneralFragment : BaseFragment(), GeneralContractInterface.View {

    private val generalPresenter = GeneralPresenter()

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
        ok_button.setOnClickListener {
            val name = view.name_et.text.toString()
            generalPresenter.onOkButtonClick(name)
        }
    }

    override fun showError() {
        Toast.makeText(context, context?.getText(R.string.error_text), Toast.LENGTH_LONG).show()
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

    override fun hideKeyboard() {
        val imm: InputMethodManager =
            activity?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        var view = activity?.currentFocus
        if (view == null) {
            view = View(activity)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    override fun setErrorState() {
        view?.name_et?.error = context?.getText(R.string.error_text_hint)
    }

}