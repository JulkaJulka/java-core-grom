package lesson8.Student;

/**
 * Created by user on 18.05.2017.
 */
public class Demo {

    Student createHighestParent() {

        Course[] courses = {};
        Student student1 = new Student("Jack", "Ivanov", 41, courses);
        return student1;
    }

    SpecialStudent createLowestChild() {

        Course[] coursesTaken = {};
        SpecialStudent specialStudent = new SpecialStudent("Taras", "Petrov", 41, coursesTaken, 53473,
                "taras@gmail.com");

        return specialStudent;
    }

}
