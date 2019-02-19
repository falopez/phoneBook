package co.com.livevox.bo;

import java.util.List;

import co.com.livevox.dto.ContactDTO;
import co.com.livevox.exception.ExceptionBO;

/**
 * Segregated interface that manages contacts in the business layer
 * @author Fabian Andres Lopez Galindez
 * @version 1.0
 * @since  Feb 11, 2019
 */

public interface ContactBO {
	
	/**
	 * Add a contact through the data access layer component
	 * @param contactDTO
	 * @throws ExceptionBO
	 */
	public void addContact(ContactDTO contactDTO) throws ExceptionBO;
	/**
	 * Search a contact through the data access layer component
	 * @param searchCriteria
	 * @return List<ContactDTO>
	 * @throws ExceptionBO
	 */
	public List<ContactDTO> SearchContact(String searchCriteria) throws ExceptionBO;
	/**
	 * List all contacts through the data access layer component
	 * @return List<ContactDTO>
	 * @throws ExceptionBO
	 */
	public List<ContactDTO> listContact() throws ExceptionBO;

}
