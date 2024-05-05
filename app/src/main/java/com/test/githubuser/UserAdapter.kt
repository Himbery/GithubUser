package com.test.githubuser

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.githubuser.databinding.ItemMainListBinding

class UserAdapter(): RecyclerView.Adapter<UserAdapter.ViewHolder>()  {
    var userArrayList: ArrayList<ItemUser> = ArrayList<ItemUser>()

    fun setUserData(listOfUsers : List<ItemUser>) {
        this.userArrayList = listOfUsers as ArrayList<ItemUser>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        return ViewHolder(
            ItemMainListBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        holder.binding.userName.text = userArrayList[position].login
    }

    override fun getItemCount(): Int {
        return userArrayList.size
    }

    class ViewHolder(val  binding: ItemMainListBinding)  : RecyclerView.ViewHolder(binding.root){}
}