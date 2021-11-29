package zer.ubba.bel;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static java.lang.ClassLoader.getSystemResource;
import static java.util.Arrays.stream;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Bible {
    private final List<String> boringWords = List.of(("the,and,of,to,that,for,in,i,his,a,with,it,be,is,not,they,thou")
            .split(","));

    Map<String, Long> readTheBible() throws Exception {
        final var path = Paths.get(getSystemResource("bible.txt").toURI());

        return Files.lines(path)                                        // read all lines
                .flatMap(line -> stream(line.split(" ")))         // split into words
                .filter(Pattern.compile("^\\w+").asMatchPredicate())    // filter out words without characters
                .map(String::toLowerCase)                               // convert to lowercase
                .filter(word -> !boringWords.contains(word))            // filter out boring words
                .collect(groupingBy(identity(), counting()));           // group by word and count
    }
}
