package com.capg.dao;

import java.util.ArrayList;

import com.capg.bean.BookingDetails;
import com.capg.bean.HotelDetails;

public interface IBookingDAO {

	ArrayList<HotelDetails> getHotelDetails();

	HotelDetails addBookingDetails(BookingDetails booking);

}
