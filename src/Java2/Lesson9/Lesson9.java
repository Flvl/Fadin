package Lesson9;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Lesson9 {

    public static void main(String[] args)  throws IOException {

        Course java=new Course("Java");
        Course javaCore=new Course("JavaCore");
        Course designUi=new Course("Design UI");
        Course designUx=new Course("Design UX");
        Course sql=new Course("SQL");
        Course linux=new Course("Linux");
        Course git=new Course("Git");


        Student student1=new Student("Ivanov",new ArrayList<Course>(Arrays.asList(java,javaCore)));
        Student student2=new Student("Petrov",new ArrayList<Course>(Arrays.asList(designUi,designUx)));
        Student student3=new Student("Sidorov",new ArrayList<Course>(Arrays.asList(sql,linux,git)));
        Student student4=new Student("Makarova",new ArrayList<Course>(Arrays.asList(designUi,designUx,git)));
        Student student5=new Student("Nikolaev",new ArrayList<Course>(Arrays.asList(java,javaCore,git,sql)));

        List<Student> AllStudents= new ArrayList<Student>(Arrays.asList(student1,student2,student3,student4,student5));



        stream1(AllStudents).forEach(System.out::println);

        stream2(AllStudents).forEach(System.out::println);
        stream3(AllStudents,java).forEach(System.out::println);



    }

    static Stream <String> stream1 (List<Student> students) {

        System.out.println("Курсы, которые проходят студенты: ");
        return students.stream()
        .map(courses->courses.getAllCourses())
                .flatMap(i->i.stream())
                .map(course->course.getName())
                .distinct();
    }
    static Stream <String> stream2 (List<Student> students) {

        System.out.println("Самые любознательные студенты: ");
        return students.stream()
        .sorted(((o1, o2) -> o2.getAllCourses().size()-o1.getAllCourses().size()))
                .map(stud->stud.getName())
                .limit(3);
    }

    static Stream <String> stream3 (List<Student> students, Course course) {

        System.out.println("Студенты, которы епроходят курс: "+ course.getName());
        return students.stream()
                .filter(stud -> stud.getAllCourses().contains(course))
                .map(stud->stud.getName());
    }
}
