package com.example.contact_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

//Gerenciamento de toda a lista do RecycleView
class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>(){

    private val list: MutableList<Contact> = mutableListOf()

    //Responsável por criar a visualização de cada item na tela
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ContactAdapterViewHolder(view)
    }

    //Percorre o array e popula a lista do RecycleView
    override fun onBindViewHolder(holder: ContactAdapterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    //Quantidade de itens que há na lista
    override fun getItemCount(): Int {
        return list.size
    }

    //Gerencia cada item da lista
    class ContactAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(contact: Contact){

        }
    }
}