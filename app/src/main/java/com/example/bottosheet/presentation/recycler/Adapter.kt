package com.example.bottosheet.presentation.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bottosheet.R
import com.example.bottosheet.databinding.ItemViewBinding

class Adapter : RecyclerView.Adapter<Adapter.NameHolder>() {
    private var items: List<String> = mutableListOf()
    private var itemClickListener: ((String) -> Unit)? = null

    class NameHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemViewBinding.bind(view)
        companion object {
            fun from( parent: ViewGroup) : NameHolder {
                return NameHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false))
            }
        }

        fun bind(name: String) = with(binding) {
            tv.text = name
            itemView.setOnClickListener {
                itemClickListener?.invoke(tv.text.toString())
            }
        }

        private var itemClickListener: ((String) -> Unit)? = null

        fun setItemClickListener(listener: ((String) -> Unit)) {
            itemClickListener = listener
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameHolder {
        val holder = NameHolder.from(parent)

        holder.setItemClickListener { string ->
            itemClickListener?.invoke(string)
        }
        return holder
    }

    override fun onBindViewHolder(holder: NameHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addStrings(array: List<String>) {
        items = array
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(listener: (String) -> Unit) {
        itemClickListener = listener
    }
}