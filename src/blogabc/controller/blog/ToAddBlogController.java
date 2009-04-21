/**
 * BLOGABC system 1.0
 * 
 * This is an open source system for studying spring framework and hibernate.
 * You can use it anywhere and you can ask your question or update your good idea. 
 * author: ericHan1979@gmail.com
 * date: 2009-3-30
 */
package blogabc.controller.blog;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import blogabc.business.ArticleBusiness;
import blogabc.business.UserBusiness;
import blogabc.entity.User;

public class ToAddBlogController implements Controller {
	private ArticleBusiness articleBusiness;
	private UserBusiness userBusiness;

	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}

	public UserBusiness getUserBusiness() {
		return userBusiness;
	}

	public ArticleBusiness getArticleBusiness() {
		return articleBusiness;
	}

	public void setArticleBusiness(ArticleBusiness articleBusiness) {
		this.articleBusiness = articleBusiness;
	}

	private String viewPage1;
	private String viewPage2;

	public void setViewPage1(String viewPage1) {
		this.viewPage1 = viewPage1;
	}

	public void setViewPage2(String viewPage2) {
		this.viewPage2 = viewPage2;
	}

	@SuppressWarnings("unchecked")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			Long userId = Long.parseLong(request.getParameter("id"));

			User user = getUserBusiness().getUser(userId);
			Map model = new HashMap();
			model.put("user", user.getName());
			model.put("userId", user.getId() + "");

			Long sessionId = (Long) request.getSession().getAttribute("userId");
			boolean isOwn;
			if (sessionId == null) {
				isOwn = false;
			} else
				isOwn = sessionId.equals(user.getId());
			model.put("isOwn", isOwn + "");
			return new ModelAndView(viewPage1, model);
		} catch (Exception e) {
			return new ModelAndView(viewPage2);
		}
	}
}
