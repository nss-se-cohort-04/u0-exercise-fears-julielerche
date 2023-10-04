
public class Person {
    private final String firstName;
    private final String lastName;
    private final String middleName;
    private int age;
    private final String fear;

    public Person(String line) {
        boolean hasMiddleName = true;
        int findSpace = line.indexOf(" ");
        String firstName = line.substring(0, findSpace);
        this.firstName = firstName;

        int lastSpace = findSpace+1;
        findSpace = line.indexOf(" ", lastSpace);
        String secondName = line.substring(lastSpace, findSpace);
        lastSpace = findSpace+1;

        findSpace = line.indexOf(" ", lastSpace);
        String thirdWord = line.substring(lastSpace, findSpace);
        try {
            int a = Integer.parseInt(thirdWord);
            hasMiddleName = false;
        } catch (NumberFormatException nfe) {
            hasMiddleName = true;
        }
        
        lastSpace = findSpace+1;

        if(hasMiddleName){
            middleName = thirdWord;
            lastName = secondName;
            int findAge = line.indexOf(" ", lastSpace);
            String ageMiddle = line.substring(lastSpace, findAge);
            
            try {
            age = Integer.parseInt(ageMiddle);
        } catch (NumberFormatException nfe) {
            age = 0;
        }
            this.fear = line.substring(findAge+1);
        }
        else{
            lastName = secondName;
            middleName = "";
            int a = Integer.parseInt(thirdWord);
            this.age = a;
            this.fear = line.substring(lastSpace);

        }

        //String lastName = line.substring(firstSpace);
        //this.lastName = lastName;
        
        //this.middleName = " ";
        
        //this.age = age;
        //this.fear = fear;
        
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFear(){
        return fear;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge(){
        return age;
    }

    @Override
    public String toString() {
        return String.format("   %s %s (%s)", this.firstName, this.lastName, this.age);
    }
}