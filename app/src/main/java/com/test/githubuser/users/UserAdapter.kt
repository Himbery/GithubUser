package com.test.githubuser.users

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.githubuser.databinding.ItemMainListBinding
import com.test.githubuser.repos.RepoActivity

class UserAdapter(): RecyclerView.Adapter<UserAdapter.ViewHolder>()  {
    var userArrayList: ArrayList<ItemUser> = ArrayList<ItemUser>()
    var repos_url: String = ""

    fun setUserData(listOfUsers : List<ItemUser>) {
        this.userArrayList = listOfUsers as ArrayList<ItemUser>
        this.userArrayList.addAll(listOfUsers)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMainListBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.userName.text = userArrayList[position].login

        repos_url = userArrayList[position].repos_url

        holder.itemView.setOnClickListener {
            val c = holder.itemView.context
            val intent = Intent(c, RepoActivity::class.java)
            intent.putExtra("repos_url", repos_url)
            c.startActivity(intent)
        }
    }
    override fun getItemCount(): Int {
        return userArrayList.size
    }
    fun addData(list: List<ItemUser>) {
        userArrayList.addAll(list)
    }

    class ViewHolder(val  binding: ItemMainListBinding)  : RecyclerView.ViewHolder(binding.root){}
}