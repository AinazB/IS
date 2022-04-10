package com.ainaz.expertsystemlab1.ui.result

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ainaz.expertsystemlab1.R
import com.ainaz.expertsystemlab1.data.gis.GisEntity
import com.ainaz.expertsystemlab1.databinding.GisListItemBinding

class GisAdapter(
    val items: ArrayList<GisEntity> = arrayListOf()
) : RecyclerView.Adapter<GisAdapter.GisViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GisViewHolder {
        val binding = GisListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GisViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GisViewHolder, position: Int) =
        holder.bind(items[position])

    override fun getItemCount(): Int = items.size

    fun setGisList(gisList: List<GisEntity>) {
        items.clear()
        items.addAll(gisList)
    }


    inner class GisViewHolder(private val binding: GisListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(gisEntity: GisEntity) {
            binding.gisPrice.text = gisEntity.prise.toString()
            binding.gisTitle.text = gisEntity.name.toString()
            binding.gisSubtitle.text = gisEntity.producerCountry.toString()

        }
    }
}