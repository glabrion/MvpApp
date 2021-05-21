package ru.glabrion.main.screens.hello

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import ru.glabrion.R
import ru.glabrion.base.view.BaseFragment
import ru.glabrion.databinding.FragmentHelloBinding
import ru.glabrion.main.MainActivity

class HelloFragment : BaseFragment(R.layout.fragment_hello), HelloContractInterface.View {

    companion object {
        const val TAG = "HelloFragmentTag"
    }

    private val helloPresenter = HelloPresenter()

    private var fragmentHelloBinding: FragmentHelloBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHelloBinding.inflate(inflater, container, false)
        fragmentHelloBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        helloPresenter.attach(this)
        fragmentHelloBinding?.okButton?.setOnClickListener {
            val name = fragmentHelloBinding?.nameEt?.text.toString()
            helloPresenter.onOkButtonClick(name)
        }
    }

    override fun getTitle() = getString(R.string.hello_fragment)

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
        fragmentHelloBinding?.nameEt?.error = context?.getText(R.string.error_text_hint)
    }

    override fun onDestroyView() {
        helloPresenter.detach()
        fragmentHelloBinding = null
        super.onDestroyView()
    }
}