package zer.ubba.bel

import scala.io.Source.fromResource

class ScalaBible {
  private val boringWords = ("the,and,of,to,that,for,in,i,his,a,with,it,be,is,not,they,thou")
    .split(",")

  def readTheBible(): Map[String, Int] = {
    val source = fromResource("bible.txt")

    source
      .getLines
      .flatMap(_ split " ")
      .filter(_ matches """^\w+""")
      .map(_.toLowerCase)
      .filter(!boringWords.contains(_))
      .toList
      .groupBy(identity)
      .mapValues(_.size)
  }
}
