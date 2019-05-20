package com.wtm.kotlin.development.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_user.view.placeholder_age
import kotlinx.android.synthetic.main.item_user.view.placeholder_name

class UserAdapter : RecyclerView.Adapter<UserViewHolder>() {
    private val list = mutableListOf<User>()

    fun setData(items: List<User>) {
        list.clear()
        list.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view);
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(viewHolder: UserViewHolder, position: Int) {
        viewHolder.bindData(list[position])
    }

}

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name by lazy { itemView.placeholder_name }
    val age by lazy { itemView.placeholder_age }
    fun bindData(user: User) {
        name.text = user.name
        age.text = user.age.toString()
    }

}