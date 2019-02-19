package co.com.livevox.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.com.livevox.dto.ContactDTO;

/**
 * Concrete class that offers functionalities transversal to the application
 * @author Fabian Andres Lopez Galindez
 * @version 1.0
 * @since  Feb 11, 2019
 */

public class Util {

	/**
	 * Validate that the object has all the data
	 * @param contactDTO
	 * @return
	 */
	public static boolean validateContactDTO(ContactDTO contactDTO) {
		return contactDTO.getFirstName() != null && !contactDTO.getFirstName().equalsIgnoreCase(Constans.VACIO)
				&& contactDTO.getLastName() != null && !contactDTO.getLastName().equalsIgnoreCase(Constans.VACIO)
				&& contactDTO.getPhone() != null && !contactDTO.getPhone().equalsIgnoreCase(Constans.VACIO);
	}

	/**
	 * Create an object of ContactDTO class
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public static ContactDTO createContactDTO(ResultSet rs) throws SQLException {
		return new ContactDTO(rs.getString(Constans.FIRST_NAME), rs.getString(Constans.LAST_NAME),
				rs.getString(Constans.PHONE));
	}

}
