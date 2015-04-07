package spring2048.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring2048.web.dto.UserScoreDTO;

/**
 * Entrance controller for the index and basic redirect
 * 
 * @author Shallong
 *
 */
@Controller
public class HomeController {

  /**
   * Root
   * 
   * @return
   */
  @RequestMapping("/")
  String home() {
    return "redirect:/user/signin";
  }

  /**
   * Game entrance
   * 
   * @param session
   * @param model
   * @return
   */
  @RequestMapping("/play2048")
  String play2048(HttpSession session, Model model) {
    UserScoreDTO userDTO = (UserScoreDTO) session.getAttribute("session_user");
    if (userDTO == null) {
      return "redirect:/user/signin";
    }
    model.addAttribute("username", userDTO.getUsername());
    return "play2048";
  }

}
