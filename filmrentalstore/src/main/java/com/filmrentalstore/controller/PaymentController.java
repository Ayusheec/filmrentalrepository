package com.filmrentalstore.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmrentalstore.dto.PaymentDTO;
import com.filmrentalstore.model.Film;
import com.filmrentalstore.model.Payment;
import com.filmrentalstore.model.Store;
import com.filmrentalstore.service.PaymentService;

@RestController
@RequestMapping("/api/payment")
@CrossOrigin(origins = "http://localhost:5173")
public class PaymentController {
	
	private final PaymentService paymentService;
	 
    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
 
    
    @PostMapping("/add")
    public String addPayment(@RequestBody PaymentDTO paymentDTO) {
        return paymentService.addPayment(paymentDTO);
    }
    
    @GetMapping("/revenue/datewise")
    public List<PaymentDTO> getCumulativeRevenueByDate() {
        List<Object[]> revenueData = paymentService.getCumulativeRevenueByDate();
        return revenueData.stream()
                .map(data -> {
                    PaymentDTO dto = new PaymentDTO();
                    dto.setPaymentDate((LocalDateTime) data[0]);
                    dto.setAmount((Long) data[1]);
                    return dto;
                })
                .collect(Collectors.toList());
    }
    
    @GetMapping("/datewise/store/{id}")
    public List<Object[]> getRevenueByStore(@PathVariable("id") long storeId) {
        return paymentService.calculateRevenueByStore(storeId);
    }
    
    @GetMapping("/revenue/filmwise")
    public ResponseEntity<List<?>> getFilmwiseRevenue() {
        List<?> revenueData = paymentService.getFilmwiseRevenue();
        return ResponseEntity.ok(revenueData);
    }
    
    @GetMapping("/revenue/film/{id}")
    public List<Object[]> getCumulativeRevenueByFilm(@PathVariable Long id) {
        Film film = new Film();
        film.setFilm_id(id); // Assuming Film is retrieved by its ID
        return paymentService.calculateCumulativeRevenueByFilm(film);
    }
    
    @GetMapping("/revenue/films/store/{id}")
    public List<Object[]> getCumulativeRevenueByStore(@PathVariable Long id) {
        Store store = new Store();
        store.setStore_id(id); // Assuming the store is fetched by its ID
        return paymentService.calculateCumulativeRevenueByStore(store);
    }
    
    @GetMapping("/fetch-payment")
    public ResponseEntity<List<Payment>> viewAll() {
        List<Payment> paymentList = paymentService.fetchAll();
        return ResponseEntity.ok(paymentList);
    }
}
