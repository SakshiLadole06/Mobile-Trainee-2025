package com.example.taskandroid.taskfragment.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import com.example.taskandroid.R

class Fragment_B : Fragment() {

    private lateinit var textForFragB: TextView
    private lateinit var btnFragB: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment__b, container, false)
        //Find id of fields
        textForFragB =view.findViewById(R.id.textForFragB)
        btnFragB =view.findViewById(R.id.btnFragB)

        setFragmentResultListener("textForB") { requestKey, bundle ->
            textForFragB.text = bundle.getString("text")
        }

        btnFragB.setOnClickListener {
            val modifiedText = textForFragB.text.toString()

            // Send modified text back to FragmentA
            setFragmentResult("modifiedTextForA", bundleOf("text" to modifiedText))

            // Send modified text to FragmentC
            setFragmentResult("modifiedTextForC", bundleOf("text" to modifiedText))
        }

        // reset request from FragmentC
        setFragmentResultListener("resetDataB") { requestKey, bundle ->
            textForFragB.text = ""
        }

        return view
    }
}