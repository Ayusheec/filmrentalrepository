package com.filmrentalstore.service;

import java.util.List;
import java.util.Map;

import com.filmrentalstore.dto.PaymentDTO;
import com.filmrentalstore.model.Film;
import com.filmrentalstore.model.Payment;
import com.filmrentalstore.model.Store;

public interface PaymentService {
	public String addPayment(PaymentDTO paymentDTO);
	 public List<Object[]> getCumulativeRevenueByDate();
	 public List<Object[]> calculateRevenueByStore(long storeId);
	 public List<Map<String, Object>> getFilmwiseRevenue();
	 public List<Object[]> calculateCumulativeRevenueByFilm(Film film);
	 public List<Object[]> calculateCumulativeRevenueByStore(Store store);
	 public List<Payment>fetchAll();
}
