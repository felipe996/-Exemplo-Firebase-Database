package com.br.recyclerview.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.br.recyclerview.R
import com.br.recyclerview.model.Produto
import kotlinx.android.synthetic.main.adapter_produto.view.*
import java.text.DecimalFormat



class ProdutoAdapter(
        val df:DecimalFormat,
        val list: MutableList<Produto>,
        val onClick: (Produto) -> Unit) :
        RecyclerView.Adapter<ProdutoAdapter.ViewHolder>() {

    // Retorna a quantidade de Tipos na lista
    override fun getItemCount(): Int {
        return this.list.size
    }

    // Infla o layout do adapter e retorna o ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Infla a view do adapter
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_produto, parent, false)
        // Retorna o ViewHolder que contém todas as views
        val holder = ViewHolder(view)
        return holder
    }

    // Faz o bind para atualizar o valor das views com os dados do Tipo de Venda
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Recupera o objeto Tipo
        val item = list[position]
        val view = holder.itemView

        with(view) {
            tv_descricao.text = item.descricao

            tv_valor.text = " R$ ${df.format(item.valor)}"
            setOnClickListener { onClick(item) }
        }
    }

    fun add( position: Int) {
        notifyItemInserted(position)
    }

    // ViewHolder fica vazio pois usamos o import do Android Kotlin Extensions
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    }

}
