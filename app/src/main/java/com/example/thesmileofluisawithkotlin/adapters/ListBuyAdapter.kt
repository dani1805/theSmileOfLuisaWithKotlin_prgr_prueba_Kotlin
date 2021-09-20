package com.example.thesmileofluisawithkotlin.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.thesmileofluisawithkotlin.R
import com.example.thesmileofluisawithkotlin.models.Mask
import com.example.thesmileofluisawithkotlin.utills.CustomItemClick

class ListBuyAdapter(

    private var listBuy: java.util.ArrayList<Mask>,
    private var context: Context,
    private var listener: CustomItemClick,

    ): RecyclerView.Adapter<ListBuyAdapter.ViewHolder>() {

    fun ListBuyAdapter(
        listBuy: java.util.ArrayList<Mask>,
        context: Context,
        listener: CustomItemClick,
    ) {
        this.listBuy = listBuy;
        this.context = context;
        this.listener = listener;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listBuy.get(position);
        if (item != null) {
            holder.bind(item, context)
        };

         }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListBuyAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context);

        return ViewHolder(inflater.inflate(R.layout.holder_buy, parent, false));
    }

    override fun getItemCount(): Int {
        return listBuy.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var imgCar: ImageView = view.findViewById(R.id.imgCar)
        var tvCarName: TextView = view.findViewById(R.id.tvCarName)
        var tvCarModel: TextView = view.findViewById(R.id.tvCarModel)
        var tvCarPrice : TextView = view.findViewById(R.id.tvCarPrice)

        fun bind(listBuy: Mask, context: Context) {

            val drawable = listBuy.img?.let { context.resources.getDrawable(it) }
            imgCar.setImageDrawable(drawable)
            tvCarName.text = listBuy.name
            tvCarModel.text = listBuy.model
            tvCarPrice.text = listBuy.price.toString()
        }

    }

    fun removeAt(position: Int) {
        listBuy.removeAt(position);
        notifyItemRemoved(position);
    }
}


