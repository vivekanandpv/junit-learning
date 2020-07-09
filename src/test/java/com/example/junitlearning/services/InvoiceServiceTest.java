package com.example.junitlearning.services;

import com.example.junitlearning.domain.Invoice;
import com.example.junitlearning.repositories.IRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


@DisplayName("InvoiceService should")
class InvoiceServiceTest {
    @Mock
    private IRepository invoiceRepository;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("have the underlying getList() of type ArrayList")
    void listIsArrayList() {
        when(invoiceRepository.getList())
                .thenReturn(new ArrayList<Invoice>());

        InvoiceService service = new InvoiceService(invoiceRepository);

        assertTrue(service.getAll() instanceof ArrayList);
    }

    @Test
    @DisplayName("throw RuntimeException when id doesn't exist")
    void throwsRuntimeException() {
        when(invoiceRepository.getInvoice(1))
                .thenReturn(Optional.empty());

        InvoiceService service = new InvoiceService(invoiceRepository);
        assertThrows(RuntimeException.class, () -> service.get(1));
    }
}