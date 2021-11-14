package com.example.kla.Data

import com.example.kla.Model.Topic
import com.example.kla.R

object DataSource {
    val loadTopics= listOf(

            Topic(R.drawable.ic_book_24, "Introduction","Kotlin is a relatively new programming language developed by JetBrains for modern multiplatform applications. Nowadays, Kotlin is widely used for Android development instead of Java. It is because Kotlin is safe, concise, and fun to read and write."),
            Topic(R.drawable.ic_book_24, "Kotlin Variables", "Kotlin uses two different keywords to declare variables: val and var . Use val for a variable whose value never changes. You can not reassign a value to a variable that was declared using val . Use var for a variable whose value can change"),
            Topic(R.drawable.ic_book_24, "kotlin data types", "Kotlin data type is a classification of data which tells the compiler how the programmer intends to use the data. For example, Kotlin data could be numeric, string, boolean etc.\n" +
                    "\n" +
                    "Kotlin treats everything as an object which means that we can call member functions and properties on any variable.\n" +
                    "\n" +
                    "Kotlin is a statically typed language, which means that the data type of every expression should be known at compile time.\n" +
                    "\n" +
                    "Kotlin built in data type can be categorized as follows:\n" +
                    "\n" +
                    "Number\n" +
                    "\n" +
                    "Character\n" +
                    "\n" +
                    "String\n" +
                    "\n" +
                    "Boolean\n" +
                    "\n" +
                    "Array"),
            Topic(R.drawable.ic_book_24, "Kotlin Operators", "Operators are special characters which perform operation on operands (values or variable).There are various kind of operators available in Kotlin. Arithmethic operators include +, -, *, /, %. Assignment Operator =,Increment/Decrement operators +a, -b, !, ++, --. Comparison and Equality operators >, <, >=, <=, ==,!= and Logical operators ||, &&"),
            Topic(R.drawable.ic_book_24, "Kotlin Comments", "A comment is a programmer-readable explanation or annotation in the Kotlin source code. They are added with the purpose of making the source code easier for humans to understand, and are ignored by Kotlin compiler."),
            Topic(R.drawable.ic_book_24, "Kotlin Flow Controls", " They are used to control the flow of execution in Kotlin examples are the if-else expressions, do while loop, for loop."),
            Topic(R.drawable.ic_book_24, "Kotlin Classes/Objects", " Everything in Kotlin is associated with classes and objects, along with its properties and functions. For example: in real life, a car is an object. The car has properties, such as brand, weight and color, and functions, such as drive and brake.\n" +
                    "\n" +
                    "A Class is like an object constructor, or a \"blueprint\" for creating objects."),

            Topic(R.drawable.ic_book_24, "Kotlin Function", "A function is a block of code which is written to perform a particular task. Functions are supported by all the modern programming languages and they are also known as methods. A function takes some input which is called parameters, perform certain actions on these inputs and finally returns a value.")

        )
    }

