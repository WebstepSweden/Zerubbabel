package zer.ubba.bel

import java.io.File
import java.lang.ClassLoader.getSystemResource
import java.util.Locale

private val boringWords = ("the,and,of,to,that,for,in,i,his,a,with,it,be,is,not,they,thou")
    .split(",")

fun readTheBible(): Map<String, Int> {
    val file = File(getSystemResource("bible.txt").file)

    return file
        .readLines()                                    // read all lines
        .flatMap { it.split(" ") }            // split into words
        .filter { """^\w+""".toRegex().matches(it) }    // filter out words without characters
        .map { it.lowercase(Locale.getDefault()) }      // convert to lowercase
        .filter { !boringWords.contains(it) }           // filter out boring words
        .groupingBy { it }.eachCount()                  // group by word and count
}