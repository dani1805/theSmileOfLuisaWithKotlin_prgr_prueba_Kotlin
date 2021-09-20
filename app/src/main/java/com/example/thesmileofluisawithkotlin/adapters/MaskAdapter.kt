package com.example.thesmileofluisawithkotlin.adapters

import android.content.Context
import android.util.Log
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

class MaskAdapter(

    private var maskList: java.util.ArrayList<Mask?>,
    private var context: Context,
    private var listener: CustomItemClick,

    ): RecyclerView.Adapter<MaskAdapter.ViewHolder>() {

    fun MaskAdapter(
        maskList: ArrayList<Mask?>,
        context: Context,
        listener: CustomItemClick,
    ) {
        this.maskList = maskList;
        this.context = context;
        this.listener = listener;
    }

    override fun onBindViewHolder(holder: MaskAdapter.ViewHolder, position: Int) {
        val item = maskList.get(position);
        if (item != null) {
            holder.bind(item, context)
        };

        holder.btnAdd.setOnClickListener { listener.onItemClick(position) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MaskAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context);

        return ViewHolder(inflater.inflate(R.layout.holder_rv, parent, false));
    }

    override fun getItemCount(): Int {
        return maskList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var imgMask: ImageView = view.findViewById(R.id.imgMask)
        var tvNameMask: TextView = view.findViewById(R.id.tvNameMask)
        var tvModelMask: TextView = view.findViewById(R.id.tvModelMask)
        var tvPriceMask : TextView = view.findViewById(R.id.tvPriceMask)
        var btnAdd : Button = view.findViewById(R.id.btnAddBuy)

        fun bind(maskList: Mask, context: Context) {

            val drawable = maskList.img?.let { context.resources.getDrawable(it) }
            imgMask.setImageDrawable(drawable)
            tvNameMask.text = maskList.name
            tvModelMask.text = maskList.model
            tvPriceMask.text = maskList.price.toString()
        }

    }

    fun removeAt(position: Int) {
        maskList.removeAt(position);
        notifyItemRemoved(position);
    }
}
