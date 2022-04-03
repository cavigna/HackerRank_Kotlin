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
    var l = arr.size - 1
    var suma1 = 0
    var suma2 = 0

    for (i in 0 until arr.size) {
        suma1 += arr[m][n]
        m += 1
        n += 1

        suma2 += arr[k][l]
        k += 1
        l -= 1
    }
    //println(abs(suma1-suma2))

    return abs(suma1 - suma2)

}


fun countingSortsss(arr: Array<Int> = arrayOf(1, 1, 3, 2, 1)): Array<Int> {

    val mapa = arr.groupingBy { it }.eachCount()
    println(mapa)

    val listado = mutableListOf<Int>()
    val array = Array(100) { 0 }
    mapa.forEach { (k, v) ->
        array[k] = v

    }


    mapa.forEach { k, v ->
        (0 until v).forEach {
            listado.add(k)
        }
    }



    println(array.toList())
    println(listado)



    return emptyArray()

}

fun countingSort(arr: Array<Int> = arrayOf(1, 1, 3, 2, 1)): Array<Int> {

    val array = Array(100) { 0 }

    arr.groupingBy { it }.eachCount().forEach { (k, v) ->
        array[k] = v

    }

    return array

}

/**
 * Original alphabet:      abcdefghijklmnopqrstuvwxyz
Alphabet rotated +3:    defghijklmnopqrstuvwxyzabc

Original alphabet:      abcdefghijklmnopqrstuvwxyz
Alphabet rotated +2:    cdefghijklmnopqrstuvwxyzab

m -> o
i -> k
d -> f
d -> f
l -> n
e -> g
-    -
O -> Q
u -> w
t -> v
z -> b
 */


fun caesarCipher(s: String = "middle-Outz", k: Int = 2): String {


    val listaMutable = mutableListOf<String>()

    s.forEach {
        when (it.isLetter()) {
            true -> {


                var n = if (it.code +k > 122) (96 +(it.code +k - 122)) else it.code+k
                //while (n<)

                listaMutable.add(n.toChar().toString())

            }
            false -> {
                listaMutable.add(it.toString())
            }
        }
    }

    println(listaMutable.joinToString(""))

    return s

}


fun main() {
    caesarCipher()
    caesarCipher("There's-a-starman-waiting-in-the-sky", 8)



}





