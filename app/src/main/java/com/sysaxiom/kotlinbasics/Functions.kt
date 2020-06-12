package com.sysaxiom.kotlinbasics

//Functions Basics
fun functions() {
    greeter("Troy")
    println("Volume is ${volume(10, 5)}")
    println("Volume is ${volumeX(width = 7, height = 13)}")
}

fun greeter(name: String) = "Hello $name"
fun volume(length: Int, width: Int, height: Int = 10) = length * width * height
fun volumeX(length: Int = 10, width: Int, height: Int)  = length * width * height

//Lambda Basics
fun lambdaBasics() {
    val lam: (Int, Int) -> Int = { a: Int, b: Int -> a + b }
    println("Sum = ${lam(5, 10)}")

    val l = { a: Int, b: Int -> a * b }
    println("5 * 10 = ${l(5, 10)}")
    println("10 * 50 = ${l.invoke(10, 50)}")

    val num = listOf(1, 5, 7, 9, 10, 13)
    println(num.filter { it < 7})

    val greet: String.() -> String = { "What's up $this?"}
    println("Troy".greet())
}

//Anonymous functions Basics
fun anonymousFunctions() {
    val num = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13)
    val fNum = num.filter(fun(a: Int): Boolean { return a < 7 })
    println(fNum)
    val fNum2 = num.filter(fun(a) = a < 7)
    println(fNum2)

    println()
    val getAge2 = lambda@{ age: Int ->
        if(age >= 65)
            return@lambda "senior discount"
        else if(age >= 21)
            return@lambda "regular"
        "underage"
    }
    println("Client pays ${getAge2(32)} price")

    println()
    val getAge = fun(age: Int):String {
        if(age >= 65)
            return "senior discount"
        else if(age >= 21)
            return "regular"
        return "underage"
    }
    println("Client pays ${getAge(70)} price")

}

//Local Functions
fun localFunctions() {
    val words = listOf("racecar", "civic", "level", "butter")
    for (word in words) {
        println("Palindrome $word? ${isPalindrome(word)}")
    }
}

fun isPalindrome(word: String): Boolean {
    fun doCharsMatch(front: Int, back: Int): Boolean {
        if (front >= back) return true
        if (word[front].toUpperCase() != word[back].toUpperCase()) return false
        return doCharsMatch(front + 1, back - 1)
    }
    if (word.length < 2) return true
    return doCharsMatch(0, word.lastIndex)
}
