package com.survey.project.application.features.shared.adapter

import android.content.Context
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.survey.project.application.R
import com.survey.project.application.features.shared.listener.OnLocationClickListener
import com.survey.project.application.features.shared.model.AreaModel
import com.survey.project.application.features.shared.viewholder.HomeViewHolder
import com.survey.project.application.utils.util.PreferenceUtils

class HomeAdapter(
    var context: Context?,
    var areaList: MutableList<AreaModel>,
    var listener: OnLocationClickListener
) :
    RecyclerView.Adapter<HomeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view: View =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter_location, parent, false)
        return HomeViewHolder(view)
    }

    override fun getItemCount(): Int = areaList.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val area = areaList[position]
        holder.text_home?.text =
            "${area.area?.provence}  ${area.area?.zone}  ${area.area?.district}"

        if (PreferenceUtils.getLocation(context) ==  "${area.area?.provence}  ${area.area?.zone}  ${area.area?.district}"){
            holder.crvLocation?.background =
                context?.resources?.getDrawable(R.drawable.cardview_with_green_border)
        }else{
            holder.crvLocation?.background = context?.resources?.getDrawable(R.drawable.rll_bg)
        }

        holder.crvLocation?.setOnClickListener {

            listener.onLocationClick(holder.adapterPosition)
        }
    }
}