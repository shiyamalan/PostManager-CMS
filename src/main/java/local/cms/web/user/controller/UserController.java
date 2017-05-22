package local.cms.web.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import local.cms.web.models.Post;
import local.cms.web.models.User;
import local.cms.web.services.PostService;
import local.cms.web.services.RoleService;
import local.cms.web.util.UserInfor;

@Controller
public class UserController {

	PostService postService;

	RoleService roleService;
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	@RequestMapping(value = "/editor", method = RequestMethod.GET)
	public String showMain(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		String user = UserInfor.getUserNameInSession(request);
		if (user == null) {
			model.addAttribute("user", new User());
		}
		List<Post> posts = postService.getAllByUser(user);

		model.addAttribute("posts", posts);
		return "welcomepage_normaluser";
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String showHome(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		String user = UserInfor.getUserNameInSession(request);
		if (user == null) {
			model.addAttribute("user", new User());
		} else {

			boolean isAdmin = roleService.isAdmin(user);
			if (isAdmin) {

				List<Post> posts = postService.listPost();
				model.addAttribute("posts", posts);
				return "admin";
			} else {
				return "redirect:/editor";
			}
		}
		return "";
	}

}
