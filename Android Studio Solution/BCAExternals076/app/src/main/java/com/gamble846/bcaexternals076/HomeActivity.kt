package com.gamble846.bcaexternals076

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_register.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var preference=getSharedPreferences("MyPref", Context.MODE_PRIVATE)
        var editor=preference.edit()

        var str=preference.getString("uname","Wrong")
        usernametext.text="Welcome :  $str"

        insertElectricityBilldetail.setOnClickListener{
            var intent = Intent(this, insertElectricityBill::class.java)
            startActivity(intent)
        }

        DisplayElectricityBilldetail.setOnClickListener{
            var intent = Intent(this, DisplayElectricityBill::class.java)
            startActivity(intent)
        }

        LogOut.setOnClickListener{
            editor.putString("uname","Wrong");
            editor.commit()

            var intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
