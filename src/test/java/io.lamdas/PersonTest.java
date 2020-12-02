package io.lamdas;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class PersonTest {
    Person person1 = new Person("John", LocalDate.parse("1989-06-23"), Person.Sex.MALE, "John@gmail.com");
    Person person2 = new Person("Brian", LocalDate.parse("1995-09-10"), Person.Sex.MALE, "Brian@gmail.com");
    Person person3 = new Person("Roger", LocalDate.parse("1989-07-10"), Person.Sex.MALE, "Roger@gmail.com");
    Person person4 = new Person("Cassie", LocalDate.parse("1993-09-30"), Person.Sex.FEMALE, "Cassie@gmail.com");
    Person person5 = new Person("Karen", LocalDate.parse("1988-03-05"), Person.Sex.FEMALE, "Karen@gmail.com");

    @Before
    public void setup(){
        Person.addPerson(person1);
        Person.addPerson(person2);
        Person.addPerson(person3);
        Person.addPerson(person4);
        Person.addPerson(person5);
    }

    @Test
    public void testPrintPersons1(){
        List<String> expectedList = new ArrayList<>(Arrays.asList("Cassie","Karen"));
        Person.printPersons1(Person.getRoster());
        Assert.assertEquals(Person.meetCriteria,expectedList);
    }

    @Test
    public void testPrintPersons2(){
        List<String> expectedList = new ArrayList<>(Arrays.asList("Cassie","Karen"));
        Person.printPersons2(Person.getRoster());
        Assert.assertEquals(Person.meetCriteria,expectedList);
    }

    @Test
    public void testPrintPersons3(){
        List<String> expectedList = new ArrayList<>(Arrays.asList("Cassie","Karen"));
        Person.printPersons3(Person.getRoster());
        Assert.assertEquals(Person.meetCriteria,expectedList);
    }
}
