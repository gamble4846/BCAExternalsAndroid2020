package com.gamble846.bcaexternals076

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_display_electricity_bill.*
import kotlinx.android.synthetic.main.activity_register.*

class DisplayElectricityBill : AppCompatActivity() {
//17bca076
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_electricity_bill)
        var db = DataBaseHandler_ElecBills(this)
        var data = db.readData()

        val Customer_No: MutableList<String> = ArrayList()
        val Customer_Name: MutableList<String> = ArrayList()
        val No_of_units_consumed: MutableList<String> = ArrayList()
//17bca076
        val Price_per_unit: MutableList<String> = ArrayList()

        for (i in 0..(data.size - 1)) {
            Customer_No.add(data.get(i).Customer_No.toString())
            Customer_Name.add(data.get(i).Customer_Name.toString())
            No_of_units_consumed.add(data.get(i).No_of_units_consumed.toString())
            Price_per_unit.add(data.get(i).Price_per_unit.toString())
        }

//17bca076
        val myListAdapter = MyListAdapter(this,Customer_Name,Customer_No,No_of_units_consumed,Price_per_unit)
        listView.adapter = myListAdapter
    }
}
