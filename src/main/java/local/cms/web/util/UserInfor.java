package local.cms.web.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import local.cms.web.models.User;

public class UserInfor {

	public static String getUserNameInSession(HttpServletRequest request) {
		HttpSession session = request.getSession();

		User user = ((User) session.getAttribute("USER_SESSION"));
		if (user == null) {
			return null;
		}
		String userName = user.getUsername();
		return userName;

	}

}
