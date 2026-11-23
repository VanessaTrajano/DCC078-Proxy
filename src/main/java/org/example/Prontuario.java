package org.example;

import java.util.Arrays;
import java.util.List;

public class Prontuario implements IProntuario {

    private Integer codigo;
    private String nomePaciente;
    private String tipoSanguineo;
    private String diagnostico;
    private String medicacao;

    public Prontuario(int codigo) {
        this.codigo = codigo;
        Prontuario objeto = BD.getProntuario(codigo);
        this.nomePaciente = objeto.nomePaciente;
        this.tipoSanguineo = objeto.tipoSanguineo;
        this.diagnostico = objeto.diagnostico;
        this.medicacao = objeto.medicacao;
    }

    public Prontuario(Integer codigo, String nomePaciente, String tipoSanguineo, String diagnostico, String medicacao) {
        this.codigo = codigo;
        this.nomePaciente = nomePaciente;
        this.tipoSanguineo = tipoSanguineo;
        this.diagnostico = diagnostico;
        this.medicacao = medicacao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    @Override
    public List<String> obterDadosBasicos() {
        return Arrays.asList(this.nomePaciente, this.tipoSanguineo);
    }

    @Override
    public List<String> obterHistoricoClinico(ProfissionalSaude profissional) {
        return Arrays.asList(this.diagnostico, this.medicacao);
    }
}
