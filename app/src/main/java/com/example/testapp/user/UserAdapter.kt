package com.example.testapp.user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testapp.data.model.UserData
import com.example.testapp.databinding.ItemUserBinding

class UserAdapter (val list: MutableList<UserData>) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])

    }

    override fun getItemCount() = list.size

    class ViewHolder(val itemBinding: ItemUserBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(item: UserData) {

            with(itemBinding) {

                tvTitle.text = item.first_name + " " + item.last_name
                tvEmail.text = item.email
                Glide.with(itemView.context).load(item.avatar).into(avatar)
            }

        }
    }
}