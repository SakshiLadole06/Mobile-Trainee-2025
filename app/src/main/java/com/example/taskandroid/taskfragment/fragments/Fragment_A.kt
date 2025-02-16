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
import com.example.taskandroid.R
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener

class Fragment_A : Fragment() {
    private lateinit var textForFragA: TextView
    private lateinit var btnFragA: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment__a, container, false)
        //Find id of fields
        textForFragA = view.findViewById(R.id.textForFragA)
        btnFragA = view.findViewById(R.id.btnFragA)

        btnFragA.setOnClickListener {
            val text = textForFragA.text.toString()

            // Send data to FragmentB
            setFragmentResult("textForB", bundleOf("text" to text))

            // Send data to FragmentC
            setFragmentResult("textForC", bundleOf("text" to text))
        }

        // Listen for modified text from FragmentB
        setFragmentResultListener("modifiedTextForA") { _, bundle ->
            textForFragA.setText(bundle.getString("text"))
        }

        // Listen for reset request from FragmentC
        setFragmentResultListener("resetDataA") { requestKey, bundle ->
            textForFragA.text = ""
        }
        return view
    }
}
