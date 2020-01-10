package errorExceptions.exceptions;


public class LackOfStudentsException extends Exception {
    private String groupName;

    public LackOfStudentsException(String groupName, String description) {
        super(description);
        this.groupName = groupName;
    }

    @Override
    public String getMessage() {
        return String.format("Group %s %s", groupName, super.getMessage());
    }
}
