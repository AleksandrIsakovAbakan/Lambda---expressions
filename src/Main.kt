fun main() {

    /*
    Напишите функцию, которая запускает лямбду print() столько раз сколько будет указано в параметре count.
    Например, чтобы передаваемое сообщение в print() выводилось count раз.
    */
    val count = 10
    val text1 = "Привет, мир! "
    printCount(count, text1) { text -> print(text) }
    println()
    println()

    /*
    Напишите программу, реализующую лямбда-выражение для вычисления среднего арифметического списка чисел.
    */
    val list = listOf(25, 4, 88, 95, 2, 39, 44)
    print("$list list.average() = ${list.average()} ")
    println()
    println("Напишите программу, реализующую лямбда-выражение для вычисления среднего арифметического списка чисел")
    println(arithmeticMeanOfListOfNumbers(list) { a: Double, b: Int -> a + b })
    println()

    /*
    Дан массив произвольного набора чисел.
    Отфильтруйте его, чтобы в нем остались только положительные числа.
    */
    val array = intArrayOf(25, 4, -88, 95, 2, -39, -44)
    println(array.contentToString())
    println("остались только положительные числа")
    println(onlyPositiveNumbers(array) { it > 0 }.contentToString())
    println()

    /*
    Напишите программу, которая реализует лямбда-выражение для работы с массивом целых чисел таким образом,
    что его четные элементы делятся на 2, нечетные – умножаются на 3.
    */
    println(array.contentToString())
    convertingArrayElements(array) { a -> if (a % 2 == 0) a / 2 else a * 3 }
    println("четные элементы делятся на 2, нечетные – умножаются на 3")
    println(array.contentToString())

}

fun printCount(count: Int, text: String, print: (String) -> Unit) {
    for (a in 0..<count) print(text)
}

fun arithmeticMeanOfListOfNumbers(list: List<Int>, average: (Double, Int) -> Double): Double {
    var result = 0.0
    for (a in list) result = average(result, a)
    return result / list.size
}

fun onlyPositiveNumbers(array: IntArray, positive: (Int) -> Boolean): IntArray {
    val result = mutableListOf<Int>()
    for (a in array) if (positive(a)) result.add(a)
    return result.toIntArray()
}

fun convertingArrayElements(array: IntArray, converting: (Int) -> Int) {
    for (a in array.indices) array[a] = converting(array[a])
}

