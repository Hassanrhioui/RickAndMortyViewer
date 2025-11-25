package com.example.myproject // CHANGE TO YOUR PACKAGE NAME

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class CharacterAdapter(private val context: Context, private val dataSource: List<Character>) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int = dataSource.size
    override fun getItem(position: Int): Any = dataSource[position]
    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = convertView ?: inflater.inflate(R.layout.row_item, parent, false)

        val nameTv = rowView.findViewById<TextView>(R.id.tvName)
        val speciesTv = rowView.findViewById<TextView>(R.id.tvSpecies)
        val imageView = rowView.findViewById<ImageView>(R.id.imgCharacter)

        val character = getItem(position) as Character

        nameTv.text = character.name
        speciesTv.text = character.species
        Glide.with(context).load(character.image).into(imageView)

        return rowView
    }
}