package com.arioki.latihan1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var items : MutableList<Item> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        val list = findViewById<RecyclerView>(R.id.club_list)
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = RecyclerViewAdapter(this, items){
            val toast = Toast.makeText(applicationContext, it.name, Toast.LENGTH_SHORT)
            toast.show()
        }
    }

    private fun initData() {
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)

        items.clear()
        for (i in name.indices){
            items.add(Item(name[i],image.getResourceId(i, 0)))
        }
        image.recycle()
    }

}
