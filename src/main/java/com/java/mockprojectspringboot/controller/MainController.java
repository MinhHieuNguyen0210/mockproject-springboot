package com.java.mockprojectspringboot.controller;

import com.java.mockprojectspringboot.entity.Category;
import com.java.mockprojectspringboot.entity.Question;
import com.java.mockprojectspringboot.entity.QuestionList;
import com.java.mockprojectspringboot.entity.User;
import com.java.mockprojectspringboot.repository.CategoryRepository;
import com.java.mockprojectspringboot.repository.UserRepository;
import com.java.mockprojectspringboot.service.CateService;
import com.java.mockprojectspringboot.service.QuizService;
import com.java.mockprojectspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    User userResult;
    @Autowired
    QuizService quizService;

	@Autowired
	CateService cateService;

	@Autowired
	UserRepository userRepository;
	Boolean submitted = false;

	@Autowired
    UserService userService;

    @ModelAttribute("result")
    public User getUserResult() {
        return userResult;
    }


	@GetMapping("/")
	public String home(Model model) {
		List<Category> listCate = cateService.getCate();
		model.addAttribute("ListCate", listCate);

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User user = new User();

		user = userService.findUserByEmail(email);
		model.addAttribute("UserName",user.getUsername());

		return "index.html";
	}

	@GetMapping("/login")
	public String login() {
		return "new-login";
	}

    @GetMapping("/categories")
	public String category(Model model){
    	model.addAttribute("category", new Category());


    	return "category";}

	@PostMapping("/categories/create")
	public ModelAndView createCategory(@ModelAttribute("category") Category category){
		cateService.createCategory(category);

		return new ModelAndView("redirect:/question?id="+category.getId());
	}

	@GetMapping ("/question")
	public String viewQuestionCreate(Model model){
    	model.addAttribute("question", new Question());
    	return "quiz-create";
	}
	@PostMapping("/question/{id}")
	public ModelAndView createQuestion(@ModelAttribute("question") Question question, @PathVariable(value = "id") String idCate){
		int id = Integer.parseInt(idCate);
		Category category = new Category();
		category.setId(id);
    	question.setCate(category);

   	quizService.saveQuestion(question);
   	return new ModelAndView("redirect:/question?id="+question.getCate().getId());
	}

    @PostMapping("/quiz")
    public String quiz( Model model, RedirectAttributes redirectAttributes) {
//        if (username.equals("")) {
//            redirectAttributes.addFlashAttribute("warning", "You must enter your name");
//            return "redirect:/";
//        }
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = authentication.getName();

		userResult = userRepository.findByEmail(email);
		submitted = false;

		QuestionList questionList = quizService.getQuestions();
		model.addAttribute("questionList", questionList);

		return "quiz.html";
	}


	@GetMapping("/quizz")
	public String quizByCate(Model model, @RequestParam("id") int idCate) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = authentication.getName();
		System.out.println(email);

		userResult = userRepository.findByEmail(email);
		submitted = false;

		Optional<Category> cate = cateService.findById(idCate);
		
		QuestionList questionList = quizService.getQuestionByCate(cate.get());
	
		model.addAttribute("questionList2", questionList);
		return "quiz2";
	}

	@PostMapping("/submit")
	public String submit(@ModelAttribute QuestionList questionList, Model model) {
		if (!submitted) {
			userResult.setTotalCorrect(quizService.getUserResult(questionList));

			quizService.saveScore(userResult);
			submitted = true;

		}
		return "result.html";
	}

	@GetMapping("/score")
	public String score(Model m) {
		List<User> scoreList = quizService.getTopScore();
		m.addAttribute("ScoreList", scoreList);

		return "scoreboard.html";
	}

}