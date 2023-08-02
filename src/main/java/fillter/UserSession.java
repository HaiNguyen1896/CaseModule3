package filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserSession {
    public static boolean checkSession (HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null){
            if (session.getAttribute("idUser") != null){
                return true;
            }
        }
        return false;
    }
}