package com.example.thesmileofluisawithkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ListUpdateCallback
import androidx.recyclerview.widget.RecyclerView
import com.example.thesmileofluisawithkotlin.adapters.ListBuyAdapter
import com.example.thesmileofluisawithkotlin.models.Mask
import com.example.thesmileofluisawithkotlin.utills.CustomItemClick
import java.util.ArrayList

class ListBuyActivity : AppCompatActivity() {

    private lateinit var listener : CustomItemClick

    private var listBuyAdapter: ListBuyAdapter? = null

    private var tvCustom: TextView? = null
    private var imgIcon: ImageView? = null

    private var price : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_buy)

        tvCustom = findViewById(R.id.tvCustom)
        imgIcon = findViewById(R.id.imgIcon)

        var rvListBuy : RecyclerView =  findViewById(R.id.rvListBuy)

        var btnFinish : Button = findViewById(R.id.btnFinish)
        val tvPriceTotal : TextView = findViewById(R.id.tvPriceTotal)

        rvListBuy.setHasFixedSize(true)
        val layoutManager = GridLayoutManager(this, 1)
        rvListBuy.layoutManager = layoutManager
        val maskBuy = intent.getSerializableExtra("maskC") as ArrayList<Mask>
        listBuyAdapter = ListBuyAdapter(maskBuy,this, object : CustomItemClick {
            override fun onItemClick(position: Int) {}
            override fun onLongItemClick(position: Int) {
                TODO("Not yet implemented")
            }
        })
        rvListBuy.adapter = listBuyAdapter

        for (mask in maskBuy) {
            // Log.i("precio", price.toString())
            price += mask.price
        }

        // Log.i("precio", price.toString())
        tvPriceTotal.text = price.toString() + "€"

        btnFinish.setOnClickListener {
            setCustomAlertDialog()
        }
    }

    private fun setCustomAlertDialog() {
        val builder = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.customalertdialog, null)
        tvCustom = findViewById(R.id.tvCustom)
        imgIcon = findViewById(R.id.imgIcon)
        builder.setView(view)
        val dialog = builder.create()
        dialog.show()
    }

}