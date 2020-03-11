package com.project.relawanmengabdi

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class VacancyListViewAdapter( private val listVacancy: ArrayList< Vacancy > ) : RecyclerView.Adapter<VacancyListViewAdapter.ListViewHolder>(), View.OnClickListener {

    inner class ListViewHolder( itemView: View ) : RecyclerView.ViewHolder( itemView ){
        var viewName: TextView = itemView.findViewById( R.id.vacancy_name_holder )
        var viewLoc: TextView = itemView.findViewById( R.id.vacancy_loc_holder )
        var viewDur: TextView = itemView.findViewById( R.id.vacancy_period_holder )
        var btnDetail: Button = itemView.findViewById( R.id.vacancy_detail_btn)
        var viewImage: ImageView = itemView.findViewById( R.id.event_photo )
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from( parent.context ).inflate( R.layout.item_row_vacancy, parent, false )
        return ListViewHolder( view )
    }

    override fun getItemCount(): Int {
        return listVacancy.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val vacancy = listVacancy[ position ]

//        Log.d("List Size", listVacancy.size.toString())

        holder.viewName.text = vacancy.name
        holder.viewLoc.text = vacancy.location
        holder.viewDur.text = vacancy.duration

        Glide.with( holder.itemView.context )
            .load( R.drawable.icon_redi )
            .into( holder.viewImage )

        holder.btnDetail.setOnClickListener {
            val moveToDetail = Intent( holder.itemView.context, VacancyDetail::class.java )
            moveToDetail.putExtra("vacancy_title", vacancy.name )
            holder.itemView.context.startActivity( moveToDetail )
        }
    }

    override fun onClick(v: View?) {

    }
}