package session2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Authentification {
    private Set<User> users = new HashSet<>();
    private Map<String, String> users2 = new HashMap<>();

    public Authentification() {
        users.add(new User("Ivan", "Pass1"));
        users.add(new User("Yulia", "Pass2"));
        users.add(new User("Vova", "Pass3"));

        users2.put("1", "one");
        users2.put("2", "two");
        users2.put("3", "three");
        users2.put("4", "four");
        users2.put("5", "five");
    }

    public boolean isAuthentification(String login, String password) {
//        for ( User user : users ) {
//            if ( user.getLogin().equals(login) && user.getPassword().equals(password) ) {
//                return true;
//            }
//        }
        return users.contains(new User(login, password));

    }

    public boolean isAuthentification2(String login, String password) {
        return users2.containsKey(login) && users2.containsValue(password);

/* return users2.containsKey(login) && users2.get(login).equals(password); */

    }

    public static void main(String[] args) {
        Authentification auth = new Authentification();

        boolean isPrasent = auth.isAuthentification("Ivan", "Pass1");
        boolean isPrasentInMap = auth.isAuthentification2("1", "one");
    }

    public void  setUsers(Map<String, String> users) {
        this.users2 = users;
    }
}
