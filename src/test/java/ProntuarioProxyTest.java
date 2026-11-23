import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ProntuarioProxyTest {

    @BeforeEach
    void setUp() {
        BD.addProntuario(new Prontuario(1, "João", "O+", "Gripe", "Paracetamol"));
        BD.addProntuario(new Prontuario(2, "Maria", "A-", "Hipertensão", "Losartana"));
    }

    @Test
    void deveRetornarDadosBasicosProntuario() {
        ProntuarioProxy prontuario = new ProntuarioProxy(1);

        assertEquals(Arrays.asList("João", "O+"), prontuario.obterDadosBasicos());
    }

    @Test
    void deveRetornarHistoricoClinicoProntuario() {
        ProfissionalSaude profissional = new ProfissionalSaude("Ana", true);
        ProntuarioProxy prontuario = new ProntuarioProxy(2);

        assertEquals(Arrays.asList("Hipertensão", "Losartana"), prontuario.obterHistoricoClinico(profissional));
    }

    @Test
    void deveRetornarExcecaoProfissionalNaoAutorizadoConsultarHistoricoClinico() {
        try {
            ProfissionalSaude profissional = new ProfissionalSaude("Joana", false);
            ProntuarioProxy prontuario = new ProntuarioProxy(2);

            prontuario.obterHistoricoClinico(profissional);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Profissional não autorizado", e.getMessage());
        }
    }
}