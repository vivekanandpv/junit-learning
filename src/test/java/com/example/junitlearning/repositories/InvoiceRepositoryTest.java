package com.example.junitlearning.repositories;

import com.example.junitlearning.domain.Invoice;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceRepositoryTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Start Test Class");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("End of Test Class");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Initializing test case");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Finished test case");
    }

    @Test
    void getList() {
        //  1. Arrange
        InvoiceRepository repository = new InvoiceRepository();

        //  2. Act
        List<Invoice> list = repository.getList();

        //  3. Assert
        assertNotNull(list);
    }

    @Test
    void addInvoice() {
    }

    @Test
    void getInvoice() {
    }
}