package homework.hw0407;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Test {

    public static void main(String[] args) throws IOException {
        File file = new File("articles.csv");

        BufferedReader reader = new BufferedReader(new FileReader(file));

        reader.lines().skip(1).map(Test::parse).
                filter(article -> article.containsTag("java"))
                .limit(1)
                .map(Article::toString)
                .forEach(System.out::println);
        String a = " ";


    }

    public static class Article {
        private String name;
        private String title;
        private List<String> TAGS;

        public Article(String name, String title, Optional<String[]> tags) {
            TAGS = new ArrayList<>();
            tags.ifPresent(strings -> this.TAGS.addAll(Arrays.asList(strings)));
            this.title = title;
            this.name = name;
        }

        public List<String> getTAGS() {
            return TAGS;
        }

        public void setTAGS(List<String> TAGS) {
            this.TAGS = TAGS;
        }

        public void addTAG(String newTag) {
            TAGS.add(newTag);
        }

        public boolean containsTag(String tag) {
            return TAGS.contains(tag);
        }

        @Override
        public String toString() {
            return "Article{" +
                    "name='" + name + '\'' +
                    ", title='" + title + '\'' +
                    ", TAGS=" + TAGS +
                    '}';
        }
    }

    private static Article parse(String line) {
        String[] data = line.split(";");
        String[] tags;
        try {
            tags = data[2].split(",");
        } catch (Exception e) {
            return new Article(data[0], data[1], Optional.empty());
        }
        return new Article(data[0], data[1], Optional.of(tags));
    }
}
