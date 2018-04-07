package Lessons;

import java.io.*;
import java.util.Optional;

public class StreamApi {

    public static void main(String[] args) throws IOException {
        File file = new File("test.csv");

        BufferedReader reader = new BufferedReader(new FileReader(file));

        reader.lines().skip(1).map(StreamApi::parse).
                filter(Optional::isPresent)
                .filter(entity -> entity.get().peopleCount > 100)
                .limit(20)
                .map(entity -> entity.get().setName(entity.get().name.toUpperCase()))
                .forEach(System.out::println);

    }

    public static Optional<Entity> parse(String line) {
        String[] lines = line.split(";");
        Optional<Entity> optionalEntity;
        try {
            optionalEntity = Optional.of(new Entity(
                    Integer.parseInt(lines[0]),
                    lines[1],
                    lines[2],
                    lines[3],
                    lines[4],
                    Integer.parseInt(lines[5])
            ));
        } catch (Exception e) {
            return Optional.empty();
        }
        return optionalEntity;
    }


    public static class Entity {
        private int id;
        private String name;
        private String meaning;
        private String gender;
        private String origin;
        private int peopleCount;



        public Entity(int id, String name, String meaning, String gender, String origin, int peopleCount) {
            this.id = id;
            this.name = name;
            this.meaning = meaning;
            this.gender = gender;
            this.origin = origin;
            this.peopleCount = peopleCount;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public Entity setName(String name) {
            this.name = name;
            return this;
        }

        public String getMeaning() {
            return meaning;
        }

        public void setMeaning(String meaning) {
            this.meaning = meaning;
        }

        public String isGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public int getPeopltCount() {
            return peopleCount;
        }

        public void setPeopltCount(int peopltCount) {
            this.peopleCount = peopltCount;
        }

        @Override
        public String toString() {
            return "Entity{" +
                    "name='" + name + '\'' +
                    ", meaning='" + meaning + '\'' +
                    ", gender='" + gender + '\'' +
                    ", origin='" + origin + '\'' +
                    ", peopleCount=" + peopleCount +
                    '}';
        }
    }

}