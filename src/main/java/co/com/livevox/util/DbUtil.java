package co.com.livevox.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Concrete class that manages the connection to the database
 * @author Fabian Andres Lopez Galindez
 * @version 1.0
 * @since  Feb 11, 2019
 */

public class DbUtil {
	
	private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                Properties prop = new Properties();
                InputStream inputStream = DbUtil.class.getClassLoader().getResourceAsStream(Constans.DB_PROPERTIES);
                prop.load(inputStream);
                String driver = prop.getProperty(Constans.DRIVER);
                String url = prop.getProperty(Constans.URL);
                String user = prop.getProperty(Constans.USER);
                String password = prop.getProperty(Constans.PASSWORD);
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return connection;
        }

    }

}
