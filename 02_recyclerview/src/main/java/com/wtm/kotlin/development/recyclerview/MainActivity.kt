package com.wtm.kotlin.development.recyclerview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.recyclerView

// based on this link : https://developer.android.com/guide/topics/ui/layout/recyclerview

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.setHasFixedSize(true)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val userAdapter = UserAdapter()
        recyclerView.adapter = userAdapter

        userAdapter.setData(items())
    }

    private fun items(): List<User> {
        return listOf(User("Steve", 35),
                User("Amelia", 20),
                User("Seong", 22),
                User("Merry", 31),
                User("Kara", 28),
                User("Olivia", 30),
                User("Isla", 45),
                User("Emily", 42)
        )
    }
}

data class User(val name: String, val age: Int)

