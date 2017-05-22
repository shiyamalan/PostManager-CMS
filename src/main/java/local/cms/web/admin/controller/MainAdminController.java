package local.cms.web.admin.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import local.cms.web.models.Post;
import local.cms.web.models.User;
import local.cms.web.models.UserRole;
import local.cms.web.services.PostService;
import local.cms.web.services.RoleService;
import local.cms.web.services.UserService;

@Controller
public class MainAdminController {

	UserService userService;

	RoleService roleService;

	PostService postService;
	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String main(ModelMap modelMap) {
		User user = new User();
		modelMap.addAttribute("userForm", user);

		List<User> userList = userService.listUsers();
		List<Post> postList = postService.listPost();

		modelMap.addAttribute("posts", postList);
		modelMap.addAttribute("userList", userList);
		return "admin";
	}

	@RequestMapping(value = "users", method = RequestMethod.GET)
	public String users(ModelMap modelMap) {
		List<User> userList = userService.listUsers();

		modelMap.addAttribute("userList", userList);

		return "userlist";
	}
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homePage(ModelMap modelMap) {
		modelMap.addAttribute("post", new Post());
		return "home";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerPage(ModelMap modelMap) {
		modelMap.addAttribute("user", new User());
		return "registeration";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String createUser(@ModelAttribute("user") @Validated User user,
			BindingResult result, Model model,
			final RedirectAttributes redirectAttributes) {

		String newUser = user.getUsername();
		String passWord = user.getPassword();
		
		
 		if(newUser.equals("") || passWord.equals(""))
		{
			model.addAttribute("message", "User Name or Password not Empty");
			return "registeration";
		}
		else
		{
			List<User> userList = userService.listUsers();
			for(User u:userList)
			{
				if(u.getUsername().equals(newUser))
				{
					model.addAttribute("message", "Already user name is available!");
					return "registeration";
				}
			}
			if (result.hasErrors()) {
				redirectAttributes.addFlashAttribute("error",
						"Username Already Exist");
				model.addAttribute("userForm", user);
				return "admin";
			} else {
				redirectAttributes.addFlashAttribute("css", "success");
				redirectAttributes.addFlashAttribute("msg",
						"User added successfully!");
				User createdUser = userService.createUser(user);
				UserRole role = new UserRole();
				role.setUsername(createdUser.getUsername());
				role.setRole("ROLE_USER");
				roleService.saveRole(role);
				return "redirect:/admin";
			}
		}
		
	}
}
