 package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.jar.Attributes

 var b = 0

 val goodsMap = hashMapOf<String, Int>()
 class MainActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spinner: Spinner = findViewById(R.id.spinner)
        val spinnerArrayList = arrayListOf<String>()
        spinnerArrayList.addAll(listOf("Guitar", "Drums", "Bayan"))
        val spinnerAdapter = android.widget.ArrayAdapter(
            this, android.R.layout.simple_spinner_item,
            spinnerArrayList
        )
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        spinner.adapter = spinnerAdapter
        goodsMap.put(spinnerArrayList.get(0), 30)
        goodsMap.put(spinnerArrayList.get(1), 10)
        goodsMap.put(spinnerArrayList.get(2), 20)


        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val goodsName = spinner.selectedItem.toString()
                val price = goodsMap[goodsName].toString().toDouble()
                val priceTotal: TextView = findViewById(R.id.priceTotal)
                priceTotal.text = ("" + b * price)
                val goodsImageView: ImageView = findViewById(R.id.goodsImageView)
                when (goodsName){
                    "Guitar" -> goodsImageView.setImageResource(R.drawable.guitar)
                    "Bayan" -> goodsImageView.setImageResource(R.drawable.bayan)
                    "Drums" -> goodsImageView.setImageResource(R.drawable.drums)
                }
            }

        }
    }

     fun increaseQuantity(view: View) {
         val welcomeMessage: TextView = findViewById(R.id.quantityText)
         b = Integer.valueOf(welcomeMessage.text.toString())
         if (b < 30){
             b += 1
         }
         val spinner: Spinner = findViewById(R.id.spinner)
         val goodsName = spinner.selectedItem.toString()
         val price = goodsMap[goodsName].toString().toDouble()
         val priceTotal: TextView = findViewById(R.id.priceTotal)
         priceTotal.text = ("" + b * price)
         welcomeMessage.text = b.toString()
     }

     fun decreaseQuantity(view: View) {
         val welcomeMessage: TextView = findViewById(R.id.quantityText)
         b = Integer.valueOf(welcomeMessage.text.toString())
         if (b > 0){
             b -= 1
         }
         val spinner: Spinner = findViewById(R.id.spinner)
         val goodsName = spinner.selectedItem.toString()
         val price = goodsMap[goodsName].toString().toDouble()
         val priceTotal: TextView = findViewById(R.id.priceTotal)
         priceTotal.text = ("" + b * price)
         welcomeMessage.text = b.toString()

     }

     fun addToCart(view: View) {
         val spinner: Spinner = findViewById(R.id.spinner)
         var userNameEditText: EditText = findViewById(R.id.nameEditText)
         var getName:TextView = findViewById(R.id.nameEditText)
         var getGoodsQuantity:TextView = findViewById(R.id.quantityText)
         var getPriceTotal:TextView = findViewById(R.id.priceTotal)
         Log.d("printusername" ,getGoodsQuantity.text.toString())
         Log.d("printusername" ,spinner.selectedItem.toString())
         Log.d("printusername" ,getPriceTotal.text.toString())
         var order = Order(getName.text.toString(),spinner.selectedItem.toString(),getGoodsQuantity.text.toString().toInt(),getPriceTotal.text.toString().toDouble())
         order.userName = userNameEditText.text.toString()
         Log.d("printusername" ,order.userName)
     }
 }

