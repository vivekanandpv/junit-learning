package com.example.junitlearning.controllers;

import com.example.junitlearning.domain.Invoice;
import com.example.junitlearning.services.InvoiceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class InvoiceControllerTest {
    @Mock
    private InvoiceService invoiceService;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAll() {
        //  Arrange
        InvoiceController controller = new InvoiceController(invoiceService);

        //  act
        List<Invoice> all = controller.getAll();

        //  assert
        assertNotNull(all);
    }

    @Test
    void getById() {
        when(invoiceService.get(123))
                .thenReturn(new Invoice());

        InvoiceController controller = new InvoiceController(invoiceService);

        ResponseEntity<Invoice> byId = controller.getById(123);

        assertAll(
                () -> assertEquals(byId.getStatusCode(), HttpStatus.OK),
                () -> assertNotNull(byId.getBody()),
                () -> assertTrue(byId.getBody() instanceof Invoice)
        );
    }

    @Test
    void create() {
        InvoiceController controller = new InvoiceController(invoiceService);

        ResponseEntity<?> responseEntity = controller.create(new Invoice());

        assertAll(
                () -> assertEquals(responseEntity.getStatusCode(), HttpStatus.OK),
                () -> assertNotNull(responseEntity),
                () -> assertFalse(responseEntity.hasBody())
        );
    }
}