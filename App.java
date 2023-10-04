import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        PeopleReader reader = new PeopleReader("people.txt");
        List<Person> people = reader.getAllPeople();

        for (Person p : people) {
            System.out.println(p);
        }
    }
}