package com.sysaxiom.kotlinbasics

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

//Logical Operation
private fun logicalOperation(){
    val firstOperand = true
    val secondOperand = false

    println(firstOperand || secondOperand)
    println(firstOperand && secondOperand)
    println(!firstOperand)
}

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
