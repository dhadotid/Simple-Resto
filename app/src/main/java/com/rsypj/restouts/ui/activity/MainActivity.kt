package com.rsypj.restouts.ui.activity


import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rsypj.restouts.helper.JSON_FILE
import com.rsypj.restouts.R
import com.rsypj.restouts.adapter.listener.OnItemSelected
import com.rsypj.restouts.adapter.recyclerview.FoodAdapter
import com.rsypj.restouts.helper.HeaderItemDecoration
import com.rsypj.restouts.helper.getJsonDataFromAsset
import com.rsypj.restouts.model.Food
import com.rsypj.restouts.model.ListItem
import com.rsypj.restouts.model.Menu
import com.rsypj.restouts.ui.BaseActivity
import com.rsypj.restouts.ui.activity.presenter.MainPresenter
import com.rsypj.restouts.ui.widget.FoodDetail
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by dhadotid on 04:09 | 2020-05-12.
 * -> ✉ : yudhapurbajagad@gmail.com <-
 */

class MainActivity: BaseActivity() {

    private lateinit var presenter: MainPresenter
    private lateinit var adapter: FoodAdapter

    private val foodListener = object : OnItemSelected<Food>{
        override fun onSelectedItem(item: Food) {
            FoodDetail(item).show(this@MainActivity?.supportFragmentManager, null)
        }
    }

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initializeDefaultValue() {
        super.initializeDefaultValue()
        presenter = MainPresenter()

        setJsonFile()

        presenter.getMenuList().observe(this, menuListObserver)
        presenter.getOnError().observe(this, onErrorObserver)

        fab_basket.setOnClickListener {
            startActivity(Intent(this, TransactionActivity::class.java))
        }
    }

    private fun setJsonFile(){
        getJsonDataFromAsset(
            applicationContext,
            JSON_FILE
        )?.let {
            presenter.requestFoodlist(it)
        }
    }

    private val menuListObserver = Observer<Pair<List<ListItem>, List<Menu>>> {
        setupAdapter(it.first, foodListener)
    }

    private val onErrorObserver = Observer<String>{
        showToast(it)
    }

    private fun setupAdapter(data: List<ListItem>, listener: OnItemSelected<Food>){
        adapter = FoodAdapter(data, listener)

        rcvMenu.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            rcvMenu.adapter = this@MainActivity.adapter
            addItemDecoration(HeaderItemDecoration(this, stickyListener))
        }
    }


    private val stickyListener = object : HeaderItemDecoration.StickyHeaderInterface{
        override fun getHeaderPositionForItem(itemPosition: Int): Int = (itemPosition downTo 0)
            .map { Pair(isHeader(it), it) }
            .firstOrNull { it.first }?.second ?: RecyclerView.NO_POSITION

        override fun getHeaderLayout(headerPosition: Int): Int = R.layout.layout_category

        override fun bindHeaderData(header: View?, headerPosition: Int) {
            if (headerPosition == RecyclerView.NO_POSITION) header?.layoutParams?.height = 0
            else{
                val menu = adapter.getItem(headerPosition) as Menu
                header?.layoutParams?.height = ViewGroup.LayoutParams.WRAP_CONTENT
                header?.findViewById<TextView>(R.id.category)?.text = menu.category
                header?.findViewById<TextView>(R.id.total_data_category)?.text = menu.data.size.toString()
            }
        }

        override fun isHeader(itemPosition: Int): Boolean {
            return adapter.getItemViewType(itemPosition) == ListItem.TYPE_HEADER
        }
    }
}