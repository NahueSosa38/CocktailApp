package com.example.cocktailapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class BebidaAdapter(private val bebidas: List<Drink>) : RecyclerView.Adapter<BebidaAdapter.BebidaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BebidaViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.itembebida, parent, false)
        return BebidaViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BebidaViewHolder, position: Int) {
        val bebida = bebidas[position]
        holder.nombreBebida.text = bebida.strDrink
        Glide.with(holder.itemView.context)
            .load(bebida.strDrinkThumb)
            .into(holder.imageBebida)
    }

    override fun getItemCount() = bebidas.size

    class BebidaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreBebida: TextView = itemView.findViewById(R.id.nombrebebida)
        val imageBebida: ImageView = itemView.findViewById(R.id.imagebebida)
    }
}