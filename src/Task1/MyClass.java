package Task1;


public class MyClass {
    public static void main(String[] args) {
        String string ="WEAREDISCOVEREDFLEEATONCE";
        String str="WECRLTEERDSOEEFEAOCAIVDEN";
        String encoded=gedEncoder(string, 3);
        System.out.println(encoded);
        String decoded=getDecoder(str, 3);
        System.out.println(decoded);
    }

    public static String gedEncoder(String string, int key) {
        String text = "";
        if (key < 2) {
            return "Key must be biggest or equals 2";
        }
        if (string.isEmpty()) {
            return "";
        }
        boolean checkdown=false;
        int j=0;
        char[][] chars=new char[key][string.length()];

        for(int i=0;i<string.length();i++){
            if(j==0||j==key-1)
                checkdown=!checkdown;

            chars[j][i]=string.charAt(i);
            if(checkdown){
                j++;
            }
            else
                j--;
        }
        for (int i = 0; i < key; i++) {
            for (int k = 0; k < string.length(); k++) {
                text+=chars[i][k];
            }
        }
        return text;
    }

    public static String getDecoder(String string, int key) {
        String s="";
        boolean checkdown=false;
        int j=0;
        char[][] chars=new char[key][string.length()];

        for(int i=0;i<string.length();i++){
            if(j==0||j==key-1)
                checkdown=!checkdown;

            chars[j][i] = '*';

            if(checkdown)j++;
            else j--;
        }

        int index=0;
        for(int i=0;i<key;i++){
            for(int k=0;k<string.length();k++){
                if(chars[i][k]=='*' && index<string.length()){
                    chars[i][k]=string.charAt(index++);
                }
            }
        }

        checkdown=false;
        j=0;

        for(int i=0;i<string.length();i++){
            if( j==0||j==key-1)
                checkdown=!checkdown;

            s+=chars[j][i];
            if(checkdown)j++;
            else j--;
        }
        return s;
    }
}
