package com.walter.people

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.bloco.faker.Faker

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewUsers)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<User>()
        val faker = Faker()
        for (i in 1..50){
            val name = faker.name.firstName()+" "+ faker.name.lastName()
            val  email = faker.internet.email()
            val user = User(name, email)
            data.add(user)
        }

        val adapter = CustomAdapter(data)

        recyclerView.adapter = adapter
    }
}
//https://www.bloco.io/blog/faker-a-library-to-generate-fake-data-for-java-android