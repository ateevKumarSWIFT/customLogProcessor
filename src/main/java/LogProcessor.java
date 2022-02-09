import helpers.PersistEventDAO;
import helpers.LogFileParser;
import constants.ApplicationConstants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class LogProcessor {
    private final static Log logger = LogFactory.getLog(LogFileParser.class);

    public static void main(String[] args) {
        if (args == null || args.length != 1) {
            logger.error(ApplicationConstants.INCORRECT_FILE_TYPE);
            logger.error(ApplicationConstants.ILLEGAL_ARGUMENT_EXCEPTION);
        }
        String file = args[0];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            PersistEventDAO persistEventDAO = new PersistEventDAO();
            persistEventDAO.createEventsTable();
            logger.debug(ApplicationConstants.PARSING_STARTED + file);
            LogFileParser parser = new LogFileParser();
            parser.parseLogs(reader, persistEventDAO);
            persistEventDAO.selectAll();
            persistEventDAO.deleteAll();
            persistEventDAO.closeDatabase();
        } catch (IOException e) {
            logger.error(ApplicationConstants.PARSING_ERROR + file);
            logger.error(e);
        } catch (SQLException e) {
            logger.error(ApplicationConstants.PARSING_ERROR_DB);
            logger.error(e);
        }
    }
}
