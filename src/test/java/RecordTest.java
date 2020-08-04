import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class RecordTest {

  @Test
  public void recordTest() {
    Record record = new Record("p1", "u1", "2019-01-02 02:12", 0l);

    Record record1 = Mockito.spy(record);

    Mockito.doReturn("p1").when(record1).getProducId();

    Assert.assertEquals("p1", record1.getProducId());
  }

}
