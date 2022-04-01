import kotlin.math.abs

fun plusMinus(arr: Array<Int> = arrayOf(1, 1, 0, -1, -1)): Unit {
    val n = arr.size.toDouble()
    val positive = arr.filter { it > 0 }.size / n
    val negative = arr.filter { it < 0 }.size / n
    val zero = arr.filter { it == 0 }.size / n


    println("%6f".format(positive).replace(',', '.'))
    println("%.6f".format(negative).replace(',', '.'))
    println("%.6f".format(zero).replace(',', '.'))


}


fun computeClosestToZero(ts: Array<Int> = arrayOf(-5, 5, 9, -23)): Int {


    val lista = ts.toMutableList() //.also { it.add(0) }
    lista.sort()

    ts.sort()

    val zeroPosition = lista.indexOf(lista.find { it == 0 })

    val negatives = ts.filter { it < 0 }.reversed()
    val positives = ts.filter { it > 0 }

    if (negatives.isNotEmpty() && positives.isNotEmpty()) {
        println(abs(negatives[0]))
    }





    return ts.minOrNull() ?: 0
}


fun miniMaxSum(arr: Array<Int> = arrayOf(1, 3, 5, 7, 9)): Unit {
    //println(arr.sortedArray().toList())
    // arr.sort()
    //val min = arr.sliceArray(0 until arr.size - 1).sum()
    //val max = arr.sliceArray(1 until arr.size).sum()


    val sum = arr.sum()

//    val maxSum = sum - arr[0]
//    val minSum = sum - arr[4]

    val min = arr.sum() - arr.maxOrNull()!!
    val max = arr.sum() - arr.minOrNull()!!

    println("$min $max")
    // println("$minSum $maxSum")


}

fun timeConversion(s: String = "07:05:45PM"): String {

    val listHora = s.take(8).split(":").toMutableList()

    when (s.takeLast(2)) {
        "PM" -> {
            if (listHora[0] != "12") {
                listHora[0] = (listHora[0].toInt() + 12).toString()
            }
        }
        "AM" -> {
            if (listHora[0] == "12") {
                listHora[0] = "00"
            }
        }

    }
    return listHora.joinToString(":")
}

/**
 * DAY 2
 */
//https://www.hackerrank.com/challenges/one-week-preparation-kit-lonely-integer/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-two

fun lonelyinteger(a: Array<Int> = arrayOf(1, 2, 3, 4, 3, 2, 1)): Int {


    return a.groupingBy { it }.eachCount().filterValues { it == 1 }.keys.first()

}

fun diagonalDifference(arr: Array<Array<Int>>): Int {
   // println(arr.contentDeepToString())

    //import kotlin.math.abs
    var m = 0
    var n = 0
    var k = 0
    var l = arr.size -1
    var suma1 = 0
    var suma2 = 0

    for (i in 0 until arr.size){
        suma1 += arr[m][n]
        m +=1
        n +=1

        suma2 += arr[k][l]
        k +=1
        l -=1
    }
    //println(abs(suma1-suma2))

    return abs(suma1-suma2)

}

fun main() {


    diagonalDifference(
        arrayOf(
            arrayOf(1, 2, 3),
            arrayOf(4, 5, 6),
            arrayOf(9, 8, 9)
        )
    )
}


fun diagonalDifferencessss(arr: Array<Array<Int>>): Int {
    println(arr.contentDeepToString())

    //import kotlin.math.abs
    var m = 0
    var n = 0
    var k = 0
    var l = arr.size -1
    var suma1 = 0
    var suma2 = 0

    for (i in 0 until 3){
        suma1 += arr[m][n]
        m +=1
        n +=1

        suma2 += arr[k][l]
        k +=1
        l -=1
    }


    println(suma1)
    println(suma2)
    println(abs(suma1-suma2))

    return abs(suma1-suma2)

}
