package com.example.murmur1.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.murmur1.R
import com.example.murmur1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // respose to the item clicke  inside the draweer
        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.tv_account -> Toast.makeText(
                    applicationContext,
                    "No account for now",
                    Toast.LENGTH_SHORT
                ).show()
                else -> Toast.makeText(applicationContext, "No account for now", Toast.LENGTH_SHORT)
                    .show()
            }
            true
        }

    }
        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            if (toggle.onOptionsItemSelected(item)) {
                return true
            }
            return super.onOptionsItemSelected(item)
        }
}