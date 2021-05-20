package ru.glabrion.main.screens.general

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentGeneralBinding.inflate(inflater, container, false)
        fragmentGeneralBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        generalPresenter.attach(this)
        fragmentGeneralBinding?.toHelloScreenButton?.setOnClickListener {
            generalPresenter.onToHelloScreenClock()
        }
    }

    override fun onDestroyView() {
        generalPresenter.detach()
        fragmentGeneralBinding = null
        super.onDestroyView()
    }

    override fun openHelloScreen() {
        (activity as? MainActivity)?.openHelloScreen()
    }
}