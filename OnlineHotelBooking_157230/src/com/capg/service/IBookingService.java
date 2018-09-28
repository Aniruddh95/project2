package com.capg.service;

import java.util.ArrayList;

import com.capg.bean.BookingDetails;
import com.capg.bean.HotelDetails;

public interface IBookingService {

	ArrayList<HotelDetails> getHotelDetails();

	HotelDetails addBookingDetails(BookingDetails booking);

}
