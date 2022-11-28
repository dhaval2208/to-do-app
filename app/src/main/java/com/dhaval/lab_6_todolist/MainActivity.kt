// Name :- DhavalKumar Zaverbhai Bhimani
// Student Id :- A00255187
// Course :- JAV-1001 - 91337 - App Development for Android - 202209 - 001





package com.dhaval.lab_6_todolist

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.*

// define all the variable
class MainActivity : AppCompatActivity() {
    var items: ArrayList<String>? = null
    var itemsAdapter: ArrayAdapter<String>? = null
    var listview: ListView? = null
    var button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listview = findViewById(R.id.Listview)
        button = findViewById(R.id.Button)
// use button for add Item
        button?.setOnClickListener(View.OnClickListener {

                view ->
            addItem(view)

        })


        items = ArrayList()
// use ArrayAdapter use list item
        itemsAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items!!)
        listview?.setAdapter(itemsAdapter)
        setUpListViewListener()
    }

    private fun setUpListViewListener() {
        listview!!.onItemLongClickListener =
            AdapterView.OnItemLongClickListener { adapterView, view, i, l ->
                val context = applicationContext
                // use Toast for Item Removed
                Toast.makeText(context, "Item Removed", Toast.LENGTH_LONG).show()
                items!!.removeAt(i)
                itemsAdapter!!.notifyDataSetChanged()
                true
            }
    }

    private fun addItem(view: View) {
        val input = findViewById<EditText>(R.id.ListName)
        val itemText = input.text.toString()
        if (itemText != "") {
            itemsAdapter!!.add(itemText)
            input.setText("")
        } else {
            Toast.makeText(applicationContext, "please Enter text...", Toast.LENGTH_SHORT).show()
        }
    }
}

