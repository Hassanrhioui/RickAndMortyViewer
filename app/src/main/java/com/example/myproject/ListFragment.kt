package com.example.myproject // CHANGE PACKAGE NAME

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import java.net.URL
import kotlin.concurrent.thread

class ListFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val listView = view.findViewById<ListView>(R.id.listView)
        val btnBack = view.findViewById<Button>(R.id.btnBackHome)

        btnBack.setOnClickListener { parentFragmentManager.popBackStack() }

        // Fetch Data
        thread {
            try {
                val json = URL("https://rickandmortyapi.com/api/character").readText()
                val response = Gson().fromJson(json, CharacterResponse::class.java)

                activity?.runOnUiThread {
                    listView.adapter = CharacterAdapter(requireContext(), response.results)

                    listView.setOnItemClickListener { _, _, i, _ ->
                        openDetail(response.results[i])
                    }
                }
            } catch (e: Exception) { e.printStackTrace() }
        }
        return view
    }

    private fun openDetail(char: Character) {
        val detail = DetailFragment()
        val bundle = Bundle()
        bundle.putString("name", char.name)
        bundle.putString("status", char.status)
        bundle.putString("image", char.image)
        detail.arguments = bundle

        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, detail)
            .addToBackStack(null)
            .commit()
    }
}