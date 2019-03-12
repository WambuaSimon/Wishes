package com.example.sharewishes.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

import com.example.sharewishes.R
import com.example.sharewishes.adapter.HomeAdapter
import com.example.sharewishes.models.HomeModel
import kotlinx.android.synthetic.main.include_recyclerview.*


class HomeFragment : Fragment() {
    lateinit var homeAdapter : HomeAdapter
    lateinit var homeData : MutableList<HomeModel>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerview.layoutManager = LinearLayoutManager(context)
        homeData = mutableListOf()
        homeAdapter= HomeAdapter(homeData)
        recyclerview.adapter=homeAdapter
        addDummyData()


    }

    private fun addDummyData() {
        val homeModel = HomeModel(HomeAdapter.TEXT)
        val homeModel1 = HomeModel(HomeAdapter.IMAGE)
        val homeModel2 = HomeModel(HomeAdapter.VIDEO)
        val homeModel3 = HomeModel(HomeAdapter.TEXT)
        val homeModel4 = HomeModel(HomeAdapter.TEXT)
        val homeModel5 = HomeModel(HomeAdapter.IMAGE)
        val homeModel6 = HomeModel(HomeAdapter.IMAGE)

        homeData.add(homeModel)
        homeData.add(homeModel1)
        homeData.add(homeModel2)
        homeData.add(homeModel3)
        homeData.add(homeModel4)
        homeData.add(homeModel5)
        homeData.add(homeModel6)
       homeAdapter.notifyDataSetChanged()
    }
}
