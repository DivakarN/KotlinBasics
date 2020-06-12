# KotlinBasics

Kotlin:
-------
Kotlin is a language released by Jetbrains.

1) Statically typed programming,
	a) compile-time verification
	b) Better code completion
	c) Improved application performance
2) concise
3) Inter operable
4) Null safe
5) Supports functional programming
	a) Conciseness
	b) Multi threading
	c) Easier testing

Types of Variables:
-------------------

Var - Its creates mutable variable the one you can change it later
Val - Its creates immutable variable. It value can be set only once.

Advantages of having Immutable Variables:
-----------------------------------------
1) Legible - Mutable variables may gets changed at runtime, so it will consume more memory in the stack. So Immutable variables are very legible to use in the application.
2) Testable 
3) Thread safe

Integers:
---------

Int - 32 bits
Long - 64 bits
Byte - 8 Bits
Short - 16 Bits
Float - 32 Bits
Double - 64 Bits

//Intergers
private fun integersDeclaration(){
    val intVariable: Int = 23942934
    val longVariable: Long = 3867869875L
    val byteVariable: Byte = 23
    val shortVariable: Short = 12373
    val doubleVariable: Double = 1232.23
    val floarVariable: Float= 2346.32F

    val underscoreVariable: Int = 7_000
    val toIntVariable: Int = longVariable.toInt()
    val toFloatVariable: Float = doubleVariable.toFloat()
}

//Characters
private fun characterDeclaration(){
    val charVariable: Char = 'A'
    val asciiVariable: Char = '\t' /*tab*/
    val unicodeVariable: Char = '\u221E' /*infinity*/
}

//Boolean
private fun BooleanDeclaration(){
    val booleanVariable: Boolean = false
}

//Logical operation
1) OR - Either Operand is true then result will be true
2) AND - Either Operand is false then result will be false
4) NOT - Returns the inverse of the boolean

//Logical Operation
private fun logicalOperation(){
    val firstOperand = true
    val secondOperand = false

    println(firstOperand || secondOperand)
    println(firstOperand && secondOperand)
    println(!firstOperand)
}

//Strings
//String
private fun stringDeclaration() {
    val greeting: String = "Hello there"
    val owe = 50

    val janet = "I owe Janet \$$owe dollars"
    println(janet)

    val infinity = "The infinity symbol is \u221E"
    println(infinity)

    println("[$greeting] is ${greeting.length} characters long")

    var bad = greeting.get(2)
    val letter = greeting[1]

    val compare1 = "beta"
    val compare2 = "alpha"
    println("${compare1.compareTo(compare2)}")

    val sub = greeting.subSequence(6, 9)
    println("sub = $sub")

    for(single in greeting) {
        print("$single ")
    }

    val myString = """
    Kotlin is fun.
    Kotlin is pragmatic.
    """
    println(myString)
}

Statement:
----------

A Statement is a syntactic unit of an imperative programming language that expresses some action to be carried out.
It produces an action.

Expression:
-----------

An Expression in a programming language is a combination of one or more constants, variables, operators and functions that the programming language interprets and computes to produce another value.
It produces a value

private fun expression() {
    val bigger = 1000
    val smaller = 1
    // Won't compile
    // val max = bigger > smaller? bigger: smaller
    
	//In Kotlin If else returns values, so it can also act as ternary operator in kotlin.
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

If / Else If Expression:
------------------------

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

When Expression:
----------------

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

Loops:
------

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

Null safety:
------------

Kotlin allows only a nullable variable can be set as null. So we can reduce most of the errors in the compile time itself. 
Safe call(.?) - If it's null it won't throw error, instead it returns null 
Not-null assertion(!!) - If it's null it throws error. We have to make sure that the variable cannot have a null value.
Elwis operator(?:) - It returns a value even if we have null value. 

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

Arrays:
-------

Its use to store Fixed size collection of items
We can't resize arrays

//Array Implemetation
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

Collections:
-------------
It used to group the element.
Three main collection types:
1) Lists
2) Sets
3) Maps

Collections varieties:
1) Read-only
2) Mutable

Lists:
------

Ordered collection of element

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

Sets:
-----

Kotlin Set interface is a generic unordered collection of elements and it does not contain duplicate elements.

MutableSet is a generic unordered collection of elements that does not support duplicate elements, and supports adding and removing elements.

The HashSet class store elements using hashing mechanism. It does not support duplicate value and does not make guarantees about the order sequence of element.

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

Maps:
-----

Maps are collection of key value pair in which key must be unique.

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

Collection Operations:
----------------------

List of operation can be performed in collections

1) Transformations
Its creates new collection from old collection. The new collection has the same number of elements in the old collection
map keyword is used for transformations in collection

2) Filtering
Its creates new collection from old collection whatever element in the old collection mets with the conditions
3) Ordering
4) Retrieving an element
5) Retrieving a collection
6) Grouping
7) Aggregation
8) Plus and minus operators

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

Sequences:
----------

Sequences are a key abstraction to functional programming in Kotlin, a concept quite similar to Java 8 Streams. Sequences enable you to easily operate upon collections of elements by chaining pure function calls with a rich fluent API.

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

Input, Output and Files:
------------------------

//Command Line arguments
fun commandLineArguments(args: Array<String>) {

    if(args.any()) {
        println("The string = ${args[0]}")
    }

    for(arg in args) {
        println(arg)
    }
}

Get User Input:
---------------

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

Read and Write File Data:
-------------------------

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

Functions:
----------

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

Classes:
--------

class PlainShort {}

class ShortClass

class WithConstructor constructor(name: String, age: Int) {}

class WithoutConstructor (name: String, age: Int) {}

class MandatoryConstructor internal constructor(name: String, age: Int) {}

class CourseProperty(courseTitle: String) {
    val title = courseTitle
}

class Person1(val firstName: String, lastName: String, var age: Int) {}

class Course(courseTitle: String) {
    private val title = courseTitle
    internal var description = ""
        get(){
            return if(field.isNullOrBlank()) "no description" else "$field!"
        }

    fun show() {
        println(title)
    }

//    override fun toString(): String {
//        return "$title - $description"
//    }
}

fun classMain() {
    val course = Course("Kotlin Essential Training")
    course.description = "secrets you want to know"
    course.show()
    println(course)
}


Constructors:
-------------

class Vehicle(
    val make: String, val model: String,
    val year: Int, val state: String = "CA"
) {
    override fun toString(): String {
        return "$year $make $model ($state)"
    }

    init {
        println("First initializer block - $this")
    }

    constructor(
        make: String, model: String,
        year: Int, state: String, style: String
    ) : this(make, model, year, state) {
        this.style = style
    }

    constructor(
        make: String, model: String,
        year: Int, state: String, style: String,
        status: String
    ) : this(make, model, year, state, style) {
        this.status = status
    }

    private var style = ""
    private var status = ""


}

fun constructorMain() {
    val car = Vehicle("Chevrolet", "Volt", 2018)
    println(car)
    val car2 = Vehicle(state = "NV", year = 2019, make = "Ford", model = "Mustang")
    println(car2)
    val car3 = Vehicle("Tesla", "Model S", 2019, "RI", "P100D")
    println(car3)
    val car4 = Vehicle("Tesla", "Model 3", 2019, "CA",
        "Performance", "New")
    println(car4)
}

Data Classes:
-------------

//class Student(val firstName: String, val lastName: String, val grade: Int) {
//    override fun toString(): String {
//        return "($firstName $lastName $grade)"
//    }
//
//    override fun equals(other: Any?): Boolean {
//        if (other is Student) {
//            return lastName == other.lastName &&
//                    firstName == other.firstName &&
//                    grade == other.grade
//        }
//        return false
//    }
//
//    override fun hashCode(): Int {
//        var result = firstName.hashCode()
//        result = 31 * result + lastName.hashCode()
//        result = 31 * result + grade
//        return result
//    }
//}

data class Student1(val firstName: String, val lastName: String, val grade: Int)

fun dataMain() {
    val students = mutableListOf<Student1>(
        Student1("abel", "baker", 11),
        Student1("abel", "baker", 11),
        Student1("delta", "echo", 12)
    )
    println()
    println(students[0])
    println("Does ${students[0]} == ${students[1]}: ${students[0] == students[1]}")

    val charlie = students[0].copy(firstName = "charlie")
    students.add(charlie)
    println()
    for(student in students){
        println(student)
    }
}

Companion Object:
-----------------

class CantCreate private constructor(val message: String) {
    fun showMessage() {
        println(message)
    }

    companion object {
        const val Light_Speed = 299_792_458
        fun factory(msg: String): CantCreate {
            return CantCreate(msg)
        }

        fun sillyPrint(self: CantCreate) {
            println("Accessing ${self.message}")
        }
    }
}

fun companionMain() {
    val c1 = CantCreate.factory("Hello, there")
    c1.showMessage()
    CantCreate.sillyPrint(c1)
    println("The speed of light is ${CantCreate.Light_Speed} ms/s")
}

Composition and Interfaces:
---------------------------

interface IWorker {
    val jobTitle: String
    fun trackHours(hours: Double)
    fun doWork()
}

interface IBeing {
    val firstName: String
    fun getName(): String
}

class Worker(override val jobTitle: String) : IWorker {
    private var totalHours = 0.0

    override fun trackHours(hours: Double): Unit {
        totalHours += hours
    }

    override fun doWork() {
        println("Doing ${this.jobTitle} work.")
    }
}

class Being(override val firstName: String) : IBeing {
    override fun getName(): kotlin.String {
        return firstName
    }
}

interface IPayment {
    fun calcPay(): Double
}

class HourlyPay(val hourlyRate: Double) : IPayment {
    override fun calcPay(): Double {
        return hourlyRate
    }
}

class SalariedPay(val yearlyRate: Double) : IPayment {
    override fun calcPay(): Double {
        return yearlyRate
    }
}

class Employee(worker: IWorker, being: IBeing, pay: IPayment) :
    IWorker by worker, IBeing by being, IPayment by pay {
}

class NoPay() : IPayment {
    override fun calcPay(): Double {
        return 0.0
    }
}

fun main() {
    val hourly = Employee(Worker("bit wrangler"),
        Being("abel"), HourlyPay(42.42))
    println("My name is ${hourly.getName()}")
    hourly.doWork()

    val salaried = Employee(Worker("program manager"),
        Being("beth"), SalariedPay(100_000.0))
    println("My name is ${salaried.getName()}")
    salaried.doWork()

    val rescueDog = Employee(Worker("rescue dog"),
        Being("fido"), NoPay())
    println("My name is ${rescueDog.getName()}")
    rescueDog.doWork()
}

Extension:
----------

//Property Extension
val Int.isEven: Boolean
    get() = this % 2 == 0

//Function Extension
fun View.show() {
    visibility = View.VISIBLE
}
