package database;

/**
 * @author Maibritt Bj�rn Jacobsen
 * @version 2021-05-28
 */

public class DataAccessException extends Exception {

	public DataAccessException(Exception e, String expl) {
		super(expl, e);
	}
}
