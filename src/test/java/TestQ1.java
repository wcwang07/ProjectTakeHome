
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.mockito.Mockito;

public class TestQ1 {

  @Test
  public void testCheckNumOfHomePagesVisited() throws ParseException {


    SimpleDateFormat mockSimpleDateFormat = Mockito.mock(SimpleDateFormat.class);

    Record mockRecordTimeOne = Mockito.mock(Record.class);
    Record mockRecordTimeTwo = Mockito.mock(Record.class);

    Collections mockCollectionsOne = Mockito.mock(Collections.class);

    List<Record> mockListOfRecords = Mockito.mock(List.class);

    Integer mockIndexOne = Mockito.mock(Integer.class);
    Integer mockIndexTwo = Mockito.mock(Integer.class);
    Integer mockIndexThree = Mockito.mock(Integer.class);

    Date mockDateOne = Mockito.mock(Date.class);
    Date mockDateTwo = Mockito.mock(Date.class);

    Mockito.doReturn(mockDateOne).when(mockSimpleDateFormat).parse(anyString());
    Mockito.doReturn(mockDateTwo).when(mockSimpleDateFormat).parse(anyString());

    Mockito.doReturn(mockIndexOne).when(mockCollectionsOne).binarySearch(mockListOfRecords,mockRecordTimeOne);
    Mockito.doReturn(mockIndexTwo).when(mockCollectionsOne).binarySearch(mockListOfRecords,mockRecordTimeOne);

    Mockito.doReturn(mockIndexThree).when(mockIndexTwo-mockIndexOne);

    assertEquals(java.util.Optional.ofNullable(mockIndexThree), mockIndexTwo-mockIndexOne);

  }

}
