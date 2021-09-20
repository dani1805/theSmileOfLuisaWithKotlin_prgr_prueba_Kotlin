package com.example.thesmileofluisawithkotlin

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navView)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        setSupportActionBar(toolbar)

        supportActionBar!!.title = "La sonrisa de Luisa"
        bottomNavigationView.selectedItemId = R.id.home
        navigateToFragment(R.id.home)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            val id = item.itemId
            navigateToFragment(id)
            true
        }
    }

    private fun navigateToFragment(itemId: Int) {
        val fragment: Fragment
        var title = getString(R.string.Inicio)
        when (itemId) {

            R.id.Home -> {
                title = getString(R.string.Inicio)
                fragment = FragmentHome()

            }
            R.id.Masks -> {
                title = getString(R.string.Mascarillas)
                fragment = FragmentMask()

            }
            R.id.Contact -> {
                title = getString(R.string.Contacto)
                fragment = FragmentContact()

            }

            else -> {
                title = getString(R.string.Inicio)
                fragment = FragmentHome()

            }

        }

        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.replace(R.id.myFrameLayout, fragment)
        transaction.commit()
        supportActionBar!!.title = title

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.logout -> {

                val loginIntent = Intent(this@MainActivity, LoginActivity::class.java)
                startActivity(loginIntent)
            }

        }
        return super.onOptionsItemSelected(item)
    }
}


