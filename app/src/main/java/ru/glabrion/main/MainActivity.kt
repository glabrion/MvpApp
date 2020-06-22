package ru.glabrion.main

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import ru.glabrion.R
import ru.glabrion.base.view.BaseActivity
import ru.glabrion.main.screens.general.GeneralFragment

class MainActivity : BaseActivity() {

    override val layoutResId: Int
        get() = R.layout.activity_main

    override fun init(state: Bundle?) {
        openGeneralScreen()
    }

    fun showProgress() {
        main_progress.visibility = View.VISIBLE
    }

    fun hideProgress() {
        main_progress.visibility = View.GONE
    }

    private fun openGeneralScreen(){
        val generalFragment = GeneralFragment()
        supportFragmentManager.beginTransaction().replace(
            R.id.main_fragment_container,
            generalFragment
        ).addToBackStack(generalFragment.tag)
            .commit()
    }
}