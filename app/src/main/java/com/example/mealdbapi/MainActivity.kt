package com.example.mealdbapi

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mealdbapi.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView


        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        navController = navHost.navController

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_mealcategories, R.id.navigation_areas, R.id.navigation_ingredients
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


        //to hide bottom navigation in details page
        navController.addOnDestinationChangedListener {_, destination, _ ->
            when (destination.id) {
                R.id.navigation_mealcategories -> {
                    navView.visibility = View.VISIBLE
                }
                R.id.navigation_areas -> {
                    navView.visibility = View.VISIBLE
                }
                R.id.navigation_ingredients -> {
                    navView.visibility = View.VISIBLE
                }
                R.id.action_signOut -> {
                    navView.visibility = View.VISIBLE
                }
                else -> {
               //  supportActionBar?.setDisplayHomeAsUpEnabled(false)
                    navView.visibility = View.GONE
                }
            }
        }

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId== R.id.action_signOut){
            FirebaseAuth.getInstance().signOut();
            navController.navigate(R.id.loginFragment)
            Toast.makeText(this, "Logged Out Successfully",
                Toast.LENGTH_SHORT
            ).show()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.sign_out, menu)
        return true
    }
    override fun onSupportNavigateUp(): kotlin.Boolean {
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}


