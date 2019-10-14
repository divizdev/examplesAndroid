package ru.divizdev.kamazometer.presentation.listTruck.adapter


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_truck.view.*
import ru.divizdev.kamazometer.R
import ru.divizdev.kamazometer.presentation.entities.Truck


class ListTruckAdapter(private val list: List<Truck>): RecyclerView.Adapter<ListTruckAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ListTruckAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_truck, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(viewHolder: ListTruckAdapter.ViewHolder, index: Int) {
        viewHolder.setDate(list[index])
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        fun setDate(truck: Truck){

            itemView.textViewStatus.text = truck.status
            itemView.textViewBrand.text = truck.brand
            itemView.textViewLoadType.text = truck.loadType
            itemView.textViewNumber.text = truck.number
            itemView.textViewTonnage.text = truck.tonnage
            itemView.textViewType.text = truck.type

        }
    }


}