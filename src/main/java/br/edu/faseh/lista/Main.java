package br.edu.faseh.lista;

public class Main {
    public static void main(String[] args) {
        // Teste navegador
        System.out.println("NAVEGADOR MOZILLA");
        Mozilla navegar = new Mozilla();

        System.out.println("Inicialização");
        navegar.Status(); // Pilhas vazias

        System.out.println("Primeira Navegação");
        navegar.visitarPagina("google.com");
        navegar.Status();

        System.out.println("Histórico de navegação");
        navegar.visitarPagina("github.com");
        navegar.visitarPagina("youtube.com");
        navegar.Status();

        System.out.println("\nVoltar no histórico navegação");
        navegar.voltar();
        navegar.Status();

        System.out.println("\nAvançar no histórico navegação");
        navegar.avancar();
        navegar.Status();

        System.out.println("\nLimpeza de Pilhas");
        // Voltando até o inicio da pilha
        navegar.voltar();
        navegar.voltar();
        navegar.Status();

        System.out.println("Teste Fila do Hospital");

        SistemaHospital hospital = new SistemaHospital();

        // Simulação de entrada
        hospital.gerarSenha();
        hospital.gerarSenha();
        hospital.gerarSenha();

        hospital.exibirStatus();

        // Simulação de chamadas
        hospital.chamarProximo();
        hospital.chamarProximo();

        hospital.exibirStatus();

        // Fila Vazia
        hospital.chamarProximo();
        hospital.chamarProximo(); // Deve avisar que está vazia
    }
}