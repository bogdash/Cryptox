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
        val bitcoin = Coin(getString(R.string.cost_bitcoin), getString(R.string.name_coin_bitcoin), getString(R.string.btc), R.drawable.bitcoin, true)
        val litecoin = Coin(getString(R.string.cost_litecoin), getString(R.string.name_coin_litecoin), getString(R.string.ltc), R.drawable.litecoin, false)
        val etherium = Coin(getString(R.string.cost_etherium), getString(R.string.name_coin_etherium), getString(R.string.eth), R.drawable.etherium, false)
        val ripple = Coin(getString(R.string.cost_ripple), getString(R.string.name_coin_ripple), getString(R.string.xrp), R.drawable.ripple, false)
        val bitcoin_1 = Coin(getString(R.string.cost_bitcoin), getString(R.string.name_coin_bitcoin), getString(R.string.btc), R.drawable.bitcoin, true)
        val litecoin_1 = Coin(getString(R.string.cost_litecoin), getString(R.string.name_coin_litecoin), getString(R.string.ltc), R.drawable.litecoin, false)
        val etherium_1 = Coin(getString(R.string.cost_etherium), getString(R.string.name_coin_etherium), getString(R.string.eth), R.drawable.etherium, false)
        val ripple_1 = Coin(getString(R.string.cost_ripple), getString(R.string.name_coin_ripple), getString(R.string.xrp), R.drawable.ripple, false)

        coinArrayList = arrayListOf(bitcoin, litecoin, etherium, ripple, bitcoin_1, litecoin_1, etherium_1, ripple_1)
    }
}
