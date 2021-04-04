package ru.glabrion.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import kotlinx.android.synthetic.main.activity_main.*
import ru.glabrion.R
import ru.glabrion.main.screens.general.GeneralFragment


class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (supportFragmentManager.backStackEntryCount == 0) {
            openGeneralScreen()
        }
    }

    private fun openGeneralScreen() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<GeneralFragment>(R.id.fragment_container_view)
            addToBackStack(GeneralFragment.TAG)
        }
    }

    fun showProgress() {
        main_progress.visibility = View.VISIBLE
    }

    fun hideProgress() {
        main_progress.visibility = View.GONE
    }

}