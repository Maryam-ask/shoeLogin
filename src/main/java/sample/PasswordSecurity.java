package sample;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by Maryam Askari
 * Date: 5/17/2021
 * Time: 9:51 AM
 * Project: IntelliJ IDEA
 */
public class PasswordSecurity {

    public static String shaHashing(String password) {
        String shaHashing = DigestUtils.sha256Hex(password);
        return  shaHashing;
    }
}
