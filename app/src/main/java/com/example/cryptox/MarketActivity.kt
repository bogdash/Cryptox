package com.example.cryptox

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.cryptox.databinding.ActivityMarketBinding

class MarketActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMarketBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_market)
        setSupportActionBar(findViewById(R.id.toolbar))
        binding = ActivityMarketBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        replaceFragment(MarketFragment())

        loadFragment(HomeFragment.newInstance())
        binding.bottomNavigationView.setOnItemReselectedListener { item ->
            var fragment: Fragment
            when (item.itemId) {
                R.id.home_item -> {
                    binding.toolbar.title = "Home"
                    fragment = HomeFragment()
                    loadFragment(fragment)
                    true
                }
                R.id.trends_item -> {
                    binding.toolbar.title = "Trends"
                    fragment = TrendsFragment()
                    loadFragment(fragment)
                    true
                }
                R.id.market_item -> {
                    binding.toolbar.title = "Market"
                    fragment = MarketFragment()
                    loadFragment(fragment)
                    true
                }
                R.id.qr_scanner_item -> {
                    binding.toolbar.title = "QRScanner"
                    fragment = QRScannerFragment()
                    loadFragment(fragment)
                    true
                }
                R.id.user_item -> {
                    binding.toolbar.title = "User"
                    fragment = UserFragment()
                    loadFragment(fragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(marketFragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, marketFragment)
        fragmentTransaction.commit()
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
}