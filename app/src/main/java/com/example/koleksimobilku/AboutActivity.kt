package com.example.koleksimobilku

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_me)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        supportActionBar?.title = "About Me"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val imgLinkedIn: ImageView = findViewById(R.id.img_linkedin)
        val imgYoutube: ImageView = findViewById(R.id.img_youtube)
        val imgInstagram: ImageView = findViewById(R.id.img_instagram)
        val btnContact = findViewById<Button>(R.id.btn_contact)

        imgLinkedIn.setOnClickListener {
            openUrl("https://www.linkedin.com/in/daniharmade/")
        }

        imgYoutube.setOnClickListener {
            openUrl("https://www.youtube.com/@daniharmade")
        }

        imgInstagram.setOnClickListener {
            openUrl("https://www.instagram.com/dani.harmade/")
        }

        btnContact.setOnClickListener {
            val email = "harmadedani@gmail.com"
            val subject = "Subject Here"
            val body = "Body of the email"

            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:$email")
                putExtra(Intent.EXTRA_SUBJECT, subject)
                putExtra(Intent.EXTRA_TEXT, body)
            }

            try {
                startActivity(emailIntent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(this, "No email app found, opening in browser...", Toast.LENGTH_SHORT).show()
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://mail.google.com/mail/?view=cm&fs=1&to=$email&su=$subject&body=$body")))
            }
        }
    }

    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
