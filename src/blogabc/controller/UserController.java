/**
 * BLOGABC system 1.0
 * 
 * This is an open source system for studying spring framework and hibernate.
 * You can use it anywhere and you can ask your question or update your good idea. 
 * author: ericHan1979@gmail.com
 * date: 2009-3-30
 */
package blogabc.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import blogabc.business.UserBusiness;
import blogabc.entity.User;

public class UserController implements Controller {
	private UserBusiness userBusiness;

	private String viewPage1;
	private String viewPage2;

	public void setViewPage1(String viewPage1) {
		this.viewPage1 = viewPage1;
	}

	public void setViewPage2(String viewPage2) {
		this.viewPage2 = viewPage2;
	}

	public Long register(User user) {
		return getUserBusiness().register(user);
	}

	public UserBusiness getUserBusiness() {
		return userBusiness;
	}

	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			String sId = request.getParameter("id");
			Long id;
			if (sId == null) {
				id = (Long) request.getSession().getAttribute("userId");
			} else {
				id = Long.parseLong(sId);
			}

			User user = getUserBusiness().getUser(id);
			Map<String, String> model = ControllerHelp.user2model(request, user);
			return new ModelAndView(viewPage1, model);
		} catch (Exception e) {
			return new ModelAndView(viewPage2);
		}
	}
}
