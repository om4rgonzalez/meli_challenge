package net.omar.gonzalez.meli.challenge.ui.search

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import net.omar.gonzalez.meli.challenge.data.model.History
import net.omar.gonzalez.meli.challenge.databinding.ItemHistoryBinding

class HistoryAdapter(
    var historyList: List<History>
) : RecyclerView.Adapter<HistoryAdapter.Holder>() {

    private var onUpperButtonClick: ((History) -> Unit)? = null
    private var onItemClick: ((History) -> Unit)? = null

    inner class Holder(binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val text = binding.text
        val upperButton = binding.imageArrow
        val clockButton = binding.orderTime
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            ItemHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = historyList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val history = historyList[position]
        holder.text.text = history.searchKey

        holder.clockButton.setOnClickListener {
            onItemClick?.invoke(history)
        }

        holder.text.setOnClickListener {
            onItemClick?.invoke(history)
        }

        holder.upperButton.setOnClickListener {
            onUpperButtonClick?.invoke(history)
        }
    }

    fun refreshView(historyList: List<History>) {
        this.historyList = historyList
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(onItemClick: ((History) -> Unit)? = null) {
        this.onItemClick = onItemClick
    }

    fun setupOnUpperButtonClickListener(onUpperButtonClick: ((History) -> Unit)? = null) {
        this.onUpperButtonClick = onUpperButtonClick
    }
}