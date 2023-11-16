package survivethewest;

import java.util.Random;

public class Person {
    private String firstName;
    private String lastName;
    private String gender;
    
    private static final String[] MALE_FIRST_NAMES = {"William","John","James","Charles","George","Thomas","Joseph","Henry","Robert",
    "Samuel","Benjamin","Edward","Frank","Walter","Albert","David","Johnathan","Alexander","Frederick","Arthur","Edwin","Alfred",
    "Eugene","Daniel","Lawrence","Louis","Oliver","Herbert","Lewis","Clarence","Ralph","Peter","Lester","Joel","Harvey","Horace",
    "Jesse","Oscar","Morris","Everett","Sidney","Clifford","Archibald","Ira","Floyd","Milton","Leonard","Guy","Roscoe","Warren"};
    private static final String[] FEMALE_FIRST_NAMES = {"Mary","Anna","Emma","Elizabeth","Margaret","Minnie","Ida","Clara",
    "Bertha","Alice","Annie","Florence","Bessie","Grace","Ethel","Sarah","Ella","Martha","Nellie","Maude","Mabel","Carrie","Edith",
    "Hattie","Mattie","Lillian","Ada","Louisa","Jessie","Lena","Catherine","Agnes","Rosa","Pearl","Edna","Myrtle","Hazel","Edwinna",
    "Gertrude","Lillie","Blanche","Eva","Daisy","Josephine","Baby-Doe","Nettie","Winifred","May","Viola"};
    private static final String[] LAST_NAMES = {"Smith","Johnson","Williams","Jones","Brown","Davis","Miller","Wilson","Moore",
    "Taylor","Anderson","Thomas","Jackson","White","Harris","Harrison","Martin","Thompson","Garcia","Martinez","Robinson",
    "Clark","Rodriguez","Lewis", "Lee","Walker","Hall","Allen","Young","Hernandez","King","Wright","Hill","Scott","Green",
    "Adams","Baker","Nelson","Carter","Garfield","Mitchell","Arthur","Pendleton","Perez","Roberts","Turner","Phillips",
    "Campbell","Cleveland","Parker","Evans","Edwards","Collins","Stewart","Folsun","Langtree","Bryan"};
    
    // Constructor
    public Person() {
        assignGender();
        assignName();
    }
    
    // Method to assign gender randomly
    private void assignGender() {
        Random random = new Random();
        int genderIndex = random.nextInt(2); // 0 for male, 1 for female
        gender = (genderIndex == 0) ? "man" : "woman";
    }
    
    // Method to assign names based on gender
    private void assignName() {
        Random random = new Random();
        if(gender.equals("man")) {
            // Generate a random index for male first names
            int firstNameIndex = random.nextInt(MALE_FIRST_NAMES.length);
            firstName = MALE_FIRST_NAMES[firstNameIndex];
        }
        else {
            // Generate a random index for female first names
            int firstNameIndex = random.nextInt(FEMALE_FIRST_NAMES.length);
            firstName = FEMALE_FIRST_NAMES[firstNameIndex];
        }
        
        // Generate a random index for last names
        int lastNameIndex = random.nextInt(LAST_NAMES.length);
        lastName = LAST_NAMES[lastNameIndex];
    }
    
    // Getters for first name, last name, and gender
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getGender() {
        return gender;
    }
}
