package com.example.submissiondicoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvMovies: RecyclerView
    private val list = arrayListOf<moviesData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMovies = findViewById(R.id.rv_movies)
        rvMovies.setHasFixedSize(true)

        list.addAll(getMovieList())
        showRecyclerList()

    }

    private fun getMovieList():ArrayList<moviesData>{
        val nameData = resources.getStringArray(R.array.name_data)
        val desc = resources.getStringArray(R.array.desc)
        val imageData = resources.getStringArray(R.array.photo_data)
        val dataDetail = resources.getStringArray(R.array.detail)


        val listMovies = ArrayList<moviesData>()
        for(i in nameData.indices){
            val movies = moviesData(nameData[i],desc[i],imageData[i], dataDetail[i],)
            listMovies.add(movies)
        }
        return listMovies
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_list->{
                rvMovies.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid->{
                rvMovies.layoutManager = GridLayoutManager(this,2)
            }
            R.id.action_about->{
                val intent = Intent(this@MainActivity,SetDataAbout::class.java)
                intent.putExtra(SetDataAbout.EXTRA_NAMA, "Rizaldo Setiawan")
                intent.putExtra(SetDataAbout.EXTRA_EMAIL, "a065dsx1707@bangkit.academy")
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
    private fun showRecyclerList(){
        rvMovies.layoutManager = LinearLayoutManager(this)
        val moviesAdapter = movieAdapter(list)
        rvMovies.adapter = moviesAdapter

       moviesAdapter.setOnItemClickCallback(object : movieAdapter.OnItemClickCallback {
           override fun onItemClicked(data: moviesData) {
               showSelectedMovies(data)
           }
       })
    }

    private fun showSelectedMovies(movie:moviesData){
        Toast.makeText(this,"kamu memilih"+ movie.name, Toast.LENGTH_LONG).show()
        val intent = Intent(this@MainActivity, SetDetailPage::class.java)
        intent.putExtra(SetDetailPage.EXTRA_NAMEDETAIL, movie.name)
        intent.putExtra(SetDetailPage.EXTRA_DESCDETAIL, movie.desc)
        intent.putExtra(SetDetailPage.EXTRA_PHOTO,movie.imageData)
        intent.putExtra(SetDetailPage.EXTRA_DETAIL, movie.detail)

        startActivity(intent)
    }


}