package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val getName = intent.getStringExtra("getName")
        val spinnerValue = intent.getStringExtra("spinnerValue")
        val getGoodsQuantity = intent.getIntExtra("getGoodsQuantity", 0).toString()
        val getPriceTotal = intent.getDoubleExtra("getPriceTotal", 0.0)
        var priceIntent = intent.getDoubleExtra("getPrice", 0.0)
        var nameText: TextView = findViewById(R.id.nameOrder)
        var goodsName: TextView = findViewById(R.id.goodsName)
        var quantityText: TextView = findViewById(R.id.quantityText)
        var priceTotal: TextView = findViewById(R.id.priceTotal)
        var price: TextView = findViewById(R.id.price)
        if (getName!=null&&getPriceTotal!=0.0) {
            nameText.text = "Customer name: $getName"
            goodsName.text = "Goods name: $spinnerValue"
            quantityText.text = "Quantity: $getGoodsQuantity"
            priceTotal.text = "Price total: $getPriceTotal"
            price.text = "Price: $priceIntent"
        }
    }

    fun submitOrder(view: View) {
        val adresses = arrayListOf<String>()
        adresses.add("default.com")
        val mIntent = Intent(Intent.ACTION_SEND)
        mIntent.type = "text/plain"
        var nameTextView: TextView = findViewById(R.id.nameOrder)
        var nameText = nameTextView.text
        var goodsNameView: TextView = findViewById(R.id.goodsName)
        var goodsName = goodsNameView.text
        var quantityTextView: TextView = findViewById(R.id.quantityText)
        var quantityText = quantityTextView.text
        var priceTotalView: TextView = findViewById(R.id.priceTotal)
        var priceTotal = priceTotalView.text
        var priceView: TextView = findViewById(R.id.price)
        var price = priceView.text
        var email = "$nameText\n$goodsName\n$quantityText\n$priceTotal\n$price"
        mIntent.setData(Uri.parse("mailto:"))
        mIntent.type = "text/plain"
        mIntent.putExtra(Intent.EXTRA_EMAIL,adresses)
        mIntent.putExtra(Intent.EXTRA_SUBJECT, "order")
        mIntent.putExtra(Intent.EXTRA_TEXT, email)

        startActivity(Intent.createChooser(mIntent, "Send Email"))
    }
}
