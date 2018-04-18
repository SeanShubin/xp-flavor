package com.seanshubin.xp.flavor

import java.util.*

fun main(args: Array<String>) {
    //18
    val seed = 18L
    val random = Random(seed)
    val randomInt: (Int) -> Int = { bound ->
        random.nextInt(bound)
    }
    val sample = Sample(randomInt)
    sample.sampleLines().forEach { println(it) }
}
