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

public class JavaBible {
    private final List<String> boringWords = List.of(("the,and,of,to,that,for,in,i,his,a,with,it,be,is,not,they,thou")
            .split(","));

    Map<String, Long> readTheBible() throws Exception {
        final var path = Paths.get(getSystemResource("bible.txt").toURI());

        return Files.lines(path)
                .flatMap(line -> stream(line.split(" ")))
                .filter(Pattern.compile("^\\w+").asMatchPredicate())
                .map(String::toLowerCase)
                .filter(word -> !boringWords.contains(word))
                .collect(groupingBy(identity(), counting()));
    }
}
