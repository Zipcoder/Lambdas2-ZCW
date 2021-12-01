package com.zipcode.lamda;

import java.time.LocalDate;
import java.util.List;

public class Person {

    public enum Sex {
        MALE,FEMALE;
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public Person(String name,LocalDate birthday, Sex gender,String emailAddress){
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getAge(){
        LocalDate today = LocalDate.now();
        return today.compareTo(this.birthday);
    }

    public void printPersonsOlderThan(List<Person> roster, int age){
        for(Person p: roster){
            if (p.getAge() >= age){
                p.printPerson();
            }
        }
    }

    public boolean printPerson(){
        if (getAge() > 10 && gender == Person.Sex.FEMALE) {
            return true;
        }
        return false;


    }

}
