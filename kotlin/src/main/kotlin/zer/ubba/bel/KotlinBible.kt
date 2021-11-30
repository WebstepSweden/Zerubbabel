package zer.ubba.bel

import java.io.File
import java.lang.ClassLoader.getSystemResource
import java.util.Locale

private val boringWords = ("the,and,of,to,that,for,in,i,his,a,with,it,be,is,not,they,thou")
    .split(",")

fun readTheBible(): Map<String, Int> {
    val file = File(getSystemResource("bible.txt").file)

    return file
        .readLines()
        .flatMap { it.split(" ") }
        .filter { """^\w+""".toRegex().matches(it) }
        .map { it.lowercase(Locale.getDefault()) }
        .filter { !boringWords.contains(it) }
        .groupingBy { it }.eachCount()
}