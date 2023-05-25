package univesp.pi.grupo3.maua.fichadimensionalbackend;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FichaDimensionalBackendApplicationTests {

    @Test
    void test() {
        String obj = new String("obj");
        assertEquals("obj", obj);
    }
}
