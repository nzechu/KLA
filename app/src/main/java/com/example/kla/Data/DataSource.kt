package com.example.kla.Data

import com.example.kla.Model.Topic
import com.example.kla.R

class DataSource {
    fun loadTopics(): List<Topic>{
        return listOf<Topic>(
            Topic(R.drawable.ic_book_24, "Introduction"),
            Topic(R.drawable.ic_book_24, "Kotlin Variables"),
            Topic(R.drawable.ic_book_24, "kotlin data types"),
            Topic(R.drawable.ic_book_24, "Kotlin Operators"),
            Topic(R.drawable.ic_book_24, "Kotlin Expressions "),
            Topic(R.drawable.ic_book_24, "Kotlin Comments"),
            Topic(R.drawable.ic_book_24, "Kotlin Input/Output"),
            Topic(R.drawable.ic_book_24, "Kotlin Flow Controls"),
            Topic(R.drawable.ic_book_24, "Kotlin Function"),
            Topic(R.drawable.ic_book_24, "Kotlin OOP")

        )
    }

}
