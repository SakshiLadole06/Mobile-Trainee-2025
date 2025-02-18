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

class Fragment_C : Fragment() {

    private lateinit var textForFragC: TextView
    private lateinit var btnFragC: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment__c, container, false)
        //Find id of fields
        textForFragC=view.findViewById(R.id.textForFragC)
        btnFragC=view.findViewById(R.id.btnFragC)

        setFragmentResultListener("textForC") { requestKey, bundle ->
            textForFragC.text = bundle.getString("text")?.uppercase()
        }

        //modified text from FragmentB
        setFragmentResultListener("modifiedTextForC") { requestKey, bundle ->
            textForFragC.text = bundle.getString("text")?.uppercase()
        }


        // Reset Data
        btnFragC.setOnClickListener {
            setFragmentResult("resetDataA", bundleOf())
            setFragmentResult("resetDataB", bundleOf())
            setFragmentResult("resetDataC", bundleOf())
        }

        //reset request from FragmentC
        setFragmentResultListener("resetDataC") { requestKey, bundle ->
            textForFragC.text = ""
        }
        return view
    }
}