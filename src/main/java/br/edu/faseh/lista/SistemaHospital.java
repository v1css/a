package br.edu.faseh.lista;

public class SistemaHospital {
    private FasehFila<Paciente> filaEspera = new FasehFila<>();
    private FasehList<Paciente> historicoAtendimento = new FasehList<>();
    private int contadorSenha = 1; // A contagem continua a sequência

    public void gerarSenha() {
        Paciente novo = new Paciente(contadorSenha++);
        filaEspera.enqueue(novo);
        System.out.println("Paciente adicionado à fila.");
    }

    public void chamarProximo() {
        // Chama o próximo apenas se houverem pessoas na fila
        if (filaEspera.isEmpty()) {
            System.out.println("Atenção: Não há pacientes na fila!");
            return;
        }

        Paciente atendido = filaEspera.dequeue();
        historicoAtendimento.insertAtEnd(atendido); // Salva no histórico
        System.out.println(">>> Chamando para atendimento: " + atendido);
    }

    public void exibirStatus() {
        System.out.println("\n--- STATUS DO HOSPITAL ---");
        System.out.println("Fila atual: " + filaEspera);
        System.out.println("Histórico de Chamadas: " + historicoAtendimento);
    }
}
