package com.gamble846.bcaexternals076

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.*
class MyListAdapter(private val context: Activity, private val title: MutableList<String>, private val SubText1: MutableList<String>, private val SubText2: MutableList<String>, private val SubText3: MutableList<String>)
    : ArrayAdapter<String>(context, R.layout.row, title) {

//17bca076
    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.row, null, true)

        val titleText = rowView.findViewById(R.id.textView1) as TextView
        val SubText_1 = rowView.findViewById(R.id.textView2) as TextView
        val SubText_2 = rowView.findViewById(R.id.textView3) as TextView
        val SubText_3 = rowView.findViewById(R.id.textView4) as TextView

//17bca076
        titleText.text = "Name: " + title[position]
        SubText_1.text = "Customer No: " + SubText1[position]
        SubText_2.text = "NOU consumed: " + SubText2[position]
        SubText_3.text = "Price Per Unit: " + SubText3[position]

        return rowView
    }
}