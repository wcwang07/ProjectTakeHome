import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public class Q1 {

  InputStream is = Q1.class.getResourceAsStream("users.tsv");

  public HashMap<String, HashSet<String>> counts = new LinkedHashMap<>();
  public List<Long> dates = new ArrayList<>();

  public static void main(String[] args) {

    Q1 q1 = new Q1();
    try {
      q1.generateMapAndList();
      q1.countUniqueUsersHaveVisited();
      q1.checkNumOfHomePagesVisited("2019-01-01 d", "2019-01-03 ");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void countUniqueUsersHaveVisited() {

    for(Entry<String, HashSet<String> > entry:this.counts.entrySet()){
      System.out.println(entry.getKey()+":"+entry.getValue().size());
    }
  }

  public void generateMapAndList() throws IOException {

    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
    reader.readLine();
    String line;
    while ((line = reader.readLine()) != null) {
      String[] arrays = line.split("\\t");

      if(counts.containsKey(arrays[0])){
        HashSet<String> hash =counts.get(arrays[0]);
        hash.add(arrays[1]);
        counts.put(arrays[0],hash);
      }
      else {
        HashSet<String> hash = new HashSet<>();
        hash.add(arrays[1]);
        counts.put(arrays[0],hash);
      }

      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
      try {
        Date date = format.parse(arrays[2]);
        long timestamp = date.getTime();
        dates.add(timestamp);
      } catch (ParseException e) {
        e.printStackTrace();
      }
    }
    Collections.sort(this.dates);

  }

  public void checkNumOfHomePagesVisited(String date1, String date2) {

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH");
    long timestamp1 = 0l;
    long timestamp2 = 0l;
    try {
      Date d1 = format.parse(date1);
      Date d2 = format.parse(date2);
      timestamp1 = d1.getTime();
      timestamp2 = d2.getTime();

    } catch (ParseException e) {
      e.printStackTrace();
    }

    int index1 = Collections.binarySearch(this.dates, timestamp1);
    int index2 = Collections.binarySearch(this.dates, timestamp2);

    if (index1 < 0) {
      index1 = -index1;
    }
    if (index2 < 0) {
      index2 = -index2;
    }
    System.out.println(index2 - index1);

  }


}
