package Ticket;

import java.security.MessageDigest;

public class Encoding {
    public static String encoding(String str) {
        String encodeString = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            md.update(str.getBytes());

            byte[] encodeData = md.digest();

            for(int i = 0; i < encodeData.length; i++) {
                encodeString += Integer.toHexString(encodeData[i]&0xFF);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return encodeString;
    }

    public static void main(String[] args) {
        System.out.println(encoding("d9af9f5653607e98b7a49229c314d1eb0c4f580254fd680f9d31b94f93a67"));
    }
}
