package com.model.to;

import java.util.UUID;

/**
 * Created by Maryam Askari
 * Date: 5/26/2021
 * Time: 2:10 PM
 * Project: IntelliJ IDEA
 */
public class IdGenerator {
    public static int generateUniqueId() {
        UUID idOne = UUID.randomUUID();
        String idStr = "" + idOne;
        int uid = idStr.hashCode();
        String filterStr = "" + uid;
        idStr = filterStr.replaceAll("-", "");
        int id = Integer.parseInt(idStr);
        return id;
    }

}
