package dao;

public class DAOException extends Exception {

	public DAOException() {
		super();
		System.out.println("DAO!!!!!!!!!!!!!");
	}

	public DAOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		System.out.println("Dao: "+message);
		
	}

	public DAOException(String message, Throwable cause) {
		super(message, cause);
		System.out.println(message);
		
	}

	public DAOException(String message) {
		super(message);
		System.out.println("Dao: "+message);
		// TODO Auto-generated constructor stub
	}

	public DAOException(Throwable cause) {
		super(cause);
		System.out.println("DAO!!!!!!!!");
		
	}

}
