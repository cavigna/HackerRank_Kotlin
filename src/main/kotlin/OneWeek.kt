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



fun computeClosestToZero (ts: Array<Int> = arrayOf(-5,5,9,-23)): Int {


    val lista = ts.toMutableList() //.also { it.add(0) }
    lista.sort()

    ts.sort()

    val zeroPosition = lista.indexOf(lista.find { it==0 })

    val negatives = ts.filter { it<0 }.reversed()
    val positives = ts.filter { it>0 }

    if (negatives.isNotEmpty() && positives.isNotEmpty()){
        println(abs(negatives[0]))
    }





    return ts.minOrNull() ?:0
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

    when(s.takeLast(2)){
       "PM" -> {
           if (listHora[0] != "12"){
               listHora[0] = (listHora[0].toInt() + 12).toString()
           }
       }
        "AM" ->{
            if (listHora[0] =="12"){
                listHora[0] = "00"
            }
        }

    }
    return listHora.joinToString(":")
}

fun main() {

}

