package com.ilamathy.echo.activities

import android.os.Bundle
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.ilamathy.echo.R
import com.ilamathy.echo.fragments.MainScreenFragment

class MainActivity : AppCompatActivity(){
    /*This Line is use to define the variable for drawer layout*/
    var drawerLayout: DrawerLayout?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*Below code tells kotlin file that the toolbar is with id toolbar*/
        val toolbar=findViewById<Toolbar>(R.id.toolbar)

        /*Tells compiler that the actionbar will be interactive*/
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)

        /*The icon having 3 parallel horizontal lines is known as the action bar drawer
        toggle. The 4 parameters taken by the this can be understood as the:
        * 1. Activity: In which activity the toggle is placed
        * 2. Drawer Layout: For which drawer layout we are placing this toggle
        * 3. Toolbar: In which toolbar are we placing it
        * 4, 5: Action Commands: The function of drawer when toggle is click, which is open
        and close the drawer*/


        val toggle = ActionBarDrawerToggle(this@MainActivity,drawerLayout,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)

        /*Earlier we only defined the toggle, now we place the listener using the
        addDrawerListener() method
        * Note: In the videos, we told to use setDrawerListener() but now this method cuts
        itself when we use it which means that this method is now deprecated which
         * can be removed from the future versions, hence here we have told the latest
        version of the method i.e. addDrawerListener(). Although as of now the usage
        * setDrawerListener() is also correct*/
        drawerLayout?.setDrawerListener(toggle)
        toggle.syncState()

        val mainScreenFragment = MainScreenFragment()
        this.supportFragmentManager
                .beginTransaction()
                .add(R.id.details_fragment, mainScreenFragment, "MainScreenFragment")
                .commit()
    }

    override fun onStart() {
        super.onStart()
    }
}
