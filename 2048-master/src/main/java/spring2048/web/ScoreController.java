package spring2048.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import spring2048.service.ScoreService;
import spring2048.web.dto.RestDTO;
import spring2048.web.dto.UserScoreDTO;

/**
 * Score controller for the score-related logic
 * 
 * @author Shallong
 *
 */
@Controller
@RequestMapping(value = "/score")
public class ScoreController {

  @Autowired
  private ScoreService scoreService;

  /**
   * List the scores
   * 
   * @param session
   * @param model
   * @return Game view
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String publicScore(HttpSession session, Model model) {

    UserScoreDTO sessionUser = (UserScoreDTO) session.getAttribute("session_user");
    if (sessionUser == null) {
      return "redirect:/user/signin";
    }
    model.addAttribute("username", sessionUser.getUsername());

    List<UserScoreDTO> scoreList = scoreService.viewPublicScore();
    model.addAttribute("scoreList", scoreList);

    UserScoreDTO myScore = scoreService.viewMyselfScore(sessionUser.getUsername());
    model.addAttribute("myScore", myScore);
    return "score2048";

  }

  /**
   * REST method which will get the highest score of a login user
   * 
   * @param session
   * @param model
   * @return
   */
  @ResponseBody
  @RequestMapping(value = "/getHighest", method = RequestMethod.GET)
  public RestDTO getHighestScore(HttpSession session, Model model) {

    UserScoreDTO sessionUser = (UserScoreDTO) session.getAttribute("session_user");
    if (sessionUser == null) {
      return new RestDTO(false, "ERR_GET_HIGHEST_1", "");
    }

    UserScoreDTO myScore = scoreService.viewMyselfScore(sessionUser.getUsername());
    if (myScore != null) {
      return new RestDTO(true, "", myScore);
    } else {
      return new RestDTO(false, "ERR_GET_HIGHEST_2", "");
    }

  }

  /**
   * REST method which will produce the JSON output eventually
   * 
   * Upload a new score into the system, the username is extracted from the current session directly
   * 
   * @param session
   * @param score
   * @return RestDTO in JSON format
   */
  @ResponseBody
  @RequestMapping(value = "/upload", method = RequestMethod.POST, produces = { "application/json" })
  public RestDTO uploadScoreREST(HttpSession session, //
      @RequestParam(value = "score", defaultValue = "") String score) {

    UserScoreDTO sessionUser = (UserScoreDTO) session.getAttribute("session_user");
    if (sessionUser != null) {
      Boolean uploadScoreResult = scoreService
          .uploadMyScore(Long.valueOf(score), new Date(), sessionUser.getUsername());
      return new RestDTO(uploadScoreResult, uploadScoreResult ? "" : "ERR_UPLOAD_1", "");
    } else {
      return new RestDTO(false, "ERR_UPLOAD_2", "");
    }

  }

}
