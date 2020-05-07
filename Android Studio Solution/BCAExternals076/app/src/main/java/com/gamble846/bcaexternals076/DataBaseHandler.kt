//17bca076
package com.gamble846.bcaexternals076

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DATABASE_NAME ="MyDB"
val TABLE_NAME="Users"
//17bca076
val COL_USERNAME = "username"
val COL_PASSWORD = "password"
val COL_ID = "id"

class DataBaseHandler(var context: Context) : SQLiteOpenHelper(context,DATABASE_NAME,null,1) {
    override fun onCreate(db: SQLiteDatabase?) {

        val createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
//17bca076
                COL_USERNAME + " VARCHAR(256)," +
                COL_PASSWORD + " VARCHAR(256))"

        db?.execSQL(createTable)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//17bca076
    }

    fun insertData(user: User) {
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_USERNAME, user.username)
        cv.put(COL_PASSWORD, user.password)
        var result = db.insert(TABLE_NAME, null, cv)
        if (result == -1.toLong())
//17bca076
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }

    fun readData() : MutableList<User>{
        var list : MutableList<User> = ArrayList()

        val db = this.readableDatabase
//17bca076
        val query = "Select * from " + TABLE_NAME
        val result = db.rawQuery(query,null)
        if(result.moveToFirst()){
            do {
                var user = User()
                user.id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                user.username = result.getString(result.getColumnIndex(COL_USERNAME))
                user.password = result.getString(result.getColumnIndex(COL_PASSWORD))
                list.add(user)
//17bca076
            }while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
}
//17bca076