package Lesson4;


import java.util.*;
import java.util.stream.Collectors;

public class Main {
     static String [] str = {"football","basketball","volleyball","handball","baseball","golf","golf","football",
            "tennis","basketball","basketball"};
    static List<String> stringArrayList = Arrays.asList(str);

    public static void main(String[] args) {

        /*HashSet<String> stringHashSet = new HashSet<>();
        for (int i = 0; i < str.length; i++) {
            stringHashSet.add(str[i]);
        }
        System.out.println(stringHashSet);


        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        for (String s : stringHashSet) {
            stringIntegerHashMap.put(s, count(s));
        }
        System.out.println(stringIntegerHashMap);*/

        Phonebook phonebook = new Phonebook();
        phonebook.add("+700 111 55 44","Ivanov");
        phonebook.add("+788 887 22 33", "Vladov");
        phonebook.add("+900 222 45 22","Ivanov");
        System.out.println(phonebook.getNumber("Ivanov"));




    }

    public static Integer count(String str) {
        Integer sum=0;
        for (String s: stringArrayList){
            if(s.equals(str)) sum++;
        }
        return sum;
    }


    public static  class Phonebook  {

        private HashMap<String,String> phonebook = new HashMap<>();

        public void add(String number ,String surname) {
            phonebook.put(number,surname);

        }

        public String getNumber (String surname) {
            if(phonebook.containsValue(surname)){
                String res = "phone number: ";
                for (String s: phonebook.keySet()){
                    if (phonebook.get(s).equals(surname)) res+=s+" ;";
                }
                return res;
            }
            return "False";
        }

    }

    }






