package co.com.livevox.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.com.livevox.bo.ContactBO;
import co.com.livevox.bo.ContactBOImpl;
import co.com.livevox.dto.ContactDTO;
import co.com.livevox.exception.ExceptionBO;
import co.com.livevox.util.Constans;
import co.com.livevox.util.Util;

/**
 * Link the view with the model
 * @author Fabian Andres Lopez Galindez
 * @version 1.0
 * @since  Feb 11, 2019
 */

public class ContactController extends HttpServlet {

	// Dependencies of the business layer
	private ContactBO contactBO;

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(ContactController.class.getName());	
	public static boolean isNotSearch = true;

	/**
	 * Initializes the dependency of the business layer
	 */
	public ContactController() {
		super();
		contactBO = new ContactBOImpl();
	}

	/**
	 * Search for a contact by a search criteria through the business component
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setAttribute(Constans.CONTACTS, contactBO.SearchContact(request.getParameter(Constans.SEARCH)));
			isNotSearch = false;
		} catch (ExceptionBO e) {
			LOG.warning(e.getMessage());
			e.printStackTrace();
		}
		RequestDispatcher view = request.getRequestDispatcher(Constans.LIST_CONTACTS);
		view.forward(request, response);
	}

	/**
	 * Save a contact through the business component
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ContactDTO contactDTO = new ContactDTO(request.getParameter(Constans.FIRST_NAME),
				request.getParameter(Constans.LAST_NAME), request.getParameter(Constans.PHONE));
		try {
			if (Util.validateContactDTO(contactDTO)) {
				contactBO.addContact(contactDTO);
			}
		} catch (ExceptionBO e) {
			LOG.warning(e.getMessage());
			e.printStackTrace();
		}
		RequestDispatcher view = request.getRequestDispatcher(Constans.LIST_CONTACTS);
		view.forward(request, response);
	}

	/**
	 * List all contacts through the business component
	 * @return List<ContactDTO>
	 */
	public List<ContactDTO> listContacts() {
		List<ContactDTO> listContacts = new ArrayList<>();
		try {
			listContacts = contactBO.listContact();
		} catch (ExceptionBO e) {
			listContacts = new ArrayList<>();
			LOG.warning(e.getMessage());
			e.printStackTrace();
		}
		return listContacts;
	}

}
