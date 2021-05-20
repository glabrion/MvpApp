package ru.glabrion.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import ru.glabrion.R
import ru.glabrion.databinding.ActivityMainBinding
import ru.glabrion.main.screens.general.GeneralFragment
import ru.glabrion.main.screens.hello.HelloFragment


class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private var activityMainBinding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
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
        activityMainBinding?.mainProgress?.visibility = View.VISIBLE
    }

    fun hideProgress() {
        activityMainBinding?.mainProgress?.visibility = View.GONE
    }

    fun openHelloScreen() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<HelloFragment>(R.id.fragment_container_view, HelloFragment.TAG)
            addToBackStack(HelloFragment.TAG)
        }
    }

}