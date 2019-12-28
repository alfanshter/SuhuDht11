package com.alfanshter.suhudht11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var dref: DatabaseReference

    var nilaikelembapan = 0f
    var nilaisuhu = 0f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dref = FirebaseDatabase.getInstance().reference
        dref.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
            nilaisuhu = p0.child("Temperature/Nilai Suhu :").value!!.toString().toFloat()
                nilaikelembapan = p0.child("Temperature/Nilai Kelembapan :").value!!.toString().toFloat()
                suhu?.text = "${nilaisuhu}"
                kelembapan?.text = "${nilaikelembapan}"

            }
        })
    }
}
