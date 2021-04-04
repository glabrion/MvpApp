package ru.glabrion.main.screens.general

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import ru.glabrion.R
import ru.glabrion.base.view.BaseFragment
import ru.glabrion.databinding.FragmentGeneralBinding
import ru.glabrion.main.MainActivity

class GeneralFragment : BaseFragment(R.layout.fragment_general), GeneralContractInterface.View {

    companion object {
        const val TAG = "GeneralFragmentTag"
    }

    private val generalPresenter = GeneralPresenter()

    private var fragmentGeneralBinding: FragmentGeneralBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentGeneralBinding.bind(view)
        fragmentGeneralBinding = binding
        generalPresenter.attach(this)
        fragmentGeneralBinding?.okButton?.setOnClickListener {
            val name = fragmentGeneralBinding?.nameEt?.text.toString()
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
        fragmentGeneralBinding?.nameEt?.error = context?.getText(R.string.error_text_hint)
    }

    override fun onDestroyView() {
        generalPresenter.detach()
        fragmentGeneralBinding = null
        super.onDestroyView()
    }
}