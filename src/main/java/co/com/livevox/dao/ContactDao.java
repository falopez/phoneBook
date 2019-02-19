package co.com.livevox.dao;

import java.util.List;

import co.com.livevox.dto.ContactDTO;
import co.com.livevox.exception.ExceptionDao;

/**
 * Segregated interface that manages contacts in the the data access layer
 * @author Fabian Andres Lopez Galindez
 * @version 1.0
 * @since  Feb 11, 2019
 */

public interface ContactDao {
	
	/**
	 * Add a contact through
	 * @param contactDTO
	 * @throws ExceptionDao
	 */
	public String addContact(ContactDTO contactDTO) throws ExceptionDao;
	/**
	 * Search a contact 
	 * @param searchCriteria
	 * @return List<ContactDTO>
	 * @throws ExceptionDao
	 */
	public List<ContactDTO> SearchContact(String searchCriteria) throws ExceptionDao;
	/**
	 * List all contacts 
	 * @return List<ContactDTO>
	 * @throws ExceptionDao
	 */
	public List<ContactDTO> listContact() throws ExceptionDao;

}
