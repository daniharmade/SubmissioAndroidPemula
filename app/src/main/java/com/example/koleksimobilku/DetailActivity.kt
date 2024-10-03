package com.example.koleksimobilku

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    private lateinit var detailPhoto: ImageView
    private lateinit var detailPrice: TextView
    private lateinit var detailName: TextView
    private lateinit var detailDescription : TextView
    private lateinit var detailFuel : TextView
    private lateinit var detailCapacity : TextView
    private lateinit var detailYearsCondition : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.title = "Detail Mobil"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        detailPhoto = findViewById(R.id.img_photo_detail)
        detailPrice = findViewById(R.id.tv_price_detail)
        detailName = findViewById(R.id.tv_name_detail)
        detailDescription = findViewById(R.id.tv_description_detail)
        detailFuel = findViewById(R.id.tv_fuel_detail)
        detailCapacity = findViewById(R.id.tv_capacity_detail)
        detailYearsCondition = findViewById(R.id.tv_year_condition_detail)

        val dataCar = intent.getParcelableExtra<Car>("key_car")

        dataCar?.let{
            detailPhoto.setImageResource(it.photo)
            detailPrice.text = it.price
            detailName.text = it.name
            detailDescription.text = it.description
            detailFuel.text = it.fuel
            detailCapacity.text = it.capacity
            detailYearsCondition.text = it.yearscondition
        }

        val btnOrder: Button = findViewById(R.id.btn_order)

        btnOrder.setOnClickListener {
            val instagramUri = Uri.parse("https://www.instagram.com/dani.harmade")
            val intent = Intent(Intent.ACTION_VIEW, instagramUri)

            intent.setPackage("com.instagram.android")
            try {
                startActivity(intent)
            } catch (e: Exception) {
                intent.setPackage(null)
                startActivity(intent)
            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.share, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_share -> {
                sharingData()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun sharingData(){
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        val shareText = "Bagikan Ke teman Anda"
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareText)
        startActivity(Intent.createChooser(shareIntent, "Share Via"))
    }
}