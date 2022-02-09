package constants;

public class QueryConstants {
    public static final String CREATE_TABLE_EVENT = "CREATE TABLE IF NOT EXISTS EVENTS (id VARCHAR(50) NOT NULL, duration FLOAT NOT NULL, type VARCHAR(50), host VARCHAR(50), alert BOOLEAN NOT NULL)";
    public static final String INSERT_TABLE_EVENT = "INSERT INTO EVENTS (id, duration, type, host, alert)  VALUES (?, ?, ?, ?, ?)";
    public static final String DB_CON_STRING = "jdbc:hsqldb:file:hsqldb/logs";
    public static final String SELECT_TABLE_EVENT = "SELECT * FROM EVENTS";
    public static final String DELETE_TABLE_EVENT = "SELECT * FROM EVENTS";
}
