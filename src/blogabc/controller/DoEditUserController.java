/**
 * BLOGABC system 1.0
 * 
 * This is an open source system for studying spring framework and hibernate.
 * You can use it anywhere and you can ask your question or update your good idea. 
 * author: ericHan1979@gmail.com
 * date: 2009-3-30
 */
package blogabc.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import blogabc.business.UserBusiness;
import blogabc.entity.User;
import blogabc.form.RegisterForm;

public class DoEditUserController extends SimpleFormController {
	private UserBusiness userBusiness;

	private String photoBaseUrl;

	private String photoWebUrl;

	public void setPhotoWebUrl(String photoWebUrl) {
		this.photoWebUrl = photoWebUrl;
	}

	public DoEditUserController() {
		setCommandClass(RegisterForm.class);
	}

	public UserBusiness getUserBusiness() {
		return userBusiness;
	}

	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}

	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		RegisterForm form = (RegisterForm) command;
		Long id = (Long) request.getSession().getAttribute("userId");
		
		User user = getUserBusiness().getUser(id);

		// TODO need to extract form2bean method
		Date now = new Date();
		user.setUpdateTime(now);
		user.setDescription(form.getDescription());
		user.setEmail(form.getEmail());
		user.setFirstName(form.getFirstName());
		user.setLastName(form.getLastName());

		user.setPhone(form.getMobile());

		boolean isUpdate = getUserBusiness().update(user);

		if (isUpdate) {
			Map<String, String> model = ControllerHelp.user2model(request, user);
			if (form.getFileContents().length > 0) {
				String p = photoBaseUrl + System.getProperty("file.separator") + user.getName().trim() + ".jpg";
				String c = photoWebUrl + "\\" + user.getName().trim() + ".jpg";
				if (getUserBusiness().updatePhoto(user.getId(), form.getFileContents(), p, c)) {
					return new ModelAndView(getSuccessView(), model);
				} else {
					return new ModelAndView(getFormView());
				}
			} else {
				return new ModelAndView(getSuccessView(),model);
			}
		} else {
			return new ModelAndView(getFormView());
		}
	}

	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		super.initBinder(request, binder);
		binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
	}

	public void setPhotoBaseUrl(String photoBaseUrl) {
		this.photoBaseUrl = photoBaseUrl;
	}

}
