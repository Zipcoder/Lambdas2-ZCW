package com.zipcode.lamda;

public class LambdaExp {
    public static CheckPerson tester;
    //Static block is used for initializing the static variables
    static { tester = (p)->p.getAge() > 4 && p.getGender()== Person.Sex.FEMALE;}

    public CheckPerson getLambda(){
        return tester;
    }

}
