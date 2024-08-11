package com.example.taekwondo_v2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class FormActivity : AppCompatActivity() {

    private lateinit var submitBtn: Button
    private lateinit var nameET: EditText
    private lateinit var emailET: EditText
    private lateinit var fatherET: EditText
    private lateinit var motherET: EditText
    private lateinit var professionET: EditText
    private lateinit var genderET: EditText
    private lateinit var ageET: EditText
    private lateinit var religionET: EditText
    private lateinit var bloodGroupET: EditText
    private lateinit var contactET: EditText
    private lateinit var heightET: EditText
    private lateinit var weightET: EditText
    private lateinit var presentAddressET: EditText
    private lateinit var permanentAddressET: EditText
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        databaseReference = FirebaseDatabase.getInstance().getReference()

        nameET = findViewById(R.id.nameET)
        emailET = findViewById(R.id.emailET)
        fatherET = findViewById(R.id.fatherET)
        motherET = findViewById(R.id.motherET)
        professionET = findViewById(R.id.professionET)
        genderET = findViewById(R.id.genderET)
        ageET = findViewById(R.id.ageET)
        religionET = findViewById(R.id.religionET)
        bloodGroupET = findViewById(R.id.bloodgroupET)
        contactET = findViewById(R.id.contactnoET)
        heightET = findViewById(R.id.heightET)
        weightET = findViewById(R.id.weightET)
        presentAddressET = findViewById(R.id.presentaddressET)
        permanentAddressET = findViewById(R.id.permanentaddressET)

        submitBtn = findViewById(R.id.submitButton)

        submitBtn.setOnClickListener {
            saveData()
            Toast.makeText(this, "Data Added Successfully", Toast.LENGTH_LONG).show()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun saveData() {

        val key = databaseReference.push().key

        val name = nameET.text.toString().trim()
        val email = emailET.text.toString().trim()
        val father = fatherET.text.toString().trim()
        val mother = motherET.text.toString().trim()
        val profession = professionET.text.toString().trim()
        val gender = genderET.text.toString().trim()
        val age = ageET.text.toString().trim()
        val religion = religionET.text.toString().trim()
        val bloodGroup = bloodGroupET.text.toString().trim()
        val contact = contactET.text.toString().trim()
        val height = heightET.text.toString().trim()
        val weight = weightET.text.toString().trim()
        val presentAddress = presentAddressET.text.toString().trim()
        val permanentAddress = permanentAddressET.text.toString().trim()
        val activeStatus = "Pending"
        val membershipFee = "TBA"
        val batch = "TBA"
        val beltLevel = "TBA"

        val student = FormActivityToFirebase(name, email, father, mother, profession, gender,
            age, religion, bloodGroup, contact, height, weight,
            presentAddress, permanentAddress, activeStatus,
            membershipFee, batch, beltLevel)

        if (key != null) {
            databaseReference.child(key).setValue(student)
        }
    }
}