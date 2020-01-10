package errorExceptions.university;

import errorExceptions.exceptions.FacultyDoesnotExistException;
import errorExceptions.exceptions.GroupDoesnotExistException;
import errorExceptions.exceptions.LackOfFacultiesException;

import java.util.ArrayList;

public class University extends Entity {
    private ArrayList<Faculty> facultiesList = new ArrayList<>();

    public University(String name) {
        super(name);
    }

    public void addFacultyIntoList(Faculty faculty) {
        facultiesList.add(faculty);
    }

    public Student getStudent(String studentName){
        for (Faculty faculty : facultiesList) {
            for (Group group : faculty.getGroupsList()) {
                for (Student student : group.getStudentsList()) {
                    if (studentName.toLowerCase().equals(student.getName().toLowerCase())) {
                        return student;
                    }
                }
            }
        }
        return null;
    }

    public Group getGroup(String groupName) throws GroupDoesnotExistException {
        Group returnedGroup = null;
        for (Faculty faculty : facultiesList) {
            for (Group group : faculty.getGroupsList()) {
                if (groupName.toLowerCase().equals(group.getName())) {
                    returnedGroup = group;
                }
            }
        }
        if (returnedGroup == null) {
            throw new GroupDoesnotExistException(groupName + " - this group doesn't exist at University");
        } else return returnedGroup;
    }

    public Faculty getFaculty(String facultyName) throws FacultyDoesnotExistException {
        Faculty returnedFaculty = null;
        for (Faculty faculty : facultiesList) {
            if (facultyName.toLowerCase().equals(faculty.getName().toLowerCase())) {
                returnedFaculty = faculty;
            }
        }
        if (returnedFaculty == null) {
            throw new FacultyDoesnotExistException(facultyName + " - this faculty doesn't exist at University");
        } else return returnedFaculty;
    }

    /**
     * @param subject
     * @return average mark of subject for University
     * @throws LackOfFacultiesException - if University doesn't have faculties
     */

    public double getAverageMarkOfSubjectForUniversity(Subject subject) throws LackOfFacultiesException {
        double averageMark = 0;
        int counter = 0;
        double sum = 0;
        double sumForGroup;
        double sumForFaculty;
        if (facultiesList.isEmpty()) {
            throw new LackOfFacultiesException(this.getName() + " should have faculties");
        }
        for (Faculty faculty : facultiesList) {
            sumForFaculty = 0;
            for (Group group : faculty.getGroupsList()) {
                sumForGroup = 0;
                for (Student student : group.getStudentsList()) {
                    if (student.getMarks().containsKey(subject.getNameSubject())) {
                        sumForGroup = sumForGroup + student.getMarks().get(subject.getNameSubject());
                        counter++;
                    }
                }
                sumForFaculty = sumForFaculty + sumForGroup;
            }
            sum = sum + sumForFaculty;
        }
        averageMark = sum / counter;
        return averageMark;
    }

}


