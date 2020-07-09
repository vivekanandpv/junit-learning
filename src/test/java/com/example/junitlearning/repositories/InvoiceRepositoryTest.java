package com.example.junitlearning.repositories;

import com.example.junitlearning.domain.Invoice;
import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("InvoiceRepository should")
@Tag("WIP")
class InvoiceRepositoryTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("return a not null list when getList() is called")
    void getListReturnsANotNullList() {
        InvoiceRepository repository = new InvoiceRepository();
        List<Invoice> list = repository.getList();
        assertNotNull(list, "List is null");
    }

    @Test
    void initialSizeOfListIsZero() {
        InvoiceRepository repository = new InvoiceRepository();
        assertEquals(0, repository.getList().size());
    }

    @Test
    @DisplayName("correctly add the invoices to the list")
    void addingInvoiceAddsItToTheList() {
        InvoiceRepository repository = new InvoiceRepository();

        assertAll(
                () -> assertEquals(0, repository.getList().size()),
                () -> {
                    repository.addInvoice(new Invoice());
                    assertEquals(1, repository.getList().size());
                },
                () -> {
                    repository.addInvoice(new Invoice());
                    assertEquals(2, repository.getList().size());
                }
        );
    }

    @Test
    void simplyThrowExceptionThrowsRuntimeException() {
        InvoiceRepository repository = new InvoiceRepository();
        Throwable error = assertThrows(RuntimeException.class, () -> repository.simplyThrowException());
        assertEquals("Some exception", error.getMessage());
    }
}