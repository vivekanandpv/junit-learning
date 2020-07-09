package com.example.junitlearning.repositories;

import com.example.junitlearning.domain.Invoice;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class InvoiceRepository implements IRepository {
    private final List<Invoice> invoices;

    public InvoiceRepository(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public List<Invoice> getList() {
        return this.invoices;
    }

    public void addInvoice(Invoice invoice) {
        this.invoices.add(invoice);
    }

    public Optional<Invoice> getInvoice(long id) {
        return this.invoices
                .stream()
                .filter(i -> i.getId() == id)
                .findFirst();
    }

    public Invoice simplyThrowException() {
        throw new RuntimeException("Some exception");
    }
}
