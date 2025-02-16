package com.example.taskandroid.taskdialogs

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.example.taskandroid.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.dialog.MaterialDialogs

class TaskDialogMain : AppCompatActivity() {
    private lateinit var cdb1: Button
    private lateinit var cdb2: Button
    private lateinit var cdb3: Button
    private lateinit var cdb4: Button
    private lateinit var cdb5: Button

    private lateinit var mdb1: Button
    private lateinit var mdb2: Button
    private lateinit var mdb3: Button
    private lateinit var mdb4: Button
    private lateinit var mdb5: Button

    private lateinit var customBtn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        val arr:Array<String> = arrayOf("Item One", "Item Two", "Item Three")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_dialog_main)
        //Custom
        customBtn=findViewById(R.id.customBtn)
        customBtn.setOnClickListener{
            var msg:String?="Are you sure to log Out"
            showCustomDialogBox(msg)
        }

        //Simple Dialog box
        cdb1 = findViewById(R.id.cdb1)
        cdb1.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Simple Dialog")
                .setMessage("This is a simple dialog.")
                .show()
        }
        ////Simple Dialog box Material
        mdb1 = findViewById(R.id.mdb1)
        mdb1.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Simple Dialog")
                .setMessage("This is a simple dialog.")
                .show()
        }
        //Simple Dialog box
        cdb2 = findViewById(R.id.cdb2)
        cdb2.setOnClickListener {
            AlertDialog.Builder(this)
                .setMessage("This is a simple dialog.")
                .setTitle("I am the title")
                .setPositiveButton("Positive") { dialog, which ->
                    Toast.makeText(this, "Clicked Positive", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Negative") { dialog, which ->
                    Toast.makeText(this, "Clicked Negative", Toast.LENGTH_SHORT).show()
                }
                .show()
        }
        //Simple Dialog box Material
        mdb2 = findViewById(R.id.mdb2)
        mdb2.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setMessage("This is a simple dialog.")
                .setTitle("I am the title")
                .setPositiveButton("Positive") { dialog, which ->
                    Toast.makeText(this, "Clicked Positive", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Negative") { dialog, which ->
                    Toast.makeText(this, "Clicked Negative", Toast.LENGTH_SHORT).show()
                }
                .show()
        }
        //list in the Dialog box
        cdb3=findViewById(R.id.cdb3)
        cdb3.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("I am the title")
                .setPositiveButton("Positive") { dialog, which ->
                    Toast.makeText(this, "Clicked Positive", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Negative") { dialog, which ->
                    Toast.makeText(this, "Clicked Negative", Toast.LENGTH_SHORT).show()
                }
                .setItems(arr) { dialog, which ->
                    // Do something on item tapped.
                }.show()
        }

        //list in the Material Dialog box
        mdb3 = findViewById(R.id.mdb3)
        mdb3.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("I am the title")
                .setPositiveButton("Positive") { dialog, which ->
                    Toast.makeText(this, "Clicked Positive", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Negative") { dialog, which ->
                    Toast.makeText(this, "Clicked Negative", Toast.LENGTH_SHORT).show()
                }
                .setItems(arr) { dialog, which ->
                    // Do something on item tapped.
                }.show()
        }
        //list in the Dialog box Multiple selection
        cdb4=findViewById(R.id.cdb4)
        cdb4.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("I am the title")
                .setPositiveButton("Positive") { dialog, which ->
                    Toast.makeText(this, "Clicked Positive", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Negative") { dialog, which ->
                    Toast.makeText(this, "Clicked Negative", Toast.LENGTH_SHORT).show()
                }
                .setMultiChoiceItems(arr,null) { dialog, which ,isclickable ->
                    // Do something on item tapped.
                }.show()
        }
        //list in the Material Dialog box Multiple selection
        mdb4 = findViewById(R.id.mdb4)
        mdb4.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("I am the title")
                .setPositiveButton("Positive") { dialog, which ->
                    Toast.makeText(this, "Clicked Positive", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Negative") { dialog, which ->
                    Toast.makeText(this, "Clicked Negative", Toast.LENGTH_SHORT).show()
                }
                .setMultiChoiceItems(arr,null) { dialog, which ,isclickable ->
                    // Do something on item tapped.
                }.show()
        }
        //list in the Dialog box Multiple selection
        cdb5=findViewById(R.id.cdb5)
        cdb5.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("I am the title")
                .setPositiveButton("Positive") { dialog, which ->
                    Toast.makeText(this, "Clicked Positive", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Negative") { dialog, which ->
                    Toast.makeText(this, "Clicked Negative", Toast.LENGTH_SHORT).show()
                }
                .setSingleChoiceItems(arr,0) { dialog, which ->
                    // Do something on item tapped.
                }.show()
        }
        //list in the Material Dialog box Multiple selection
        mdb5 = findViewById(R.id.mdb5)
        mdb5.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("I am the title")
                .setPositiveButton("Positive") { dialog, which ->
                    Toast.makeText(this, "Clicked Positive", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Negative") { dialog, which ->
                    Toast.makeText(this, "Clicked Negative", Toast.LENGTH_SHORT).show()
                }
                .setSingleChoiceItems(arr,0) { dialog, which ->
                    // Do something on item tapped.
                }.show()
        }
    }

    //custom function for Dialog Box
    private fun showCustomDialogBox(msg: String?) {
        val dialogCustom = Dialog(this)
        dialogCustom.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogCustom.setCancelable(false)
        dialogCustom.setContentView(R.layout.custom_dialog_box)
        dialogCustom.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val tvmsg: TextView = dialogCustom.findViewById<TextView?>(R.id.msg1)
        val YesBtn: Button = dialogCustom.findViewById(R.id.btnYes)
        val NoBtn: Button = dialogCustom.findViewById(R.id.btnNo)

        tvmsg.text = msg
        YesBtn.setOnClickListener {
            Toast.makeText(this, "Yes", Toast.LENGTH_SHORT).show()
            dialogCustom.dismiss()
        }
        NoBtn.setOnClickListener {
            dialogCustom.dismiss()
        }
        dialogCustom.show()
    }

}