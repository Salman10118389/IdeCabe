package com.example.idecabe.ui.project

import android.app.Activity
import android.view.View
import android.widget.AdapterView
import android.widget.Switch
import android.widget.Toast
import com.example.idecabe.R

class Spinner : Activity(), AdapterView.OnItemSelectedListener {

    var courses = arrayOf<String?>("C", "Data structures",
        "Interview prep", "Algorithms",
        "DSA with java", "OS")

    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        Toast.makeText(this@Spinner, "You selected " + parent.getItemAtPosition(pos).toString() , Toast.LENGTH_LONG).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        // Another interface callback
    }
}