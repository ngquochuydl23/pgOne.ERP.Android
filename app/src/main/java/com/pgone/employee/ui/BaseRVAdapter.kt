package com.pgone.employee.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T : RecyclerView.ViewHolder?> : RecyclerView.Adapter<T>() {

  lateinit var context: Context
  val EmptyList: Int = 0


  open fun getView(parent: ViewGroup, viewType: Int, layout: Int): View {
    context = parent.context
    return LayoutInflater.from(context).inflate(layout, parent, false)
  }

  fun <Model> getSizeList(list: ArrayList<Model>?): Int {
    if (!list.isNullOrEmpty())
      return list.size
    return EmptyList
  }

  fun <Model> getSizeList(list: MutableList<Model>?): Int {
    if (!list.isNullOrEmpty())
      return list.size
    return EmptyList
  }

  fun <Model> removeItemAt(list: ArrayList<Model>?, position: Int) {
    list?.removeAt(position)
    notifyDataSetChanged()
  }

  fun <Model> addNewItem(list: ArrayList<Model>?, newItem: Model) {
    list?.add(newItem)
    notifyDataSetChanged()
  }

  abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){ }
}