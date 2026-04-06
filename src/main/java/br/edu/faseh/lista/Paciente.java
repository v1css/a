package br.edu.faseh.lista;

public class Paciente {
    private int senha;

    public Paciente(int senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Senha #" + senha + " - ";
    }
}
