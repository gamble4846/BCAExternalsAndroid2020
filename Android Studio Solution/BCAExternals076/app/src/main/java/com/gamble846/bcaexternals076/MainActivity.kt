package com.gamble846.bcaexternals076

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
//17bca076
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed({
            var preference=getSharedPreferences("MyPref", Context.MODE_PRIVATE)
            var str=preference.getString("uname","Wrong")
            if(str.equals("Wrong")) {
                var intent = Intent(this, LogInActivity::class.java)
//17bca076
                startActivity(intent)
                finish()
            }
            else
            {
                var intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }
//17bca076
        },
                3000)
    }
}
