package com.gamble846.bcaexternals076

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_log_in.*

//17bca076
class LogInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        registerbtn.setOnClickListener{
            var intent= Intent(this,Register::class.java)
            startActivity(intent)
//17bca076
        }

        fun Checking(username_check : String,password_check : String) : Boolean {
            var db = DataBaseHandler(this)
            var data = db.readData()
            var m = 0
            for (i in 0..(data.size - 1)) {
                if(data.get(i).username.toString() == username_check && data.get(i).password.toString() == password_check)
                    m++;
//17bca076
            }
            return m>0
        }

        loginbtn.setOnClickListener {
            if(!username.text.toString().equals("") && !password.text.toString().equals(""))
            {
                if(Checking(username.text.toString(),password.text.toString()))
                {
//17bca076
                    Toast.makeText(this,"Login Successfull!!", Toast.LENGTH_LONG).show()
                    var preference=getSharedPreferences("MyPref", Context.MODE_PRIVATE)
                    var editor=preference.edit()
                    editor.putString("uname",username.text.toString());
                    editor.commit()
                    var intent= Intent(this,HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                }
//17bca076
                else
                {
                    Toast.makeText(this,"Invalid Username/Password", Toast.LENGTH_LONG).show()
                }
            }
            else
            {
                Toast.makeText(this,"Please Enter Data!!", Toast.LENGTH_LONG).show()
            }
//17bca076
        }
    }
}
