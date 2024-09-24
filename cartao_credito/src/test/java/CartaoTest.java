import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.pm.business.Cartao;

public class CartaoTest {

    @Test

    void testCartao() {
        Cartao cartao = new Cartao(12345, "abcdefg", 5000, LocalDate.of(2024, 12, 8));

        assertNotNull(cartao);

    }


    @Test
    void testCompra(){
        Cartao cartao = new Cartao(12345, "abcdefg", 5000, LocalDate.of(2024, 12, 8));
     
        assertTrue(cartao.Compra(4000));

    }

    @Test 
    void testPagarfatura(){
        Cartao cartao = new Cartao(12345, "abcdefg", 5000, LocalDate.of(2024, 12, 8));

        cartao.Compra(3000);
        assertEquals(3000, cartao.getFatura());
        assertEquals(2000, cartao.getLimiteCredito());

        // Paga 1000 da fatura
        cartao.pagarFatura(1000);
        assertEquals(2000, cartao.getFatura());
        assertEquals(2000, cartao.getLimiteCredito());

        // Paga o restante da fatura
        cartao.pagarFatura(2000);
        assertEquals(0, cartao.getFatura());
        assertEquals(2000, cartao.getLimiteCredito());

    }

    @Test
    void testAumentarLimite(){
        Cartao cartao = new Cartao(12345, "abcdefg", 5000, LocalDate.of(2024, 12, 8));
        cartao.Compra(2000);
        assertEquals(3000, cartao.getLimiteCredito());
        cartao.pagarFatura(2000);
        assertEquals(0, cartao.getFatura());
        cartao.aumetarLimite(10000);
        assertEquals(13000, cartao.getLimiteCredito());

    }



}
