/*
--- Created by Opalev Yakov ---
Algorithmic exercise.
We have to maximize treasures by using next rules:
- first values we get the whole
- getting next value at once with previous we get a half of value and next too
- to get the number entirely, we must miss one
Input:
    treasures - Array of Int numbers
    treasures[i] - treasures in i day, i - day number
    0 < length(treasures) < 100
    0 < treasures[i] < 100
Output:
    Double - number of maximum treasures
 */

import kotlin.random.Random
import kotlin.system.measureTimeMillis

fun main() {
    testExecTime()
}

fun run() {
    // input
    val str = "20 22 20 22 20"
    val arr = str.split(' ').map { it.toInt() }.toTypedArray()
    //val array = arrayOf(20, 21, 20, 21, 20)  // or another input
    //println(getMaxTreasures(generateTreasures(10)))  // or generate an array
    println(getMaxTreasures(arr))
}

fun testExecTime() {
    val elapsedTime = measureTimeMillis {
        run()
    }
    println("The code took to execute $elapsedTime ms")
}

fun generateTreasures(size: Int): Array<Int> {
    require(size > 0)
    return Array(size) { i -> Random.nextInt(0, 100) }
}

fun getMaxTreasures(arr: Array<Int>): Double {
    // array must be not empty
    require(arr.isNotEmpty())

    var res = 0.0

    if (arr.size < 2) {
        // special case when array element less than 3
        res = arr[0].toDouble()
    } else {
        var id = 0  // current id of array passing

        while (id < arr.size - 1) {
            // if we have two last values
            if (id + 2 == arr.size) {
                // handle two last values
                if (id == 0) {
                    // if we have first elements
                    if (arr[id] + arr[id + 1] / 2.0 > arr[id + 1]) res += arr[id] + arr[id + 1] / 2.0
                    else res += arr[id + 1]
                } else {
                    if ((arr[id] + arr[id + 1]) / 2.0 > arr[id + 1]) res += (arr[id] + arr[id + 1]) / 2.0
                    else res += arr[id + 1]
                }
                break
            } else {
                // check which of algorithm we must use
                if (arr[id] >= arr[id + 1]) {
                    do {
                        if (id == 0) res += arr[id]
                        else res += arr[id] / 2.0
                        id++
                    } while (id + 2 != arr.size && arr[id] > arr[id + 1])
                } else {
                    // if all next values greater than previous
                    val lastId = id++

                    // find all next greater values and stop when found smaller
                    while (id + 1 != arr.size && arr[id] <= arr[id + 1]) {
                        id++
                    }

                    for (i in 0..id - lastId step 2) {
                        res += arr[id - i]
                    }

                    when {
                        // if there are two last values
                        id == arr.size - 2 -> {
                            res += arr[id + 1] / 2.0
                            break
                        }
                        // if there is one last value
                        id >= arr.size - 1 -> break
                    }

                    id++
                }
            }
        }
    }

    return res
}