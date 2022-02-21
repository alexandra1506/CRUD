package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        // Create

        if(args[0].equals("-c")){
            if(args[2].equals("м")){
                try {
                    Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(args[3]);
                    allPeople.add(Person.createMale(args[1] , date1));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            } else if(args[2].equals("ж")){
                try {
                    Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(args[3]);
                    allPeople.add(Person.createFemale(args[1] , date1));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(allPeople.size()-1);
        }

        // Read

        if(args[0].equals("-r")){
            Person person = allPeople.get(Integer.parseInt(args[1]));
            System.out.println(person.getName());

            if(person.getSex() == Sex.MALE) {
                System.out.println("м");
            } else if (person.getSex() == Sex.FEMALE)
                System.out.println("ж");


            System.out.println(new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).
                    format(person.getBirthDate()));
        }

        // Update
        if(args[0].equals("-u")){
            allPeople.get(Integer.parseInt(args[1])).setName(args[2]);

            if(args[3].equals("м")) {
                allPeople.get(Integer.parseInt(args[1])).setSex(Sex.MALE);
            } else if (args[3].equals("ж")) {
                allPeople.get(Integer.parseInt(args[1])).setSex(Sex.FEMALE);
            }

            try {
                Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(args[4]);
                allPeople.get(Integer.parseInt(args[1])).setBirthDate(date1);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        // Delete
        if(args[0].equals("-d")){
            allPeople.get(Integer.parseInt(args[1])).setName(null);
            allPeople.get(Integer.parseInt(args[1])).setSex(null);
            allPeople.get(Integer.parseInt(args[1])).setBirthDate(null);
        }
    }
}
