package controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/** Hash
 * @author zaur
 * This class takes the password of users and it creates encrypted version via sha 256 hexademical   */
public class Hash{
    final protected static char[] arr = "0123456789ABCDEF"
            .toCharArray();
    public static String toHex(byte[] a) {
        char[] ch = new char[a.length * 2];
        int t;
        for (int j = 0; j < a.length; j++) {
            t = a[j] & 0xFF;                             /** Hash
                                                           * @author zaur
                                                           * @param a comes from hashh method
                                                           * @return the new String    */
            ch[j * 2] = arr[t >>> 4];
            ch[j * 2 + 1] = arr[t & 0x0F];
        }
        return new String(ch);
    }

    private static final String ex = "123456";
    public static String hashh(String b) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(ex.getBytes());
            messageDigest.update(b.getBytes());

            byte[] last = messageDigest.digest();
            return toHex(last);                                    /** Hash
                                                                   * @author zaur
                                                                    * @return last to toHex method   */
        } catch (NoSuchAlgorithmException e) {

        }
        return "";
    }
}
