package errorExceptions.university;

import errorExceptions.exceptions.LackOfSubjectException;

import java.util.HashMap;
import java.util.Map;

public class Student extends Entity {
    private Map<String, Integer> marks = new HashMap<>();

    public Student(String name) {
        super(name);
    }

    public Map<String, Integer> getMarks() {
        return marks;
    }

    //Посчитать средний балл по всем предметам студента
    //Оценка ниже 0 или выше 10
    //Отсутсвие предметов у студента (должен быть хотя бы один)

    public void addMarksAndSubjects(Subject subject, Integer mark){
        if (mark < 0 || mark > 10) {
            System.out.println("For " + this.getName() + ": " + mark + " is out of allowed values(0-10)");
        } else marks.put(subject.getNameSubject(), mark);
    }

    public double getAverageMarkOfAllSubjectsForStudent() throws LackOfSubjectException {
        double averageMark;
        double sum = 0;
        if (!marks.isEmpty()) {
            for (Integer mark : marks.values()) {
                sum += mark;
            }
            averageMark = sum / marks.values().size();
        } else throw new LackOfSubjectException(this.getName() + " has to have at least one subject");
        return averageMark;
    }


}
