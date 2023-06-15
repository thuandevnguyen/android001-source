package com.rxmobileteam.lecture9sample.extensions

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


fun <T : RecyclerView.Adapter<*>> RecyclerView.createAdapter(
    myAdapter: T?,
    layoutOrientation: Int = RecyclerView.VERTICAL,
    fixSized: Boolean = true,
    resLayout: Boolean = true
) {
    apply {
        layoutManager = LinearLayoutManager(context, layoutOrientation, resLayout)
        adapter = myAdapter
        setHasFixedSize(fixSized)
    }
}