package com.example.myproject // CHANGE PACKAGE NAME

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import java.net.URL
import kotlin.concurrent.thread

class SearchFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)

        val listView = view.findViewById<ListView>(R.id.searchListView)
        val etSearch = view.findViewById<EditText>(R.id.etSearch)
        val btnSearch = view.findViewById<Button>(R.id.btnSearchApi)
        val btnBack = view.findViewById<Button>(R.id.btnBackHomeFromSearch)

        btnBack.setOnClickListener { parentFragmentManager.popBackStack() }

        btnSearch.setOnClickListener {
            val query = etSearch.text.toString()
            if (query.isNotEmpty()) {
                performSearch(query, listView)
            }
        }
        return view
    }

    private fun performSearch(query: String, listView: ListView) {
        thread {
            try {
                val url = "https://rickandmortyapi.com/api/character/?name=$query"
                val json = URL(url).readText()
                val response = Gson().fromJson(json, CharacterResponse::class.java)

                activity?.runOnUiThread {
                    listView.adapter = CharacterAdapter(requireContext(), response.results)
                    listView.setOnItemClickListener { _, _, i, _ ->
                        // Reuse the open detail logic
                        val detail = DetailFragment()
                        val bundle = Bundle()
                        bundle.putString("name", response.results[i].name)
                        bundle.putString("status", response.results[i].status)
                        bundle.putString("image", response.results[i].image)
                        detail.arguments = bundle

                        parentFragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, detail)
                            .addToBackStack(null)
                            .commit()
                    }
                }
            } catch (e: Exception) {
                activity?.runOnUiThread {
                    Toast.makeText(context, "No character found!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}