package com.sysaxiom.kotlinbasics


//Classes
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


//Constructors
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

//Data Classes

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

//Companion Object
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

//Composition and Interfaces
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