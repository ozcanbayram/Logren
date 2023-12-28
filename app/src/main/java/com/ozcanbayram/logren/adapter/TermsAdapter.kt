package com.ozcanbayram.logren.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ozcanbayram.logren.databinding.RecyclerRowBinding
import com.ozcanbayram.logren.model.Term

class TermsAdapter(private val termList : ArrayList<Term>) : RecyclerView.Adapter<TermsAdapter.TermsViewHolder>() {
    class  TermsViewHolder(val binding : RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TermsViewHolder {
    val binding =RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    return TermsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return termList.size
    }

    override fun onBindViewHolder(holder: TermsViewHolder, position: Int) {
        holder.binding.termName.text =termList.get(position).term
    }
}