package com.example.cryptox

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
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

        holder.coinImageID.setImageResource(currentItem.coinImageID)
        holder.shortNameUSDName.text = currentItem.shortNameUSDName
        holder.fullName.text = currentItem.fullName
        holder.priceString.text = currentItem.priceString
        holder.likedImageID.setImageResource(currentItem.likedImageID)

    }

    class MarketFragmentHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val coinImageID : ImageView = itemView.findViewById(R.id.imageView)
        val shortNameUSDName: TextView = itemView.findViewById(R.id.tv_name_coin)
        val fullName: TextView = itemView.findViewById(R.id.tv_name)
        val priceString: TextView = itemView.findViewById(R.id.tv_cost)
        val likedImageID: ImageButton = itemView.findViewById(R.id.ib_is_liked)
    }
}