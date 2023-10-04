import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.*;

public class App {
    public static void main(String[] args) throws IOException {
        PeopleReader reader = new PeopleReader("people.txt");
        List<Person> people = reader.getAllPeople();
        List<Person> peoplePerFear = new ArrayList<Person>();

        // for (Person p : people) {
        //     System.out.println(p);
        // }

        Map<String, List<Person>> fearMap = groupByFear(people);
        System.out.println(fearMap);
        
        for (String fear: fearMap.keySet()){
            System.out.println(fear);
            peoplePerFear = fearMap.get(fear);
            for (Person p : peoplePerFear){
                System.out.println(p);

            }
            


        }
        
        
    }


    public static Map<String, List<Person>> groupByFear(List<Person> people) {
    // ...
        Map<String, List<Person>> fearMap = new HashMap<String, List<Person>>();
        List<Person> peoplePerFear = new ArrayList<Person>();
        for (Person p : people){
            String fear = p.getFear();
            //System.out.println("Current fear:" + fear);
            if(fearMap.containsKey(fear)){
                peoplePerFear = fearMap.get(fear);
                peoplePerFear.add(p);
                fearMap.put(fear, peoplePerFear);
                
            }
            else{
                peoplePerFear.add(p);
                fearMap.put(fear, peoplePerFear);
                
            }
            //peoplePerFear.clear();
        }


        return fearMap;
}
}