package com.example.junitlearning.controllers;

import com.example.junitlearning.domain.Invoice;
import com.example.junitlearning.services.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvoiceController {
    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public List<Invoice> getAll() {
        return this.invoiceService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable long id) {
        try {
            return new ResponseEntity(this.invoiceService.get(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Invoice invoice) {
        this.invoiceService.add(invoice);
        return ResponseEntity.ok().build();
    }
}
