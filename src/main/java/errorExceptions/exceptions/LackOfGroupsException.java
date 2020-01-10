package errorExceptions.exceptions;

public class LackOfGroupsException extends Exception {
    public LackOfGroupsException(String groupName) {
        super(groupName + " should have at least one group");
    }


}
