package com.example.myproject // CHANGE PACKAGE NAME

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

class DetailFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        val nameTv = view.findViewById<TextView>(R.id.detailName)
        val statusTv = view.findViewById<TextView>(R.id.detailStatus)
        val img = view.findViewById<ImageView>(R.id.detailImage)
        val btnBack = view.findViewById<Button>(R.id.btnBackToList)

        nameTv.text = arguments?.getString("name")
        statusTv.text = arguments?.getString("status")
        Glide.with(this).load(arguments?.getString("image")).into(img)

        btnBack.setOnClickListener { parentFragmentManager.popBackStack() }

        return view
    }
}