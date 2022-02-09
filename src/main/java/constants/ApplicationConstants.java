package constants;

public class ApplicationConstants {
    public static final String INCORRECT_FILE_TYPE = "Arguments should be in the format --args='<File>'.";
    public static final String ILLEGAL_ARGUMENT_EXCEPTION = "Please check the arguments and run again.";
    public static final String PARSING_STARTED = "Parsing log file for events.";
    public static final String PARSING_ERROR = "Error Parsing log file for events: ";
    public static final String PARSING_ERROR_DB = "Error encountered with DB";
    public static final String LOG_DB_OPENING = "Opening database connection at < hsqldb/logs >";
    public static final String LOG_CREATING_TABLE= "Creating table";
    public static final String LOG_CLOSE_DB_CON = "Closing DB connection.";
    public static final String LOG_TABLE_DATA = "Retrieving all DB entries from table.";
    public static final String LOG_TABLE_DATA_DELETION = "Deleting all entries in DB table.";
    public static final String LOG_EVENT = "Alert for EventID: ";
}
