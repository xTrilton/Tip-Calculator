package com.raywenderlich.android.tipcalculatortdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity(){

    private lateinit var costEditText: EditText
    private lateinit var calculateButton: Button
    private lateinit var  totalCharge: TextView
    var tip = 0.0
    var bill= 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        costEditText = findViewById(R.id.costEditText)
        calculateButton = findViewById(R.id.calculateExpense)
        totalCharge= findViewById(R.id.tipTextView)

    }



    fun calculateExpense(view: View) {
        val rBar = findViewById<RatingBar>(R.id.rBar)
        if (rBar != null) {

            tip= rBar.rating.toDouble()
        }
        else{
            Toast.makeText(applicationContext, "Please rate the service", Toast.LENGTH_SHORT).show()
        }

         bill = costEditText.text.toString().toDouble()

        val tipAmount = ((tip * bill)/100)*10

        val  totalAmount= tipAmount + bill
        totalCharge.setText("Your total charge is:" +" $"+ totalAmount)

    }


}


