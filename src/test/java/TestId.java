import java.util.UUID;

/**
 * Created by Maryam Askari
 * Date: 8/6/2021
 * Time: 9:14 PM
 * Project: IntelliJ IDEA
 */
public class TestId {
    public static void main(String[] args) {
        UUID idOne = UUID.randomUUID();
        String idStr =""+idOne;
        int uid=idStr.hashCode();
        String filterStr=""+uid;
        idStr=filterStr.replaceAll("-", "");
        int id = Integer.parseInt(idStr);
        System.out.println(id);
    }
}
