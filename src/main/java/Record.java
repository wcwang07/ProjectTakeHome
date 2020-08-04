public class Record implements Comparable<Record> {

  String producId;
  String userId;

  @Override
  public String toString() {
    return "Record{" +
        "producId='" + producId + '\'' +
        ", userId='" + userId + '\'' +
        ", timestamp='" + timestamp + '\'' +
        ", unixTimeStamp=" + unixTimeStamp +
        '}';
  }

  String timestamp;

  public Record(String producId, String userId, String timestamp, long unixTimeStamp) {
    this.producId = producId;
    this.userId = userId;
    this.timestamp = timestamp;
    this.unixTimeStamp = unixTimeStamp;
  }

  public String getProducId() {
    return producId;
  }

  public void setProducId(String producId) {
    this.producId = producId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  long unixTimeStamp;

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public Long getUnixTimeStamp() {
    return unixTimeStamp;
  }

  public void setUnixTimeStamp(long unixTimeStamp) {
    this.unixTimeStamp = unixTimeStamp;
  }

  @Override
  public int compareTo(Record o) {
    return this.getUnixTimeStamp().compareTo(o.getUnixTimeStamp());
  }


}
