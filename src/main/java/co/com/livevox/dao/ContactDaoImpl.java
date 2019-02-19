package co.com.livevox.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import co.com.livevox.dto.ContactDTO;
import co.com.livevox.exception.ExceptionDao;
import co.com.livevox.util.Constans;
import co.com.livevox.util.DbUtil;
import co.com.livevox.util.Util;

/**
 * Concrete class that implements the capabilities offered by the segregated
 * interface (ContactDao) that manages contacts
 * @author Fabian Andres Lopez Galindez
 * @version 1.0
 * @since  Feb 11, 2019
 */

public class ContactDaoImpl implements ContactDao {
	
	private Connection connection;
	
	public ContactDaoImpl(){
		connection = DbUtil.getConnection();
	}

	/**
	 * Save a contact 
	 * @param contactDTO
	 * @throws ExceptionDao
	 */
	@Override
	public String addContact(ContactDTO contactDTO) throws ExceptionDao {
		try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into contacts(firstname,lastname,phone) values (?, ?, ? )");
            preparedStatement.setString(1, contactDTO.getFirstName());            
            preparedStatement.setString(2, contactDTO.getLastName());
            preparedStatement.setString(3, contactDTO.getPhone());
            preparedStatement.executeUpdate();
            return Constans.SUCCESSFUL;
        } catch (SQLException e) {
            e.printStackTrace();
            return Constans.ERROR;
        }		
	}

	/**
	 * Search a contact 
	 * @param List<ContactDTO>
	 * @throws ExceptionDao
	 */
	@Override
	public List<ContactDTO> SearchContact(String searchCriteria) throws ExceptionDao {
		List<ContactDTO> contactDTOs = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM contacts WHERE firstName like '%"+searchCriteria)
            .append("%' OR lastName like '%"+searchCriteria)
            .append("%' OR phone like '%"+searchCriteria+"%' ");
            ResultSet rs = statement.executeQuery(query.toString());            
            while (rs.next()) {
            	contactDTOs.add(Util.createContactDTO(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return contactDTOs;
	}

	/**
	 * List all contacts 
	 * @param List<ContactDTO>
	 * @throws ExceptionDao
	 */
	@Override
	public List<ContactDTO> listContact() throws ExceptionDao {
		List<ContactDTO> contactDTOs = new ArrayList<ContactDTO>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from contacts");
            while (rs.next()) {
            	contactDTOs.add(Util.createContactDTO(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return contactDTOs;
	}

}
