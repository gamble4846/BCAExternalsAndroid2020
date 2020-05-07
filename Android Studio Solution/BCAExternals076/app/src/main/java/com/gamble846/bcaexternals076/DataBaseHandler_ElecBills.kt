//17bca076
package com.gamble846.bcaexternals076

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

//17bca076
val DATABASE_NAME2 ="MyDB2"
val TABLE_NAME2="ElecBills"
val COL_Customer_No= "Customer_No"
val COL_Customer_Name = "Customer_Name"
val COL_No_of_units_consumed = "No_of_units_consumed"
val COL_Price_per_unit = "Price_per_unit"

class DataBaseHandler_ElecBills(var context: Context) : SQLiteOpenHelper(context,DATABASE_NAME2,null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
//17bca076
        val createTable = "CREATE TABLE " + TABLE_NAME2 + " (" +
                COL_Customer_No + " VARCHAR(256)," +
                COL_Customer_Name + " VARCHAR(256)," +
                COL_No_of_units_consumed + " VARCHAR(256)," +
                COL_Price_per_unit + " VARCHAR(256))"

        db?.execSQL(createTable)

    }
//17bca076
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insertData(elebill: ElecBill) {
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_Customer_No, elebill.Customer_No)
        cv.put(COL_Customer_Name, elebill.Customer_Name)
//17bca076
        cv.put(COL_No_of_units_consumed, elebill.No_of_units_consumed)
        cv.put(COL_Price_per_unit, elebill.Price_per_unit)

        var result = db.insert(TABLE_NAME2, null, cv)
        if (result == -1.toLong())
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }
//17bca076
    fun readData(): MutableList<ElecBill> {
        var list: MutableList<ElecBill> = ArrayList()

        val db = this.readableDatabase
        val query = "Select * from " + TABLE_NAME2
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            do {
                var ElecBillsVar = ElecBill()
//17bca076
                ElecBillsVar.Customer_No = result.getString(result.getColumnIndex(COL_Customer_No))
                ElecBillsVar.Customer_Name =
                    result.getString(result.getColumnIndex(COL_Customer_Name))
                ElecBillsVar.No_of_units_consumed =
                    result.getString(result.getColumnIndex(COL_No_of_units_consumed))
                ElecBillsVar.Price_per_unit =
                    result.getString(result.getColumnIndex(COL_Price_per_unit))
                list.add(ElecBillsVar)
            } while (result.moveToNext())
//17bca076
        }

        result.close()
        db.close()
        return list
    }
}