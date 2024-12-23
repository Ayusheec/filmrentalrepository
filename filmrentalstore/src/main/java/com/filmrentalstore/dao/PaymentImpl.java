package com.filmrentalstore.dao;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmrentalstore.dto.PaymentDTO;
import com.filmrentalstore.model.Customer;
import com.filmrentalstore.model.Film;
import com.filmrentalstore.model.Payment;
import com.filmrentalstore.model.Rental;
import com.filmrentalstore.model.Staff;
import com.filmrentalstore.model.Store;
import com.filmrentalstore.repository.CustomerRepo;
import com.filmrentalstore.repository.PaymentRepo;
import com.filmrentalstore.repository.RentalRepo;
import com.filmrentalstore.repository.StaffRepo;
import com.filmrentalstore.service.PaymentService;

@Service
public class PaymentImpl implements PaymentService {
	
	private final PaymentRepo paymentRepo;
    private final CustomerRepo customerRepo;
    private final StaffRepo staffRepo;
    private final RentalRepo rentalRepo;
 
    @Autowired
    public PaymentImpl(PaymentRepo paymentRepo, CustomerRepo customerRepo, StaffRepo staffRepo, RentalRepo rentalRepo) {
        this.paymentRepo = paymentRepo;
        this.customerRepo = customerRepo;
        this.staffRepo = staffRepo;
        this.rentalRepo = rentalRepo;
    }
 
    @Override
    public String addPayment(PaymentDTO paymentDTO) {
        Customer customer = customerRepo.findById(paymentDTO.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        Staff staff = staffRepo.findById(paymentDTO.getStaffId())
                .orElseThrow(() -> new RuntimeException("Staff not found"));
        Rental rental = rentalRepo.findById(paymentDTO.getRentalId())
                .orElseThrow(() -> new RuntimeException("Rental not found"));
 
        Payment payment = new Payment();
        payment.setCustomer(customer);
        payment.setStaff(staff);
        payment.setRental(rental);
        payment.setAmount(paymentDTO.getAmount());
        payment.setPaymentDate(paymentDTO.getPaymentDate());
        payment.setLastUpdate(paymentDTO.getLastUpdate());
 
        
        paymentRepo.save(payment);
 
        return "Record Created Successfully";
    }
    
    public List<Object[]> getCumulativeRevenueByDate() {
        return paymentRepo.calculateRevenueByDate();
    }
    
    @Override
    public List<Object[]> calculateRevenueByStore(long storeId) {
        return paymentRepo.calculateRevenueByDate(storeId);
    }
    
    public List<Map<String, Object>> getFilmwiseRevenue() {
        List<Object[]> result = paymentRepo.getFilmwiseRevenue();
        
        return result.stream()
                .map(row -> Map.of(
                        "filmTitle", row[0],
                        "totalRevenue", row[1]
                ))
                .collect(Collectors.toList());
    }
    
    @Override
    public List<Object[]> calculateCumulativeRevenueByFilm(Film film) {
        return paymentRepo.findCumulativeRevenueByFilm(film);
    }
    
    @Override
    public List<Object[]> calculateCumulativeRevenueByStore(Store store) {
        return  paymentRepo.findCumulativeRevenueByStore(store);
    }
    
    @Override
    public List<Payment> fetchAll() {
        List<Payment> list =paymentRepo.findAll();
        return list;
    }
}
