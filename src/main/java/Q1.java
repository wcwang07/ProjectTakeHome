import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Q1 {

  private static InputStream is = Q1.class.getResourceAsStream("users.tsv");
  private static List<Record> listOfRecords =Util.generateListOfRecords(is);
  private static Map<String, HashSet<String>> counts;

  public static void main(String[] args) {

    Q1 q1 = new Q1();
    q1.countUniqueUsersHaveVisited();
    System.out.println(q1.checkNumOfHomePagesVisited("2019-01-01 00", "2019-01-03 00"));
  }

  public void countUniqueUsersHaveVisited() {
    counts = Util.generateUniqueUsersProductVisitedMap(listOfRecords);
    for(Entry<String, HashSet<String> > entry:counts.entrySet()){
      System.out.println(entry.getKey()+":"+entry.getValue().size());
    }
  }

  public int checkNumOfHomePagesVisited(String date1, String date2) {

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH");
    Record tmpRecordTimeOne = null;
    Record tmpRecordTimeTwo = null;
    try {
      Date d1 = format.parse(date1);
      Date d2 = format.parse(date2);
      tmpRecordTimeOne = new Record(null,null,null,d1.getTime());
      tmpRecordTimeTwo = new Record(null,null,null,d2.getTime());

    } catch (ParseException e) {
      e.printStackTrace();
    }
    Collections.sort(listOfRecords, new Comparator<Record>() {
      @Override
      public int compare(Record o1, Record o2) {
        return o1.getUnixTimeStamp().compareTo(o2.getUnixTimeStamp());
      }
    });
    int index1 = Collections.binarySearch(listOfRecords, tmpRecordTimeOne);
    int index2 = Collections.binarySearch(listOfRecords, tmpRecordTimeTwo);

    if (index1 < 0) {
      index1 = -index1;
    }
    if (index2 < 0) {
      index2 = -index2;
    }
    return (index2 - index1);
  }
}
