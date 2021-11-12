package com.example.kla.Data


import com.example.kla.Model.TopicDetail
import com.example.kla.R

class DataSource2 {
    fun topicDetail(): List<TopicDetail>{
        return listOf<TopicDetail>(
            TopicDetail(  "Kotlin is a relatively new programming language developed by JetBrains for modern multiplatform applications. Nowadays, Kotlin is widely used for Android development instead of Java. It is because Kotlin is safe, concise, and fun to read and write. The content is divided into various topics with simple and useful examples"),
            TopicDetail("Kotlin uses two different keywords to declare variables: val and var . Use val for a variable whose value never changes. You can not reassign a value to a variable that was declared using val . Use var for a variable whose value can change"),
            TopicDetail("Operators are special characters which perform operation on operands (values or variable).There are various kind of operators available in Kotlin.\n" +
                    "\n" +
                    "Arithmetic operator\n" +
                    "Relation operator\n" +
                    "Assignment operator\n" +
                    "Unary operator\n" +
                    "Bitwise operation\n" +
                    "Logical operator\n" +
                    "Arithmetic Operator\n" +
                    "Arithmetic operators are used to perform basic mathematical operations such as addition (+), subtraction (-), multiplication (*), division (/) etc"),
// will complete the remaining details later
            TopicDetail("Expressions" ),
            TopicDetail("Comments"),
            TopicDetail("Input/Output"),
            TopicDetail("Kotlin_Flow_controls"),
            TopicDetail("KotlinFunction"),
            TopicDetail("KotlinOOP")

        )
    }

}
