import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PeopleReader {
    private final String filename;

    public PeopleReader(String filename) {
        this.filename = filename;
    }

    public List<Person> getAllPeople() throws IOException {
        List<Person> people = new ArrayList<>();

        List<String> lines = Files.readAllLines(Path.of(filename));
        for (String line : lines) {
            //String[] subStrings = line.split(" ");
            
            people.add(new Person(line));
            //people.add(new Person(subStrings[0], subStrings[2], subStrings[1], subStrings[3],subStrings[4]));
        }

        return people;
    }
}