package com.cg.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;





import com.cg.bean.Grocery;
import com.cg.service.GroceryService;

@Controller
public class GroceryController {

	
	
	@Autowired
	private GroceryService gService;

	@RequestMapping("/addGrocery")
	public String showGroceryForm(Model model) {
		
		
		System.out.println("show groc form");
		List<String> catList = gService.getCategoryList();

		model.addAttribute("clist", catList);
		model.addAttribute("grocery", new Grocery());
		return "addgrocery";
	}

	@RequestMapping("/submitGrocery")
	public String showGroceryDetails(
			@ModelAttribute("grocery") @Valid Grocery grocery,
			BindingResult bindingResult, Model model) {

		boolean hasError = bindingResult.hasErrors();
		if (hasError) {

			List<String> catList = gService.getCategoryList();

			model.addAttribute("clist", catList);

			return "addgrocery";

		} else {

			boolean check = gService.saveGrocery(grocery);

			return "submitgrocery";
		}
	}

	@RequestMapping("/retrieveGrocery")
	public String showAllGrocery(Model model) {
		List<Grocery> list = new ArrayList<Grocery>();
		list = gService.getAllDetails();
		System.out.println(list);
		model.addAttribute("details", list);

		return "allDetails";
	}
	
	
	@RequestMapping("/remove")
	public String deleteItem(Model model)
	{
		
		model.addAttribute("item", new Grocery());
		return "delete";
	}
	
	
	@RequestMapping("/deletem")
	public String remove(@RequestParam("id") String id,Model model)
	{
		int n = Integer.parseInt(id);
		
		gService.deleteItem(n);
		
		System.out.println(id);
		
		return "message";
	}
	

	@ExceptionHandler(Exception.class)
	public ModelAndView handleError(Exception e) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("err", e);
		mav.setViewName("dataError");
		System.out.println(e.getMessage());

		return mav;

	}

}
