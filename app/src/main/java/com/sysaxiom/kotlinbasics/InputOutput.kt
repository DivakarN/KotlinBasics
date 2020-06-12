package com.sysaxiom.kotlinbasics

import java.io.File
import java.util.*

//Command Line arguments
fun commandLineArguments(args: Array<String>) {

    if(args.any()) {
        println("The string = ${args[0]}")
    }

    for(arg in args) {
        println(arg)
    }
}

//Get User Input
fun getUserInput() {
    print("Enter text: ")
    val txt = readLine() ?: ""
    print("You entered: $txt, length = ${txt.length}}")

    print("\nEnter an Integer value: ")
    val string1 = readLine() ?: ""
    val iValue: Int = string1.toIntOrNull() ?: 0
    println("You entered: $iValue")

    print("\nEnter an double value: ")
    val string2 = readLine() ?: ""
    val dValue: Double = string2.toDoubleOrNull() ?: 0.0
    println("You entered: $dValue")

    scanner()
}

fun scanner() {
    println()
    val scan = Scanner(System.`in`)
    print("Enter an integer number: ")
    val num1 = scan.nextInt()
    print("Enter an double number: ")
    val num2 = scan.nextDouble()

    println()
    println("First input number = $num1")
    println("Second input number = $num2")
}

//Read and Write file
fun readWriteFile() {
    val res = "./resources"
    val pets = "pets.txt"
    val pFile = File("${res}/$pets")

    val file = File("${res}/text.txt")
    file.forEachLine { println(it) }

    val writeFile = File("$res/write.txt")
    writeFile.writeText("Kotlin = happiness")

    val pList = listOf("cat", "dog", "bird")
    pFile.writeText("")
    pList.forEach{ pFile.appendText("$it\n")}

    val newPets = mutableListOf<String>()
    pFile.forEachLine { newPets.add(it) }
    println()
    println(newPets)

    val exists = pFile.exists()
    println("\npets exists? $exists")
}


