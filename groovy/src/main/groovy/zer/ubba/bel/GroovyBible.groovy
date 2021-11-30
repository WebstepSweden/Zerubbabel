package zer.ubba.bel

class GroovyBible {
    private final def boringWords = "the,and,of,to,that,for,in,i,his,a,with,it,be,is,not,they,thou"
            .split(",");

    def readTheBible() {
        def resource = ClassLoader.getSystemResource("bible.txt")

        return resource
                .readLines()
                .collect { it.split(" ") }
                .flatten()
                .collect { it.toString() }
                .findAll { it.matches("^\\w+") }
                .collect { it.toLowerCase() }
                .findAll { !boringWords.contains(it) }
                .countBy { it }
    }
}
