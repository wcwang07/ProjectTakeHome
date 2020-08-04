import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Util {

  public static List<Record> generateListOfRecords(InputStream is) {

    List<Record> listOfRecords = new ArrayList<>();
    try (BufferedReader bufferedReader =
        new BufferedReader(new InputStreamReader(is))) {
      bufferedReader.readLine();
      String line = bufferedReader.readLine();
      while (line != null) {
        String[] arrays = line.split("\\t");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
          Date date = format.parse(arrays[2]);
          long timestamp = date.getTime();
          Record record = new Record(arrays[0], arrays[1], arrays[2], timestamp);
          listOfRecords.add(record);
          line = bufferedReader.readLine();
        } catch (ParseException e) {
          e.printStackTrace();
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return listOfRecords;
  }

  public static Map<String, HashSet<String>> generateUniqueUsersProductVisitedMap(
      List<Record> listOfRecords) {
    HashMap<String, HashSet<String>> counts = new LinkedHashMap<>();

    for (int i = 0; i < listOfRecords.size(); i++) {
      if (counts.containsKey(listOfRecords.get(i).getProducId())) {
        HashSet<String> hash = counts.get(listOfRecords.get(i).getProducId());
        hash.add(listOfRecords.get(i).getUserId());
        counts.put(listOfRecords.get(i).getProducId(), hash);
      } else {
        HashSet<String> hash = new HashSet<>();
        hash.add(listOfRecords.get(i).getUserId());
        counts.put(listOfRecords.get(i).getProducId(), hash);
      }
    }
    return counts;
  }
}
