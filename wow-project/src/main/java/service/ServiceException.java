package service;

public class ServiceException extends Exception {
	private static final long serialVersionUID = -5582152432927044124L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
		System.out.println("Service: "+message);
	}

	public ServiceException(Exception e) {
		super(e);
	}

	public ServiceException(String message, Exception e) {
		super(message, e);
		System.out.println("Service: "+message);
	}

}
