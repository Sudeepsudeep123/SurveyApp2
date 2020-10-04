package com.survey.project.application.features.shared.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.adapter_location.view.*

class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var crvLocation = view.crvLocation
    var text_home: TextView? = view.text_home
}