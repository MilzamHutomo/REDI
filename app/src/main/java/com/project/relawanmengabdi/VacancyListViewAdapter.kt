package com.project.relawanmengabdi

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VacancyListViewAdapter( private val listVacancy: ArrayList< Vacancy > ) : RecyclerView.Adapter<VacancyListViewAdapter.ListViewHolder>(), View.OnClickListener {

    inner class ListViewHolder( itemView: View ) : RecyclerView.ViewHolder( itemView ){
        var viewName: TextView = itemView.findViewById( R.id.vacancy_name_holder )
        var viewLoc: TextView = itemView.findViewById( R.id.vacancy_loc_holder )
        var viewDur: TextView = itemView.findViewById( R.id.vacancy_period_holder )
        var btnDetail: Button = itemView.findViewById( R.id.vacancy_detail_btn)
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

        holder.viewName.text = vacancy.name
        holder.viewLoc.text = vacancy.location
        holder.viewDur.text = vacancy.duration

        holder.btnDetail.setOnClickListener {
            val moveToDetail = Intent( holder.itemView.context, VacancyDetail::class.java )
            holder.itemView.context.startActivity( moveToDetail )
        }
    }

    override fun onClick(v: View?) {

    }
}