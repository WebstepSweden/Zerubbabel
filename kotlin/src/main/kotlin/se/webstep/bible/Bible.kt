package se.webstep.bible

import java.io.File


private val boringWords = ("the,and,of,to,that,for,in,i,his,a,with,it,be,is,not,they,thou").split(",")

fun readTheBible(): Map<String, Int> {
    return File(ClassLoader.getSystemResource("bible.txt").file)
            .readLines()
            .flatMap { it.split(" ") }
            .filter { "^\\w+".toRegex().matches(it) }
            .map { it.toLowerCase() }
            .filter { !boringWords.contains(it) }
            .groupingBy { it }.eachCount()
}