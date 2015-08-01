package utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import modelObjects.User.UserType;

public class SessionHandler {
	public static boolean isAuthUser(HttpServletRequest req) {
		return getId(req) != null && getType(req) != null && getFullname(req)!=null;
	}
	
	public static void authUser(Integer id , UserType type ,String fullName, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
	    session.setAttribute("id", id);
	    session.setAttribute("type", type);
	    session.setAttribute("fullname", fullName);
	}
	
	public static void unAuthUser(HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		session.removeAttribute("id");
		session.removeAttribute("type");
		session.removeAttribute("fullname");
	}
	
	public static Integer getId(HttpServletRequest req) {
		Integer id = null;
		
		HttpSession session = req.getSession(true);
	    id = (Integer)session.getAttribute("id");
	    
		return id;
	}
	
	public static UserType getType(HttpServletRequest req) {
		UserType type = null;
		
		HttpSession session = req.getSession(true);
	    type = (UserType)session.getAttribute("type");
	    
		return type;
	}
	
	public static boolean isAdmin(HttpServletRequest req){
		boolean isAdmin = false;
		UserType type = getType(req);
		if(type.equals(UserType.Admin)){
			isAdmin = true;
		}
		
		return isAdmin;
	}
	
	public static String getFullname(HttpServletRequest req){
		String fullname = null;
		
		HttpSession session = req.getSession(true);
		fullname = (String)session.getAttribute("fullname");
		
		return fullname;
	}
	
	
}
