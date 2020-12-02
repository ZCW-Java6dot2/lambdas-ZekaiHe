package io.lamdas;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Person {
    public enum Sex {
        MALE, FEMALE
    }
    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public static ArrayList<Person> roster = new ArrayList<>();
    public static ArrayList<String> meetCriteria = new ArrayList<>();

    public Person(String name, LocalDate birthday, Sex gender, String emailAddress){
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    public static ArrayList<Person> getRoster(){
        return roster;
    }

    public static void addPerson(Person person){
        roster.add(person);
    }

    public String getName(){
        return this.name;
    }

    public int getAge() {
        LocalDate date = LocalDate.now();
        Long days = birthday.until(date, ChronoUnit.DAYS);
        return (int)Math.floorDiv(days,365);
    }

    public Sex getGender(){
        return this.gender;
    }

    public static void printPerson(Person p){
        meetCriteria.add(p.getName());
    }

    interface CheckPerson{
        boolean test(Person p);
    }


    //local class method: approach 1
    public static void printPersons1(ArrayList<Person> roster) {

       class SearchCriteria implements CheckPerson { //local class inside a method which implements interface CheckPerson
            @Override
            public boolean test(Person p) {
                return p.getAge() > 21 && p.getGender() == Sex.FEMALE; //clubbing bouncer criteria
            }
        }

        SearchCriteria tester = new SearchCriteria(); //instantiated local class to be used in operations below

        for (Person p : roster) {
            if (tester.test(p)) { //using class "SearchCriteria" instantiated above which implements the CheckPerson interface to conditionally filter out people in roster
                printPerson(p);
            }
        }
    }

    //anonymous class method: approach 2
    public static void printPersons2(ArrayList<Person> roster) {

        CheckPerson tester = new CheckPerson() { //instead of creating a new class to implement the interface, create an anonymous class (no name) which "implements" the interface
            @Override
            public boolean test(Person p) {
                return p.getAge() > 21 && p.getGender() == Sex.FEMALE; //clubbing bouncer criteria
            }
        };

        for (Person p : roster) {
            if (tester.test(p)) {
                printPerson(p);
            }
        }
    }

    //Lambda expression method: approach 3
    public static void printPersons3(ArrayList<Person> roster) {

        CheckPerson tester = p -> { //p is the parameter you are passing into the method in approach 1 and 2
            return p.getAge() > 21 && p.getGender() == Sex.FEMALE; //clubbing bouncer criteria
        };

        for (Person p : roster) {
            if (tester.test(p)) {
                printPerson(p);
            }
        }
    }

}

