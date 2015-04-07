package spring2048.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring2048.service.UserService;
import spring2048.web.dto.UserScoreDTO;

/**
 * User controller for user-related logic
 * 
 * @author Shallong
 *
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/")
  String root() {
    return "redirect:/user/signin";
  };

  @RequestMapping(value = "/signin", method = RequestMethod.GET)
  String signin() {
    return "signin";
  }

  @RequestMapping(value = "/signup", method = RequestMethod.GET)
  String signup() {
    return "signup";
  }

  @RequestMapping(value = "/signin", method = RequestMethod.POST)
  public String signin( //
      @RequestParam(defaultValue = "", value = "username") String username, //
      @RequestParam(defaultValue = "", value = "password") String password, //
      HttpSession session, Model model) {

    UserScoreDTO userScoreDTO = userService.signin(username, password);
    if (userScoreDTO != null) {
      session.setAttribute("session_user", userScoreDTO);
      return "redirect:/play2048";
    }

    model.addAttribute("error", "Username or Password is incorrect!");
    return "signin";
  }

  @RequestMapping(value = "/signup", method = RequestMethod.POST)
  public String signup( //
      @RequestParam(defaultValue = "", value = "username") String username, //
      @RequestParam(defaultValue = "", value = "password") String password, //
      HttpSession session, Model model) {

    if (userService.checkUsernameUnique(username)) {
      UserScoreDTO userScoreDTO = userService.signup(username, password);
      session.setAttribute("session_user", userScoreDTO);
      return "redirect:/play2048";
    }

    model.addAttribute("error", "Username '" + username + "' has been registered!");
    return "signup";
  }

  @RequestMapping(value = "/signout", method = RequestMethod.GET)
  public String signout(HttpSession session) {

    session.removeAttribute("session_user");

    return "signin";
  }

}
