package local.cms.web.login.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import local.cms.web.models.Post;
import local.cms.web.models.User;
import local.cms.web.models.UserRole;
import local.cms.web.services.PostService;
import local.cms.web.services.RoleService;
import local.cms.web.services.UserService;

@Controller
public class LoginController {

	UserService userService;

	PostService postService;

	RoleService roleService;
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request,
			HttpServletResponse response, User user) {
		ModelAndView model = new ModelAndView("login");
		model.addObject("user", user);
		return model;
	}

	// controller method used to logout
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		System.out.println("logout");
		HttpSession session = request.getSession();
		session.setAttribute("USER_SESSION", null);
		model.addAttribute("user", new User());
		return "login";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView userAuth(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("user") User userDetails) {
		System.out.println("method userAuth");
		User user = userService.login(userDetails, request.getSession());

		
		if (user == null) {
			ModelAndView view=  new ModelAndView("login");
			view.addObject("message", "User Name or password is incorrect");
			return view;
		} else {
			boolean isAdmin = roleService.isAdmin(user.getUsername());

			if (isAdmin) {

				List<Post> posts = postService.listPost();
				List<User> userList = userService.listUsers();
				ModelAndView view = new ModelAndView("redirect:/admin");
				view.addObject("userForm", new User());
				view.addObject("userList", userList);
				view.addObject("posts", posts);
				return view;
			} else {

				List<Post> posts = postService.getAllByUser(user.getUsername());

				ModelAndView view = new ModelAndView("redirect:/main");
				view.addObject("posts", posts);
				return view;

			}

		}

	}


	

    @RequestMapping(value = "/user/suspend", method = RequestMethod.GET)
    public String updateUserEnabled(@ModelAttribute("userForm") User user, @RequestParam(value = "suspend") String suspend,@RequestParam(value = "enabled") Boolean enabled,
                             BindingResult result, Model model, final RedirectAttributes redirectAttributes){

        user.setUsername(suspend);
        user.setEnabled(enabled);
        userService.updateUserEnableStatus(user);
        return "redirect:/admin";
    }

}
