package com.example.taskandroid.task_appbar_toolbar

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.taskandroid.R

class CollapsingToolBar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collapsing_tool_bar)
        val toolbarTwo: Toolbar =findViewById(R.id.myToolbarTwo)
        setSupportActionBar(toolbarTwo)
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.my_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_new -> {
            Toast.makeText(this,"New Menu Clicked",Toast.LENGTH_SHORT).show()
            true
        }
        R.id.action_favorite -> {
            Toast.makeText(this,"Favorite Menu Clicked",Toast.LENGTH_SHORT).show()
            true
        }
        R.id.action_settings -> {
            Toast.makeText(this,"Settings Menu Clicked",Toast.LENGTH_SHORT).show()
            true
        }
        R.id.action_search -> {
            Toast.makeText(this,"Search Menu Clicked",Toast.LENGTH_SHORT).show()
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}