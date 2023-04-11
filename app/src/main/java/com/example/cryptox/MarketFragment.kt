package com.example.cryptox

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
class MarketFragment : Fragment() {

    private lateinit var adapter: MarketFragmentAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var coinArrayList: ArrayList<Coin>

    lateinit var photoId: Array<Int>
    lateinit var nameCoinUSD: Array<String>
    lateinit var nameCoin: Array<String>
    lateinit var cost: Array<String>
    lateinit var isLikedId: Array<Int>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_market, container, false)
    }

    companion object {
        fun newInstance() = MarketFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_view_market)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = MarketFragmentAdapter(coinArrayList)
        recyclerView.adapter = adapter

    }
    private fun dataInitialize() {
        coinArrayList = arrayListOf()

        photoId = arrayOf(
            R.drawable.bitcoin,
            R.drawable.litecoin,
            R.drawable.etherium,
            R.drawable.ripple
        )

        nameCoinUSD = arrayOf(
            getString(R.string.btc),
            getString(R.string.ltc),
            getString(R.string.eth),
            getString(R.string.xrp)
            )
        nameCoin = arrayOf(
            getString(R.string.name_coin_bitcoin),
            getString(R.string.name_coin_litecoin),
            getString(R.string.name_coin_etherium),
            getString(R.string.name_coin_ripple)
            )
        cost = arrayOf(
            getString(R.string.cost_bitcoin),
            getString(R.string.cost_litecoin),
            getString(R.string.cost_etherium),
            getString(R.string.cost_ripple)
            )
        isLikedId = arrayOf(
            R.drawable.heart_liked,
            R.drawable.heart_no_liked,
            R.drawable.heart_no_liked,
            R.drawable.heart_no_liked
        )

        for(i in photoId.indices) {
            val coin = Coin(nameCoinUSD[i], nameCoin[i], cost[i], photoId[i], isLikedId[i])
            coinArrayList.add(coin)
        }
    }
}
