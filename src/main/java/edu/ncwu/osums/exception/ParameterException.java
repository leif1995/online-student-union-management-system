package edu.ncwu.osums.exception;

import java.util.HashMap;
import java.util.Map;

public class ParameterException extends Exception {
    private static final long serialVersionUID = 1L;
    Map<String, String> parameterErrorField = new HashMap<String, String>();

    public Map<String, String> getParameterErrorField() {
        return parameterErrorField;
    }

    public void setParameterErrorField(Map<String, String> parameterErrorField) {
        this.parameterErrorField = parameterErrorField;
    }

    public void addToParameterErrorField(String parameterErrorName, String parameterErrorMessage) {
        parameterErrorField.put(parameterErrorName, parameterErrorMessage);
    }

    public boolean hasParameterError() {
        return !parameterErrorField.isEmpty();
    }
}
