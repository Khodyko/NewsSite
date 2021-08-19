package dao;

public class DAOException extends Exception {
	private static final long serialVersionUID = 1L;

	public DAOException() {
		super();
		System.out.println("DAOException");
	}

	public DAOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		System.out.println("DaoException : "+message);
		
	}

	public DAOException(String message, Throwable cause) {
		super(message, cause);
		System.out.println(message);
		
	}

	public DAOException(String message) {
		super(message);
		System.out.println("DaoException : "+message);
	}

	public DAOException(Throwable cause) {
		super(cause);
		System.out.println("DAOException");
		
	}

}
