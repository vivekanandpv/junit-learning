package com.example.junitlearning.services;

import com.example.junitlearning.domain.Invoice;
import com.example.junitlearning.repositories.InvoiceRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class InvoiceServiceTest {
    @Mock
    private InvoiceRepository invoiceRepository;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAll() {
        when(invoiceRepository.getList())
                .thenReturn(new ArrayList<Invoice>());

        InvoiceService service = new InvoiceService(invoiceRepository);

        assertNotNull(service.getAll());
    }

    @Test
    void get() {
        when(invoiceRepository.getInvoice(1))
                .thenReturn(Optional.empty());

        InvoiceService service = new InvoiceService(invoiceRepository);
        assertThrows(RuntimeException.class, () -> service.get(1), "Invoice not found");
    }
}