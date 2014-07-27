/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project_euler.util;

import java.security.MessageDigest;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class MD5Hash {

    /**
     * md - Java MD5 hash implementation
     */
    private final MessageDigest md;
    /**
     * hexChar - hexadesimal numbers 0-f as character array
     */
    private final static char[] hexChar = {
        '0', '1', '2', '3',
        '4', '5', '6', '7',
        '8', '9', 'a', 'b',
        'c', 'd', 'e', 'f'
    };

    /**
     * 
     * @throws java.lang.Exception
     */
    public MD5Hash() throws Exception {
        md = MessageDigest.getInstance("md5");
    }

    /**
     * 
     * @param input
     * @return
     */
    public String getHexStringHash(String input) {
        md.reset();
        final byte[] output = md.digest(input.getBytes());
        final String hash = toHexString(output);
        return hash;
    }

    /**
     * 
     * @param input
     * @return
     */
    public byte[] getByteHash(String input) {
        md.reset();
        final byte[] output = md.digest(input.getBytes());
        return output;
    }

    /**
     * 
     * @param b
     * @return
     */
    public static String toHexString(byte[] b) {
        final StringBuffer sb = new StringBuffer(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            // look up high nibble char
            sb.append(hexChar[(b[i] & 0xf0) >>> 4]); // fill left with zero bits

            // look up low nibble char
            sb.append(hexChar[b[i] & 0x0f]);
        }
        return sb.toString();
    }
}
