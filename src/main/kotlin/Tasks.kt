import java.util.*

fun main() {
}


//task 1
fun isPalindrome(text: String): Boolean = text.reversed().equals(text, ignoreCase = true)

//task1
fun isPalindromeWithForLoop(text: String): Boolean {
    val temp = StringBuilder()
    for (i in text.length - 1 downTo 0) {
        temp.append(text[i])
    }
    return text.equals(temp.toString(), ignoreCase = true)
}

//task 2
fun minSplit(amount: Int): Int {
    var tempAmount = amount
    var quantity = 0
    val coinList = listOf(50, 20, 10, 5, 1)
    var count = 0
    while (true) {
        if (tempAmount <= 0) {
            break
        }
        if (tempAmount < coinList[count]) {
            count++
            continue
        }
        quantity += tempAmount / coinList[count]
        tempAmount %= coinList[count]
    }
    return quantity
}

//task 3
fun notContains(array: IntArray): Int {
    var min = array[0]
    for (i in array.indices) {
        if (min < array[i] || array[i] <= 0) {
            continue
        } else {
            min = array[i]
        }
    }
    min -= 1
    return if (min != 0) {
        min
    } else {
        throw IllegalArgumentException(
            "Digit 1 is not provided in the terms of the assignment"
        )
    }
}

//task 3
fun notContainsWithMinMethod(array: IntArray): Int {
    val min = array.minOrNull()!!.toInt() - 1
    if (min < 1) {
        throw IllegalArgumentException(
            "Digit 1 is not provided in the terms of the assignment"
        )
    } else {
        return min
    }
}


//task 4
fun isProperly(sequence: String): Boolean {
    var matched = 0
    for (char in sequence) {
        when (char) {
            '(' -> matched++
            ')' -> matched--
            else -> throw IllegalArgumentException(
                "The string must consist only of parentheses"
            )
        }
        if (matched < 0) return false
    }
    return matched == 0
}


//task 5
fun countVariants(stearsCount: Int): Int {
    fun fib(n: Int): Int {
        return if (n <= 1) n else fib(n - 1) + fib(n - 2)
    }
    return fib(stearsCount + 1)
}

//task 6
class MyDataStructure<T> {
    var array: ArrayList<T> = ArrayList()
    var hashMap: HashMap<T, Int?> = hashMapOf()

    fun add(element: T) {
        if (hashMap[element] != null) return
        val size = array.size
        array.add(element)
        hashMap[element] = size
    }
    fun remove(element: T) {
        val index: Int = hashMap[element] ?: return
        val last = array[array.size - 1]

        array[index] = last
        array.removeAt(array.size - 1)

        hashMap[last] = index
        hashMap.remove(element)
    }

}

