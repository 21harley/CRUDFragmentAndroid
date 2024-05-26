package com.example.crudfragmentandroid.dto.producto

import android.util.Log
import com.example.crudfragmentandroid.dto.labelproduct.LabelProduct

/*
*
Name=Nombre
Amount=Cantidad
Cost=Costo
Description=Descripcion
Like=Like
Worth=Valor
Brand=Marca
UrlImg
label=Etiqueta
* */
class Product(
     var id:String="",
     var name:String="",
     var amount:Int=0,
     var cout:Float=0.0F,
     var description:String="",
     var like:Boolean=false,
     var worth:Float=0.0F,
     var brand:String="",
     var urlImg:String="",
     var label: MutableList<LabelProduct> = mutableListOf()
){
    init {
        printData()
    }
    private fun printData(){
        Log.i("Data",
            "${this.id} ${this.name} ${this.amount} ${this.cout} ${this.description} ${this.like} ${this.worth} ${this.brand} ${this.urlImg} ${this.label}"
            )
    }
    // Methods to add and remove LabelProduct
    fun addLabel(labelProduct: LabelProduct) {
        this.label.add(labelProduct)
    }

    fun removeLabel(labelProduct: LabelProduct) {
        this.label.remove(labelProduct)
    }
}