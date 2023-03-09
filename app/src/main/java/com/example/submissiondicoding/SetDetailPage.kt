package com.example.submissiondicoding

import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import androidx.activity.OnBackPressedDispatcher
import androidx.annotation.RequiresApi

class SetDetailPage:AppCompatActivity(){
    companion object{
        val EXTRA_PHOTO = "photo"
        val EXTRA_NAMEDETAIL ="name_detail"
        val EXTRA_DESCDETAIL ="desc_detail"
        val EXTRA_DETAIL ="detail"

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_page)
        val actionBar = supportActionBar
        actionBar?.title = "Detail Of Movie"
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val setImageMovies : ImageView = findViewById(R.id.iv_detailImage)
        val setNameMovies : TextView = findViewById(R.id.tv_moviesNameDetail)
        val setDescMovies : TextView = findViewById(R.id.tv_moviesDescription)
        val setTahun :TextView =findViewById(R.id.tv_tahun)


        setNameMovies.text = intent.getStringExtra(EXTRA_NAMEDETAIL)
        setDescMovies.text = intent.getStringExtra(EXTRA_DESCDETAIL)
        setTahun.text = intent.getStringExtra(EXTRA_DETAIL)

        val getImage = intent.getStringExtra(EXTRA_PHOTO)

        Glide.with(this)
            .load(getImage)
            .into(setImageMovies)
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


