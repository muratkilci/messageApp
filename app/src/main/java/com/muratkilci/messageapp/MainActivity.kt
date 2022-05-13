package com.muratkilci.messageapp

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    val classes =
        arrayOf("A101", "A102", "A103", "A104", "A105", "B101", "B102", "B103", "B104", "B105")

    lateinit var liste: String
    lateinit var sellectclases :String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSend = findViewById<Button>(R.id.buttonSend)
        val spinner = findViewById<Spinner>(R.id.spinner)

        val arrayAdapter =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, classes)
        spinner.adapter = arrayAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                arraylList()

                sellectclases = parent.getItemAtPosition(position).toString()              ///

                Toast.makeText(parent.context, sellectclases, Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        btnSend.setOnClickListener {
            sendButton()
        }

    }


    fun arraylList() {

        val btnAdd = findViewById<Button>(R.id.buttonAdd)
        val listView = findViewById<ListView>(R.id.listView)
        val editText = findViewById<EditText>(R.id.editText)
        val textView = findViewById<TextView>(R.id.textView)


        var arr: MutableList<String> = mutableListOf<String>()
        var arrAdapter =
            ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, arr)
        listView.adapter = arrAdapter

        btnAdd.setOnClickListener {
            arr.add(editText.text.toString())
            arrAdapter.notifyDataSetChanged()
            editText.setText("")

            val list: MutableList<String> = arr.toMutableList()
            liste = list.toString()                                ///
            textView.text = liste

            var im: InputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            im.hideSoftInputFromWindow(currentFocus?.windowToken, 0)

        }

    }

    fun sendButton() {

        sellectclases             ///Sınıf adı
        liste                    ///eksik listesi


    }

}