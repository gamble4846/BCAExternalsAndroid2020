package com.gamble846.bcaexternals076

class ElecBill{

    var Customer_No : String = ""
    var Customer_Name : String = ""
    var No_of_units_consumed : String = ""
    var Price_per_unit: String = ""

    constructor(Customer_No:String,Customer_Name:String,No_of_units_consumed:String,Price_per_unit:String){
        this.Customer_No = Customer_No
        this.Customer_Name = Customer_Name
        this.No_of_units_consumed = No_of_units_consumed
        this.Price_per_unit = Price_per_unit
    }

    constructor(){
    }

}