package com.capg.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capg.bean.BookingDetails;
import com.capg.bean.HotelDetails;
import com.capg.service.IBookingService;


@Controller
public class BookingController {
	
	@Autowired
	private IBookingService bService;
	
	@RequestMapping("/hotels")
	public String getHotelDetails(Model model)
	{
		
		ArrayList<HotelDetails> list = new ArrayList<>();
		
		list = bService.getHotelDetails();
		
		model.addAttribute("hotelList", list);
		
		return "HotelDetails";
	}
	
	@RequestMapping("/booking")
	public String getBookingDetails(@RequestParam("id") String id, @RequestParam("name") String name, Model model, HttpServletRequest request)
	{
		
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		HttpSession session = request.getSession();
		session.setAttribute("hId", id);
		session.setAttribute("hName", name);
		model.addAttribute("obj", new BookingDetails());
		
		return "HotelBooking";
	}
	
	@RequestMapping("/bdetails")
	public String getBookingDetails(@ModelAttribute("obj")@Valid BookingDetails booking,BindingResult bindingResult, Model model, HttpServletRequest request)
	{
		///////////////
		
		/////////
		
		boolean hasError = bindingResult.hasErrors();
		if (hasError) {
			
			
			
			return "HotelBooking";
			
		}
		else
		{
		HttpSession session = request.getSession();
		
		String hId = session.getAttribute("hId").toString();
		int hotelId = Integer.parseInt(hId);
		booking.setHotelId(hotelId);
		
		HotelDetails detail = bService.addBookingDetails(booking);
		
		model.addAttribute("bookingDetails", booking);
		model.addAttribute("hotelDetails", detail);
		return "BookingConfirmation";
		}
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
