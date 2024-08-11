package com.example.taekwondo_v2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.taekwondo_v2.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var signOutBtn: FloatingActionButton
    private lateinit var addStudentInfo: FloatingActionButton
    private lateinit var listView: ListView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_userdash)

        auth = FirebaseAuth.getInstance()
        listView = findViewById(R.id.listViewID)
        signOutBtn = findViewById(R.id.fab_signout)
        addStudentInfo = findViewById(R.id.fab_addStudentInfo)

        signOutBtn.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this, PhoneActivity::class.java))
        }

        addStudentInfo.setOnClickListener {
            startActivity(Intent(this, FormActivity::class.java))
        }
    }
}