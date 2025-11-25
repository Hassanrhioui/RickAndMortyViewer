package com.example.myproject // CHANGE PACKAGE NAME

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val btnList = view.findViewById<Button>(R.id.btnGoToList)
        val btnSearch = view.findViewById<Button>(R.id.btnGoToSearch)

        btnList.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ListFragment())
                .addToBackStack(null)
                .commit()
        }

        btnSearch.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SearchFragment())
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}