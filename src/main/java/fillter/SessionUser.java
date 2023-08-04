package fillter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUser {
    public static boolean checkUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("role") != null) {
            if (session.getAttribute("role").equals("user")) {
                return true;
            }
        }
        return false;
    }
}