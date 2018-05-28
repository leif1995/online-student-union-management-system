package edu.ncwu.osums.exception;

public class ServiceException extends Exception {
    private static final long serialVersionUID = 1L;
    private String serviceErrorMessage;

    public String getServiceErrorMessage() {
        return serviceErrorMessage;
    }

    public void setServiceErrorMessage(String serviceErrorMessage) {
        this.serviceErrorMessage = serviceErrorMessage;
    }

    public ServiceException(String serviceErrorMessage) {
        this.serviceErrorMessage = serviceErrorMessage;
    }
}
