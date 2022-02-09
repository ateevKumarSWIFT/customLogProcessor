package helpers;

import constants.QueryConstants;
import constants.ApplicationConstants;
import models.Event;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.*;

public class PersistEventDAO {
    private static final Log logger = LogFactory.getLog(PersistEventDAO.class);

    private static Connection connection;

    public PersistEventDAO() throws SQLException {

        logger.info(ApplicationConstants.LOG_DB_OPENING);
        connection = DriverManager.getConnection(QueryConstants.DB_CON_STRING, "SA", "");
    }

    /**
     * 
     * @throws SQLException
     */
    public void createEventsTable() throws SQLException {
        logger.info(ApplicationConstants.LOG_CREATING_TABLE);
        connection.createStatement().executeUpdate(QueryConstants.CREATE_TABLE_EVENT);
    }

    void writeEvent(Event event) throws SQLException {
        
        PreparedStatement preparedStatement = connection.prepareStatement(QueryConstants.INSERT_TABLE_EVENT);
        preparedStatement.setString(1, event.getId());
        preparedStatement.setFloat(2, event.getDuration());
        preparedStatement.setString(3, event.getType());
        preparedStatement.setString(4, event.getHost());
        preparedStatement.setBoolean(5, event.isAlert());

        preparedStatement.executeUpdate();
    }

    public void closeDatabase() throws SQLException {
        logger.info(ApplicationConstants.LOG_CLOSE_DB_CON);
        connection.close();
    }

    public void selectAll() throws SQLException {

        logger.debug(ApplicationConstants.LOG_TABLE_DATA);
        ResultSet resultSet = connection.createStatement().executeQuery(QueryConstants.SELECT_TABLE_EVENT);

        while (resultSet.next()) {
            if (resultSet.getBoolean(5)) {
                logger.debug(ApplicationConstants.LOG_EVENT+resultSet.getString(1));
            }
        }
    }

    public void deleteAll() throws SQLException {

        logger.warn(ApplicationConstants.LOG_TABLE_DATA_DELETION);
        connection.createStatement().executeUpdate(QueryConstants.DELETE_TABLE_EVENT);
    }
}
