package com.rsypj.restouts.ui.widget

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.rsypj.restouts.R
import com.rsypj.restouts.helper.loadCenterCropImage
import com.rsypj.restouts.helper.loadImage
import com.rsypj.restouts.model.Food
import kotlinx.android.synthetic.main.dialog_detail.view.*

/**
 * Created by dhadotid on 01:42 | 2020-05-13.
 * -> ✉ : yudhapurbajagad@gmail.com <-
 */

class FoodDetail(private val data: Food
) : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_detail, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.BottomDialogTheme)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.image_detail.loadCenterCropImage(data.photo)
        view.title_detail.text = data.name
        view.layout_food_description.text = data.description
        view.detail_close.setOnClickListener { dismiss() }
    }
}