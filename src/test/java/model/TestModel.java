package model;

public class TestModel {
    private String numberOfInstances;
    private String machineType;
    private String expectedResult;


    public TestModel(String numberOfInstances, String machineType, String expectedResult) {
        this.numberOfInstances = numberOfInstances;
        this.machineType = machineType;
        this.expectedResult = expectedResult;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public String getMachineType() {
        return machineType;
    }

    public String getExpectedResult() {
        return expectedResult;
    }
}
