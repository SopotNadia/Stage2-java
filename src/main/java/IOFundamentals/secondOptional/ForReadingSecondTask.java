package IOFundamentals.secondOptional;

import java.util.GregorianCalendar;

public class ForReadingSecondTask {
    private String firstName;
    private String secondName;
    private String patronymic;
    private int id;
    private GregorianCalendar birthDay;
    private String address;
    private String phoneNumber;
    private int course;
    private String group;

    public ForReadingSecondTask(String firstName, String secondName, String patronymic, int id, GregorianCalendar birthDay, String address,
                                String phoneNumber, int course, String group) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.id = id;
        this.birthDay = birthDay;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.course = course;
        this.group = group;
    }

    public ForReadingSecondTask(String firstName, String secondName, GregorianCalendar birthDay, int course, String group) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthDay = birthDay;
        this.course = course;
        this.group = group;
    }

    public int getCourse() {
        return course;
    }

    public GregorianCalendar getBirthDay() {
        return birthDay;
    }

    public String getGroup() {
        return group;
    }

    public String toString() {
        return "Second name - " + secondName + ", \tfirst name - " + firstName;
    }

}
