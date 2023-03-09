package com.example.submissiondicoding

import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

class SetDataAbout:AppCompatActivity() {
    companion object {
        const val EXTRA_NAMA = "extra_name"
        const val EXTRA_EMAIL = "extra_email"
    }

    override fun onCreate(savedInstanceState: Bundle?,) {
        super.onCreate(savedInstanceState, )
        setContentView(R.layout.about_layout)
        val actionBar = supportActionBar

        actionBar?.title = "About Me"
        actionBar?.setDisplayHomeAsUpEnabled(true)
        val setName:TextView = findViewById(R.id.tv_userName)
        val setEmail:TextView =findViewById(R.id.tv_email)

        setName.text = intent.getStringExtra(EXTRA_NAMA)
        setEmail.text=intent.getStringExtra(EXTRA_EMAIL)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home->{
                onBackPressedDispatcher.onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}