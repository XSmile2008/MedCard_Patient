package com.catandowl.medcardpatient.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.ActionBarDrawerToggle
import com.catandowl.medcardpatient.AppClass
import com.catandowl.medcardpatient.R
import com.catandowl.medcardpatient.databinding.ActivityMainBinding
import com.catandowl.medcardpatient.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.layout_toolbar.*
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var navigationHolder: NavigatorHolder

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppClass.component.inject(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getNavigation().observe(this, Observer {
            when (it?.clazz) {
                SignInActivity::class.java -> {
                    startActivity(Intent(this, it.clazz).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK))
                    finish()
                }
            }
        })
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.navigation.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_logout -> {
                    viewModel.onLogoutAction()
                    true
                }
                else -> false
            }
        }

        val toggle = ActionBarDrawerToggle(this, binding.drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        toggle.syncState()
    }

    override fun onContentChanged() {
        super.onContentChanged()
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
    }
}
