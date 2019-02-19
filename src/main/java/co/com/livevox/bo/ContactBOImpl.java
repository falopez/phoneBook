package co.com.livevox.bo;

import java.util.List;

import co.com.livevox.dao.ContactDao;
import co.com.livevox.dao.ContactDaoImpl;
import co.com.livevox.dto.ContactDTO;
import co.com.livevox.exception.ExceptionBO;
import co.com.livevox.exception.ExceptionDao;

/**
 * Concrete class that implements the capabilities offered by the segregated
 * interface (ContactBO) that manages contacts
 * @author Fabian Andres Lopez Galindez
 * @version 1.0
 * @since  Feb 11, 2019
 */

public class ContactBOImpl implements ContactBO {

	// Dependency layer access to data
	private ContactDao contactDao = new ContactDaoImpl();

	/**
	 * Save a contact through the component of the data access layer
	 * @param contactDTO
	 * @throws ExceptionBO
	 */
	@Override
	public void addContact(ContactDTO contactDTO) throws ExceptionBO {

		try {
			contactDao.addContact(contactDTO);
		} catch (ExceptionDao e) {
			throw new ExceptionBO(e.getMessage(), e.getCode());
		}
	}

	/**
	 * Search a contact through the component of the data access layer
	 * @param List<ContactDTO>
	 * @throws ExceptionBO
	 */
	@Override
	public List<ContactDTO> SearchContact(String searchCriteria) throws ExceptionBO {
		try {
			return (List<ContactDTO>) contactDao.SearchContact(searchCriteria);
		} catch (ExceptionDao e) {
			throw new ExceptionBO(e.getMessage(), e.getCode());
		}
	}

	/**
	 * List all contacts through the component of the data access layer
	 * @param List<ContactDTO>
	 * @throws ExceptionBO
	 */
	@Override
	public List<ContactDTO> listContact() throws ExceptionBO {
		try {
			return contactDao.listContact();
		} catch (ExceptionDao e) {
			throw new ExceptionBO(e.getMessage(), e.getCode());
		}
	}

}
