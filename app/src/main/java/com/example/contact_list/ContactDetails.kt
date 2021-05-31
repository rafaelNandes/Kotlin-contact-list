package com.example.contact_list

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout

class ContactDetails: AppCompatActivity() {
    private var contact: Contact? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contact_details)
        initToolbar()
        getExtras()
        bindOnView()
    }

    private fun initToolbar(){
        val toolbar = findViewById<Toolbar>(R.id.details_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //show back button
    }

    //finish the activity after click the back button
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun getExtras(){
        contact = intent.getParcelableExtra(EXTRA_CONTACT)
    }

    private fun bindOnView(){
        findViewById<TextView>(R.id.details_name).text = contact?.name
        findViewById<TextView>(R.id.details_phone).text = contact?.phone
    }

    companion object{
        const val EXTRA_CONTACT: String = "EXTRA_CONTACT"
    }
}