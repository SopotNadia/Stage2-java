package service;

import model.TestModel;

public class TestModelCreator {
    private static final String NUMBER_OF_INSTANCES = "number.instances";
    private static final String MACHINE_TYPE = "machine.type";
    private static final String EXPECTED_RESULT = "expected.result";

    public static TestModel withCredentialsFromProperty() {
        return new TestModel(ConfigurationReader.getValue(NUMBER_OF_INSTANCES), ConfigurationReader.getValue(MACHINE_TYPE), ConfigurationReader.getValue(EXPECTED_RESULT));
    }
}
