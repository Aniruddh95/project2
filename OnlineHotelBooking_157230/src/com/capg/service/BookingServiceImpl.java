package com.capg.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.bean.BookingDetails;
import com.capg.bean.HotelDetails;
import com.capg.dao.IBookingDAO;


@Service
public class BookingServiceImpl implements IBookingService {

	@Autowired
	private IBookingDAO bDao;
	
	@Override
	public ArrayList<HotelDetails> getHotelDetails() {
		
		return bDao.getHotelDetails();
	}

	@Override
	public HotelDetails addBookingDetails(BookingDetails booking) {
		
		return bDao.addBookingDetails(booking);
	}

}
