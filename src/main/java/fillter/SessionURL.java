package fillter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionURL {
    public static boolean checkSession (HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null){
            if (session.getAttribute("role") != null){
                return true;
            }
        }
        return false;
    }
}
