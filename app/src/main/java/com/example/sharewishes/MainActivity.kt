package com.example.sharewishes

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import com.example.sharewishes.fragments.FavouriteFragment
import com.example.sharewishes.fragments.HomeFragment
import com.example.sharewishes.utils.Utils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        addFragmentToUi(HomeFragment::class.java)
        navigation.setOnNavigationItemSelectedListener() {
            if (it.itemId == R.id.home) {
                if (frameLayout.tag != null && frameLayout.tag != HomeFragment::class.java.simpleName) {
                    addFragmentToUi(HomeFragment::class.java)
                }
                return@setOnNavigationItemSelectedListener true
            } else if (it.itemId == R.id.favourites) {

                if (frameLayout.tag != null && frameLayout.tag != FavouriteFragment::class.java.simpleName) {
                    addFragmentToUi(FavouriteFragment::class.java)
                }
                return@setOnNavigationItemSelectedListener true
            }

            return@setOnNavigationItemSelectedListener false
        }

    }



    private fun addFragmentToUi(className: Class<out Fragment>) {
        Utils.openFragment(supportFragmentManager, className, R.id.frameLayout);
        frameLayout.setTag(className.simpleName)

    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
