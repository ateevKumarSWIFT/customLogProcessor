package helpers;

import models.Event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class PersistEventDAOTest {

    @InjectMocks
    private PersistEventDAO dao;
    @Mock
    private Connection mockConnection;
    @Mock
    private Statement mockStatement;
    @Mock
    private PreparedStatement mockPreparedStatement;
    @Mock
    private ResultSet mockResultSet;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createEventsTable() throws SQLException {
        Mockito.when(mockConnection.createStatement()).thenReturn(mockStatement);
        Mockito.when(mockConnection.createStatement().executeUpdate(Mockito.anyString())).thenReturn(1);

        dao.createEventsTable();

        Mockito.verify(mockConnection.createStatement(), Mockito.calls(1));
    }

    @Test
    public void writeEvent() throws SQLException {
        Mockito.when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockPreparedStatement);
        Mockito.when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        Event event = new Event.EventBuilder("test", 2, false)
                .withHost(null)
                .withType(null)
                .build();
        dao.writeEvent(event);

        Mockito.verify(mockConnection.prepareStatement(Mockito.anyString()), Mockito.calls(1));
    }

}
