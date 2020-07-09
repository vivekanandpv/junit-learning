package com.example.junitlearning.services;

import com.example.junitlearning.domain.Invoice;
import com.example.junitlearning.repositories.IRepository;
import com.example.junitlearning.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {
    private final IRepository invoiceRepository;

    public InvoiceService(IRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public List<Invoice> getAll() {
        return this.invoiceRepository.getList();
    }

    public Invoice get(long id) {
        return this.invoiceRepository.getInvoice(id)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));
    }

    public void add(Invoice invoice) {
        this.invoiceRepository.addInvoice(invoice);
    }
}
