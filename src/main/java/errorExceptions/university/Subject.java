package errorExceptions.university;

import errorExceptions.exceptions.SubjectDoesnotExistException;

import java.util.ArrayList;

public class Subject {
    private String nameSubject;
    private static ArrayList<Subject> subjectsList = new ArrayList<>();

    public Subject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void addSubjectIntoList(Subject subject) {
        subjectsList.add(subject);
    }

    public static Subject getSubject(String nameSubject) throws SubjectDoesnotExistException {
        Subject returnedSubject;
        for (Subject subject : subjectsList) {
            if (subject.getNameSubject().toLowerCase().equals(nameSubject.toLowerCase())) {
                returnedSubject = subject;
                return returnedSubject;
            }
        }
        throw new SubjectDoesnotExistException(nameSubject + " doesn't exist");
    }

    @Override
    public String toString() {
        return nameSubject;
    }
}
