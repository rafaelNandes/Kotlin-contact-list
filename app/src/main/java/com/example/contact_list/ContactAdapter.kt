package com.example.contact_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//Gerenciamento de toda a lista do RecycleView
class ContactAdapter(var listener: ClickItemContactListener) :
RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>(){

    private val list: MutableList<Contact> = mutableListOf()

    //Responsável por criar a visualização de cada item na tela
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ContactAdapterViewHolder(view, list, listener)
    }

    //Percorre o array e popula a lista do RecycleView
    override fun onBindViewHolder(holder: ContactAdapterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    //Quantidade de itens que há na lista
    override fun getItemCount(): Int {
        return list.size
    }

    //Metodo para realizar a alteração da lista
    fun updateList(list: List<Contact>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()  //Informa o adapter que a lista foi modificada
    }

    //Gerencia cada item da lista
    class ContactAdapterViewHolder(itemView: View, var list: List<Contact>, var listener: ClickItemContactListener) :
    RecyclerView.ViewHolder(itemView){
        private val textViewName: TextView = itemView.findViewById(R.id.textView_name)
        private val textViewPhone: TextView = itemView.findViewById(R.id.textView_phone)
        private val imageViewPhotograph: ImageView = itemView.findViewById(R.id.imageView_photograph)

        init {
            itemView.setOnClickListener{
                listener.clickItemContact(list[adapterPosition])
            }
        }

        fun bind(contact: Contact){
            textViewName.text = contact.name
            textViewPhone.text = contact.phone

        }
    }
}