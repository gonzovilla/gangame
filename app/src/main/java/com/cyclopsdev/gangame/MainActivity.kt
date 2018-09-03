package com.cyclopsdev.gangame

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.cyclopsdev.gangame.deals.DealsFragment
import com.cyclopsdev.gangame.owned.TopOwnedFragment
import com.cyclopsdev.gangame.rated.TopRatedFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        val DEFAULT_OPTION = R.id.action_deals
    }

    val fragments: HashMap<Int, Fragment> = hashMapOf(
            Pair(R.id.action_deals, DealsFragment()),
            Pair(R.id.action_top_rated, TopRatedFragment()),
            Pair(R.id.action_most_owned, TopOwnedFragment())
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        navigation.selectedItemId = DEFAULT_OPTION
        navigation.setOnNavigationItemSelectedListener { item ->
            val fragment: Fragment? = fragments[item.itemId]

            if (fragment != null)
                replaceFragment(fragment)
            
            true
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()
    }

    fun initView(){
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)

        if (currentFragment == null)
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragmentContainer, fragments[DEFAULT_OPTION])
                    .commit()
    }

}
