package com.example.crudfragmentandroid.dto.labelproduct

import android.util.Log

class LabelProduct(
    private var name:String=""
) {
    init {
        printData()
    }
    private fun printData(){
        Log.i("Data",this.name)
    }
}