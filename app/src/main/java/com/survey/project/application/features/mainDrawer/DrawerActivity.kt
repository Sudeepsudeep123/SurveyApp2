package com.survey.project.application.features.mainDrawer

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.survey.project.application.R
import com.survey.project.application.features.form.activity.FormActivity
import com.survey.project.application.features.mainDrawer.ui.home.HomeFragment
import com.survey.project.application.utils.constants.FragmentTagConstants
import com.survey.project.application.utils.router.Router
import kotlinx.android.synthetic.main.activity_drawer.*

class DrawerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var mDrawerToggle: ActionBarDrawerToggle? = null
    private lateinit var homeFragment: HomeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        nav_view.setNavigationItemSelectedListener(this)

    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {

                if (!::homeFragment.isInitialized) {
                    homeFragment = HomeFragment()
                    Log.e("here", "login")

                    Router.attachFragment(
                        this,
                        R.id.mainFrame,
                        homeFragment,
                        FragmentTagConstants.homeFragmentTag,
                        false
                    )
                }

            }
            R.id.nav_form -> {
                var intent = Intent(this,
                    FormActivity::class.java)
                startActivity(intent)

            }
            R.id.nav_slideshow -> {
                Toast.makeText(this, "selected $item", Toast.LENGTH_SHORT).show()
            }

        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

}