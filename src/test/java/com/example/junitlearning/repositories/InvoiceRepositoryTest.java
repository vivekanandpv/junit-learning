package com.example.junitlearning.repositories;

import com.example.junitlearning.domain.Invoice;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceRepositoryTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getList() {
        InvoiceRepository repository = new InvoiceRepository(new ArrayList<>());
        List<Invoice> list = repository.getList();
        assertNotNull(list);
    }

    @Test
    void addInvoice() {
        InvoiceRepository repository = new InvoiceRepository(new ArrayList<>());
        assertEquals(0, repository.getList().size());
        repository.addInvoice(new Invoice());
        assertEquals(1, repository.getList().size());
    }

    @Test
    void getInvoice() {
        InvoiceRepository repository = new InvoiceRepository(new ArrayList<>());
        assertThrows(RuntimeException.class, () -> repository.simplyThrowException());
        assertThrows(RuntimeException.class, () -> repository.simplyThrowException(), "Some exception");
    }
}