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
    private var id:String="",
    private var name:String="",
    private var amount:Int=0,
    private var cout:Float=0.0F,
    private var description:String="",
    private var like:Boolean=false,
    private var worth:Float=0.0F,
    private var brand:String="",
    private var urlImg:String="",
    private var label: MutableList<LabelProduct> = mutableListOf()
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