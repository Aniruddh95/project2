package com.capg.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capg.bean.BookingDetails;
import com.capg.bean.HotelDetails;

@Transactional
@Repository
public class BookingDAOImpl implements IBookingDAO {

	@PersistenceContext
	private EntityManager eManager;

	@Override
	public ArrayList<HotelDetails> getHotelDetails() {
		
		ArrayList<HotelDetails> list = new ArrayList<>();
		String getAllDetails = "select hotel from HotelDetails hotel";
		TypedQuery<HotelDetails> hotelDetails = eManager.createQuery(getAllDetails, HotelDetails.class);
		list = (ArrayList<HotelDetails>) hotelDetails.getResultList();
		
		
		return list;
	}

	@Override
	public HotelDetails addBookingDetails(BookingDetails booking) {
		
		
		eManager.persist(booking);
		HotelDetails  details =eManager.find(HotelDetails.class, booking.getHotelId());
		
		return details;
	}
	
}
