package com.gamble846.bcaexternals076

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {
//17bca076
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnRegister.setOnClickListener{
            if(username_reg.text.toString().length>0 && password_reg.text.toString().length>0)
            {
                var user = User(username_reg.text.toString(),password_reg.text.toString())
                var db = DataBaseHandler(this)
//17bca076
                db.insertData(user)

                var intent = Intent(this, LogInActivity::class.java)
                startActivity(intent)
                finish()
            }
            else
            {
                Toast.makeText(this,"Please Enter Data!!", Toast.LENGTH_LONG).show()
//17bca076
            }
        }

        btnCancle_reg.setOnClickListener{
            var intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
//17bca076
}
