package ru.divizdev.kamazometer.presentation.history.adapter


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_order.view.*
import ru.divizdev.kamazometer.R
import ru.divizdev.kamazometer.presentation.history.Order


class HistoryAdapter(private val list: List<Order>) : RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): HistoryAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_order, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(viewHolder: HistoryAdapter.ViewHolder, index: Int) {
        viewHolder.setDate(list[index])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun setDate(order: Order) {
            itemView.textViewDateStart.text = order.date
            itemView.textViewFrom.text = order.from
            itemView.textViewTo.text = order.to
            itemView.textViewStatus.text = order.status
            itemView.textViewIdOrder.text = order.orderId
            itemView.textViewSum.text = order.sum
            if (order.status.compareTo("Выполнен") == 0){
                itemView.textViewStatus.setTextColor(itemView.resources.getColor(R.color.colorAccent))
            }else{
                itemView.textViewStatus.setTextColor(itemView.resources.getColor(R.color.colorPrimary))
            }


        }
    }


}