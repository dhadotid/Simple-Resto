package com.rsypj.restouts.ui.activity

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rsypj.restouts.R
import com.rsypj.restouts.adapter.listener.OnItemSelected
import com.rsypj.restouts.adapter.recyclerview.FoodAdapter
import com.rsypj.restouts.helper.HeaderItemDecoration
import com.rsypj.restouts.helper.JSON_TRANSACTION
import com.rsypj.restouts.helper.getJsonDataFromAsset
import com.rsypj.restouts.model.Food
import com.rsypj.restouts.model.ListItem
import com.rsypj.restouts.model.Menu
import com.rsypj.restouts.ui.BaseActivity
import com.rsypj.restouts.ui.activity.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_transaction.*

/**
 * Created by dhadotid on 19.36 | 07/08/20.
 * -> ✉ : yudhapurbajagad@gmail.com <-
 */

class TransactionActivity: BaseActivity() {

    private lateinit var presenter: MainPresenter
    private lateinit var adapter: FoodAdapter

    private val foodListener = object : OnItemSelected<Food>{
        override fun onSelectedItem(item: Food) {

        }
    }

    override fun getLayoutId(): Int = R.layout.activity_transaction

    override fun initializeDefaultValue() {
        super.initializeDefaultValue()
        presenter = MainPresenter()

        setJsonFile()

        presenter.getMenuList().observe(this, menuListObserver)
        presenter.getOnError().observe(this, onErrorObserver)
    }

    private fun setJsonFile(){
        getJsonDataFromAsset(applicationContext,
            JSON_TRANSACTION
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

        transaction_list.apply {
            layoutManager = LinearLayoutManager(this@TransactionActivity)
            transaction_list.adapter = this@TransactionActivity.adapter
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