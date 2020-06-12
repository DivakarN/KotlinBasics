package com.sysaxiom.kotlinbasics

//Expressions
private fun expression() {
    val bigger = 1000
    val smaller = 1
    // Won't compile
    // val max = bigger > smaller? bigger: smaller
    //
    val max = if (bigger > smaller) bigger else smaller

    val age = 35
    val boardGroup = when (age) {
        in 0..18 -> "family"
        in 65..200 -> "senior"
        else -> "regular"
    }
    println("You are in the $boardGroup group.")

    var a = 100
    var b = 101
    // Won't compile assignments are statements
    // a = b = 98
}

//If Expression
fun ifExpression() {
    val bigger = 100
    val smaller = 1
    val max = if (bigger > smaller) bigger else smaller

    if (bigger > 10) {
        println("Greater than 10!")
    } else if (bigger > 100) {
        println("Greater than 100!")
    } else {
        println("Not too big")
    }

    val number = 121
    val bucket: Any = if (number > 100) {
        "alpha"
    } else if (number > 90) {
        println("Less than 90")
        2
    } else if (number > 80) {
        println("Less than 80")
    } else {
        1
    }
    println("bucket = $bucket")

    val isGreater = if (number > 100) true else false
    val isGreater2 = number > 100

    println("Is $number greater than 100? $isGreater2")
}

//When Expression
private fun whenExpression() {
    val x = 1
    when(x) {
        1 -> println("x == 1")
        2 -> println("x == 2")
        3,4 -> println("x == 3 or 4")
    }

    val name = "Troy"
    val lastName = when (name) {
        "Hattan" -> "Shobokshi"
        "Todd" -> "Miller"
        "Troy" -> "Miles"
        else -> {
            "Unknown"
        }
    }
    println("$name $lastName")

    val ageType = when (x) {
        in 0..1 -> "baby"
        in 2..4 -> "toddler"
        in 5..12 -> "kid"
        in 13..19 -> "teenager"
        in 20..64 -> "adult"
        else -> "senior"
    }
    println("You are a $ageType")
}

//Loops
private fun loops() {
//    c-style loop
//    for (int i=0; i < 10; i++) {
//        println("i = $i")
//    }

    for (i in 1..10) {
        println("i = $i")
    }

    val students = listOf("Janet", "Daisy", "Veronica", "Fernanda")
    for (student in students) {
        println("Current student is $student")
    }

    for ((index, student) in students.withIndex()) {
        println("Student #${index + 1} is $student")
    }

    println("while")
    var count = 5
    while (count > 0) {
        println(count)
        count--
    }

    println("do while")
    do {
        println(count)
        count++
    } while (count < 5)

    println("break")
    while (count > 0) {
        if (count % 2 == 0) break
        println(count)
        count--
    }
}

//Null Safety
data class Person(var firstName: String, var lastName: String)

fun nullSafety() {
//    var person1: Person = null
    var person2: Person? = null

    val greeting: String? = "Hello there"
    if (greeting != null) {
        println("Joe says: '$greeting'")
    }

    println("greeting length = ${greeting?.length}")

    val len = greeting?.length ?: 0
    println("Length is $len")

    // exception when greeting is null
    val badLen = greeting!!.length

    val safeGreeting: String? = greeting as? String
}