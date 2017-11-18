// Editor -> General -> Apprearance
// Turn on type hints

fun main(args: Array<String>) {
    println("Hello Hackatum")
    var i = 5
    var bla = 123L
    while(i > 0) {
        --i
    }
    for(x in 0..5) {
        //inclusive range
        println(x)
    }

    println("---")

    for(y in 0 until 5) {
        println(y)
    }

    val intpol = "interpolation!"

    println("String $intpol! Len: ${intpol.length}")

}

data class Coordinate(val x: Int, val y: Int)

data class MutableCoordinate(var x: Int, var y: Int)

class Vector2(val x: Int, val y: Int) {

    companion object {
        val einheit = Vector2(1,1)
    }

    fun length(): Double = Math.sqrt((x*x + y*y).toDouble())

    fun doStuff(): String {
        fun nestedMethod() {
            //because why the fudge not
        }

        val builder = StringBuilder()
        for(ctr in 0..x) {
            builder.addRandomGarbage()
        }
        return builder.toString()
    }
}

class CollectionShit {
    fun doStuff() {
        val arr = arrayOf(1,2,3)
        arr.map { it * 2 }.filter { it > 3 }.reduce { total, next -> total + next }
        arr.forEach { println(it) }
    }
}

class Car {
    fun addWheels() {

    }

    fun addBody() {

    }

    fun addWipers() {

    }

    fun addTuning() {

    }
}

fun buildMeACar(): Car {
    return Car().apply {
        addWheels()
        addBody()
        addTuning()
        addWipers()
    }
}

fun squareAll(x: Int = 0, y: Int = 0, z: Int = 0) {
    arrayOf(x,y,z).map { it * it }.sum()
}

fun doSquare() {
    squareAll(y = 3, x = 5, z = 2) //whyever you'd want to do this
}


fun StringBuilder.addRandomGarbage() {
    this.append("blaaah")
}

class Nullability(var y: String?) {
    val x: Int? = null
    fun stuff() {
        val leeen = y?.length
        x?.let {
            it.minus(3) //because it - 3 is too h a u p t s t r o m
        }
    }
}

enum class Direction {
    NORTH, SOUTH, WEST, EAST, UP
}

fun destination(dir: Direction): String = when(dir) {
    Direction.NORTH -> "arctic"
    Direction.SOUTH -> "not-arctic"
    Direction.WEST -> "america"
    Direction.EAST -> "asia"
    Direction.UP -> {
        val chars = arrayOf("m","a","r","s")
        chars.joinToString(separator = "")
    }
}



fun doStringBuilding() {
    val sb = StringBuilder()
    sb += "hello"

}