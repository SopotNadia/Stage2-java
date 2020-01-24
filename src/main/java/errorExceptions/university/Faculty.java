package errorExceptions.university;

import errorExceptions.exceptions.LackOfGroupsException;
import errorExceptions.exceptions.SubjectDoesnotExistException;

import java.util.ArrayList;

public class Faculty extends Entity {
    private ArrayList<Group> groupsList = new ArrayList<>();

    public Faculty(String facultyName) {
        super(facultyName);
    }

    public ArrayList<Group> getGroupsList() {
        return groupsList;
    }

    public void addGroupIntoList(Group group) {
        groupsList.add(group);
    }

    /**
     * Calculate an average mark of subject for any faculty
     * @param subject
     * @return average mark of subject
     * @throws LackOfGroupsException
     * @throws SubjectDoesnotExistException
     */
    public double getAverageMarkOfSubjectForParticularFaculty(Subject subject) throws LackOfGroupsException, SubjectDoesnotExistException {
        double averageMark;
        int counter = 0;
        double sumForFaculty = 0;
        double sumForGroup;
        if (groupsList.isEmpty()) {
            throw new LackOfGroupsException(this.getName() + "should have at least one group");
        }
        for (Group group : groupsList) {
            sumForGroup = 0;
            for (Student student : group.getStudentsList()) {
                if (student.getMarks().containsKey(subject.getNameSubject())) {
                    sumForGroup = sumForGroup + student.getMarks().get(subject.getNameSubject());
                    counter++;
                }
            }
            sumForFaculty = sumForFaculty + sumForGroup;
        }
        if (counter == 0) {
            throw new SubjectDoesnotExistException("Students don't study " + subject.getNameSubject() + " in this faculty");
        }
        averageMark = sumForFaculty / counter;
        return averageMark;
    }

}
