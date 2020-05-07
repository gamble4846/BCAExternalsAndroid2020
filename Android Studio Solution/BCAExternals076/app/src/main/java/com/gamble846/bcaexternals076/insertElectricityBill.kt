package com.gamble846.bcaexternals076

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_insert_electricity_bill.*

class insertElectricityBill : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_electricity_bill)

        insert_act_btn.setOnClickListener{

            if(Customer_No.text.toString().length>0 &&
                Customer_Name.text.toString().length>0 &&
                No_of_units_consumed.text.toString().length>0 &&
                Price_per_unit.text.toString().length>0)
            {
                var elecbill = ElecBill(
                    Customer_No.text.toString(),
                    Customer_Name.text.toString(),
                    No_of_units_consumed.text.toString(),
                    Price_per_unit.text.toString()
                )
                var db = DataBaseHandler_ElecBills(this)
                db.insertData(elecbill)

                var intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }
            else
            {
                Toast.makeText(this,"Please Enter Data!!", Toast.LENGTH_LONG).show()
            }
        }

        cancle_NA_btn.setOnClickListener{
            var intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}
