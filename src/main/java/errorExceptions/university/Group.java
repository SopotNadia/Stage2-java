package errorExceptions.university;

import errorExceptions.exceptions.LackOfStudentsException;
import errorExceptions.exceptions.SubjectDoesnotExistException;

import java.util.ArrayList;

public class Group extends Entity {
    private ArrayList<Student> studentsList = new ArrayList<>();

    public Group(String groupNumber) {
        super(groupNumber);
    }

    public ArrayList<Student> getStudentsList() {
        return studentsList;
    }

    public void addStudentIntoList(Student student) {
        studentsList.add(student);
    }

    public double getAverageMarkOfSubjectInParticularGroup(Subject subject) throws LackOfStudentsException, SubjectDoesnotExistException {
        double averageMark;
        int counter = 0;
        double sum = 0;
        if (studentsList.isEmpty()) {
            throw new LackOfStudentsException(this.getName(), "should have students");
        }
        for (Student student : studentsList) {
            if (student.getMarks().containsKey(subject.getNameSubject())) {
                sum = sum + student.getMarks().get(subject.getNameSubject());
                counter++;
            }
        }
        if (counter == 0) {
            throw new SubjectDoesnotExistException("Students don't study " + subject.getNameSubject() + " in this group");
        }
        averageMark = sum / counter;
        return averageMark;
    }


}
