package br.edu.faseh.lista;

public class Mozilla {
    private FasehPilha<String> backStack;    // Pilha para voltar
    private FasehPilha<String> forwardStack; // Pilha para avançar
    private String paginaAtual;

    public Mozilla() {
        // Ao iniciar, nenhuma pilha existe
        this.backStack = null;
        this.forwardStack = null;
        this.paginaAtual = null;
    }

    public void visitarPagina(String url) {
        // Ao digitar o primeiro endereço, adiciona à pilha de voltar
        if (backStack == null) {
            backStack = new FasehPilha<>();
        }

        if (paginaAtual != null) {
            backStack.push(paginaAtual);
        }

        paginaAtual = url;

        // Sempre que visitamos uma nova página, o histórico de "Avançar" é limpo
        forwardStack = null;
        verificarEliminacao(); // Garante a eliminação de pilhas vazias
    }

    public void voltar() {
        // Ao voltar, o topo vai para a pilha de avançar
        if (backStack != null && !backStack.isEmpty()) {
            if (forwardStack == null) forwardStack = new FasehPilha<>();

            forwardStack.push(paginaAtual);
            paginaAtual = backStack.pop();

            verificarEliminacao(); //
        }
    }

    public void avancar() {
        // Ao avançar, o topo vai para a pilha de voltar
        if (forwardStack != null && !forwardStack.isEmpty()) {
            if (backStack == null) backStack = new FasehPilha<>();

            backStack.push(paginaAtual);
            paginaAtual = forwardStack.pop();

            verificarEliminacao(); //
        }
    }

    // As pilhas vazias devem ser eliminadas
    private void verificarEliminacao() {
        if (backStack != null && backStack.isEmpty()) {
            backStack = null;
        }
        if (forwardStack != null && forwardStack.isEmpty()) {
            forwardStack = null;
        }
    }

    public void Status() {
        System.out.println("\n Status do Navegador ");
        System.out.println("Página Atual: " + (paginaAtual != null ? paginaAtual : "null"));
        System.out.println("Botão Voltar: " + (backStack != null ? "Ativado" : "Desativado"));
        System.out.println("Botão Avançar: " + (forwardStack != null ? "Ativado" : "Desativado"));
        System.out.println("Pilha Voltar: " + backStack);
        System.out.println("Pilha Avançar: " + forwardStack);
    }
}
