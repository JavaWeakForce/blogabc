/**
 * BLOGABC system 1.0
 * 
 * This is an open source system for studying spring framework and hibernate.
 * You can use it anywhere and you can ask your question or update your good idea. 
 * author: ericHan1979@gmail.com
 * date: 2009-3-30
 */
package blogabc.controller.blog;

import java.util.Date;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import blogabc.business.ArticleBusiness;
import blogabc.business.UserBusiness;
import blogabc.controller.ControllerHelp;
import blogabc.entity.Article;
import blogabc.entity.User;
import blogabc.form.BlogForm;

public class PublishBlogController extends SimpleFormController {
	private ArticleBusiness articleBusiness;
	private UserBusiness userBusiness;

	public ArticleBusiness getArticleBusiness() {
		return articleBusiness;
	}

	public void setArticleBusiness(ArticleBusiness articleBusiness) {
		this.articleBusiness = articleBusiness;
	}

	public PublishBlogController() {
		setCommandClass(BlogForm.class);
	}

	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		try {
			Article article = new Article();
			
			BlogForm form = (BlogForm) command;
			Long userId = form.getUserId();
			String title = form.getTitle();			
			Long cId = form.getClassifyId();
			
			Enumeration<String> params = (Enumeration<String>) request.getParameterNames();
			String parameter=null;
			while(params.hasMoreElements()) {
				parameter = params.nextElement();
				if("marsEditor".equals(parameter)){
					String content = request.getParameter(parameter);
					article.setContent(content);
					break;
				}
			}
						
			article.setClassifyId(cId);			
			article.setTitle(title);
			article.setUserId(userId);
			Date date = new Date();
			article.setCreateTime(date);
			article.setUpdateTime(date);
			getArticleBusiness().publishArticle(article);

			BlogModel blogModel = getArticleBusiness().getArticles(userId, 0, 25);
			User user = getUserBusiness().getUser(userId);
			Map model = ControllerHelp.user2model(request, user);
			model.put("blogModel", blogModel);
			return new ModelAndView(viewPage1, model);
		} catch (Exception e) {
			return new ModelAndView(viewPage2);
		}
	}

	public UserBusiness getUserBusiness() {
		return userBusiness;
	}

	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}

	private String viewPage1;
	private String viewPage2;

	public void setViewPage1(String viewPage1) {
		this.viewPage1 = viewPage1;
	}

	public void setViewPage2(String viewPage2) {
		this.viewPage2 = viewPage2;
	}
}
