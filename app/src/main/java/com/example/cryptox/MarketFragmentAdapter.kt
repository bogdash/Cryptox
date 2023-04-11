package com.example.cryptox

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MarketFragmentAdapter(private val coinList: ArrayList<Coin>) :
    RecyclerView.Adapter<MarketFragmentAdapter.MarketFragmentHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarketFragmentHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_coin, parent, false)
        return MarketFragmentHolder(itemView)
    }

    override fun getItemCount(): Int {
        return coinList.size
    }

    override fun onBindViewHolder(holder: MarketFragmentHolder, position: Int) {
        val currentItem = coinList[position]

        holder.photo.setImageResource(currentItem.photo)
        holder.nameCoinUSD.text = currentItem.nameCoinUSD
        holder.nameCoin.text = currentItem.nameCoin
        holder.cost.text = currentItem.cost
        holder.isLiked.setImageResource(currentItem.isLiked)
    }

    class MarketFragmentHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photo : ImageView = itemView.findViewById(R.id.imageView)
        val nameCoinUSD: TextView = itemView.findViewById(R.id.tv_name_coin)
        val nameCoin: TextView = itemView.findViewById(R.id.tv_name)
        val cost: TextView = itemView.findViewById(R.id.tv_cost)
        val isLiked: ImageView = itemView.findViewById(R.id.iv_is_liked)
    }
}