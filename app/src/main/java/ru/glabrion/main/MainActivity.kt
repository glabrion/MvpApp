package ru.glabrion.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.*
import ru.glabrion.R
import ru.glabrion.databinding.ActivityMainBinding
import ru.glabrion.main.screens.general.GeneralFragment
import ru.glabrion.main.screens.hello.HelloFragment


class MainActivity : AppCompatActivity(R.layout.activity_main),
    FragmentManager.OnBackStackChangedListener {

    private var activityMainBinding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        if (supportFragmentManager.backStackEntryCount == 0) {
            openGeneralScreen()
        }
        supportFragmentManager.addOnBackStackChangedListener(this)
    }

    private fun openGeneralScreen() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<GeneralFragment>(R.id.fragment_container_view)
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

    override fun onBackStackChanged() {
        val canGoBack = supportFragmentManager.backStackEntryCount > 1
        supportActionBar?.setDisplayHomeAsUpEnabled(canGoBack)
    }

    override fun onSupportNavigateUp(): Boolean {
        supportFragmentManager.popBackStack()
        return true
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1) {
            supportFragmentManager.popBackStack()
        } else {
            finish()
        }
    }

}