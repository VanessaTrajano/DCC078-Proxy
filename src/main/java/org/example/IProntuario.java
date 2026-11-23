package org.example;
import java.util.List;

public interface IProntuario {
    List<String> obterDadosBasicos();
    List<String> obterHistoricoClinico(ProfissionalSaude profissional);
}