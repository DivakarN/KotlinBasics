package com.sysaxiom.kotlinbasics

import android.os.Build
import androidx.annotation.RequiresApi

data class Student(val firstName: String, val grade: Int)

fun fiver(index: Int): Int{
    return index * 5;
}

//Arrays
fun arrayImplementation() {
    val things = arrayOf(1, 2, 3, "one", "two", "three")
    things[0] = "zero"
    println("info = ${things.indices}")
    for (thing in things) {
        println(thing)
    }

    val students = arrayOf<Student>(Student("Todd", 6), Student("Vern", 5))
    students[1] = Student("Daisy", 7)
    for (student in students) {
        println(student)
    }

    val fives = Array(5, ::fiver)
    fives.forEach { println(it) }

    println("fives has ${fives.size} elements")
    println("indices = ${fives.indices} ")
    println("lastIndex = ${fives.lastIndex} ")

    val pInts = intArrayOf(1, 2, 3)
}

//Lists
fun listImplementation() {
    val names = listOf("Daisy", "Hattan", "Rob", "Chenni")
    println("The first name is ${names.get(0)}")
    println("The first name is ${names[0]}")

    val subNames = names.subList(1,3)
    println(subNames)

    val items = mutableListOf(2, 4, 6, 8, 10, 10, 10, 10, 14)
    items[0] = 1
    items.add(12)
    items.removeAt(3)
    items.remove(99)
    println(items)
    println("There are ${items.size} items.")
    println("The first item is ${items.first()}")
}

//Sets
fun setImplementaion() {
    val threes = setOf(3, 3, 3, 3)
    println(threes)
    println("size = ${threes.size}")
    println("has a 4? ${threes.contains(4)}")

    println()
    val fset = mutableSetOf(1, 2, 3, 4, 5)
    val bset = mutableSetOf(5, 4, 3, 2, 1)
    println("firsts equal? ${fset.first() == bset.first()}")
    println("fset == bset? ${fset == bset}")

    println()
    val fset2 = hashSetOf(1, 2, 3, 4, 5)
    val bset2 = hashSetOf(5, 4, 3, 2, 1)
    println("firsts equal? ${fset2.first() == bset2.first()}")
    println("fset2 == bset2? ${fset2 == bset2}")

    println()
    println("added 6? ${fset.add(6)}")
    println("removed 76? ${fset.remove(76)}")

    println()
    val aList = fset2.toList()
    println(aList)
}

//Maps
@RequiresApi(Build.VERSION_CODES.N)
fun mapsImplementation() {
    val m1 = mapOf(1 to "alpha", 2 to "beta", 3 to "gamma", 4 to "delta")
    val m2 = mapOf(4 to "delta", 3 to "gamma", 2 to "beta", 1 to "alpha")
    println("m1 == m2? ${m1 == m2}")

    println("m1[2] = ${m1[2]}")
    println("m1[5] = ${m1.getOrDefault(5, "Not present")}")

    println()
    val cars = mutableMapOf(
        "ford" to 1903, "gm" to 1908,
        "dodge" to 1913, "tucker" to 1944
    )
    cars["tesla"] = 2003
    println("removed tucker = ${cars.remove("tucker")}")
    for (key in cars.keys) {
        println(key)
    }

    println("has ford? ${"ford" in cars}")
    println("has 1908? ${1908 in cars.values}")

}

//Collection Operators
fun collectionOperators() {
    val list = listOf(1, 2, 3, 4, 5, 5, 6, 7, 7, 8)
    val set = setOf(10, 20, 30, 40, 50)
    val map = mapOf(1 to 10, 2 to 20, 3 to 30)

    val tList = list.map{ it * 2}
    println("transformed list = $tList")
    val tMap = map.map{ Pair(it.key, it.value * 10)}.toMap()
    println("transformed map = $tMap")

    println()
    val fList = list.filter { it % 2 == 1}
    println("only odds = $fList")
    val fSet = set.filter { it > 100 }
    println("Is fSet empty? = ${fSet.isEmpty()}")

    println("sorted descending set = ${set.sortedDescending()}")

    println()
    println("tList last: ${tList.last { it > 2}}")

    println()
    println("list to set = ${list.toSet()}")
    println("set to list = ${set.toList()}")
}

//Sequences
fun sequenceImplementation() {
    val result = (100 until 200).asSequence()
        .map { println("doubling $it"); it * 2 }
        .filter { println("filtering $it"); it % 3 == 0 }
        .first()
    println("results = $result")
    println()

    println()
    val myThrees = sequenceOf(1, 3, 5, 7, 9).filter { it % 3 == 0 }
    println("myThrees = $myThrees")
    println(myThrees.toList())
}




