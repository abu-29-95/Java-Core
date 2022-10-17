package Lesson9;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Course> courses =new ArrayList<>();
        courses.add(new Course("Основы ручного тестирования"));
        courses.add(new Course ("Основы Веб тестирования"));
        courses.add(new Course("Java. Level-1"));
        courses.add(new Course("Java core"));
        courses.add(new Course("База данных"));

        List<Student> students = getListOfStydent(courses);


         students.stream().flatMap(student -> student.getAllCourses().stream()).collect(Collectors.toSet()).forEach(course ->
                 System.out.println(course.getCourseName()));
        System.out.println("+++++++++++++++++++");


        students.stream().sorted((student1, student2) -> student1.getAllCourses().size() - student2.getAllCourses().size())
                .limit(3).collect(Collectors.toList()).forEach(student -> System.out.println(student.getName()));
        System.out.println("+++++++++++++++++++");

        Course course4 = new Course(courses.get(4).getCourseName());
        students.stream().filter(student -> student.getAllCourses().contains(course4))
                .collect(Collectors.toList()).forEach(student -> System.out.println(student.getName()));




    }
    private static List<Student> getListOfStydent(List<Course> courses) {
        List<Student> studentList = new ArrayList<>();
        Faker faker = new Faker();
        Random randomCourse = new Random();
        for (int i = 0; i < 75; i++) {
            List<Course> courseList = new ArrayList<>();
            for (int j = 0; j < randomCourse.nextInt(6); j++) courseList.add(courses.get(j));
            studentList.add(new Student(faker.name().fullName(), courseList));
        }
        return studentList;
    }
}
