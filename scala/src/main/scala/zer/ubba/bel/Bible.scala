package zer.ubba.bel

import scala.io.Source.fromResource

class Bible {
  private val boringWords = ("the,and,of,to,that,for,in,i,his,a,with,it,be,is,not,they,thou")
    .split(",")

  def readTheBible(): Map[String, Int] = {
    val source = fromResource("bible.txt")

    source
      .getLines                         // read all lines
      .flatMap(_ split " ")             // split into words
      .filter(_ matches """^\w+""")     // filter out words without characters
      .map(_.toLowerCase)               // convert to lowercase
      .filter(!boringWords.contains(_)) // filter out boring words
      .toList
      .groupBy(identity)                // group by word and count
      .mapValues(_.size)
  }
}
