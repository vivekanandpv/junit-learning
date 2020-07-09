package com.example.junitlearning.repositories;

import com.example.junitlearning.domain.Invoice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IRepository {
    List<Invoice> getList();
    void addInvoice(Invoice invoice);
    Optional<Invoice> getInvoice(long id);
}
