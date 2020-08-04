public class Q2 {


  public static void main(String[] args){

    Q2 q2 = new Q2();

    q2.recoverMessage(5, "toioynnkpheleaigshareconhtomesnlewx");
    q2.recoverMessage(3, "ttyohhieneesiaabss");

  }

  public void recoverMessage(int k, String str){

    int strSize = str.length();
    if(strSize%k!=0) {
      System.exit(1);
    }
    int row = strSize/k;
    char[][] tmpChar = new char[row][k];

      int index=0;
      boolean sw=true;
      for(int i=0;i<tmpChar.length;i++){
        if(!sw) {
          for (int j = tmpChar[i].length-1; j >=0; j--) {
            tmpChar[i][j] = str.charAt(index++);
          }
        }else {
          for (int j =0 ; j < tmpChar[i].length; j++) {
            tmpChar[i][j] = str.charAt(index++);
          }
        }
        sw=!(sw);
      }

    StringBuilder sb = new StringBuilder();
    for(int c=0;c<tmpChar[0].length;c++){
      for(int r=0;r<tmpChar.length;r++){
        sb.append(tmpChar[r][c]);
      }
    }

    System.out.println(sb.toString());
  }
}
