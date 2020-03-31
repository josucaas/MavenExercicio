package joao;

import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
       rodaMotoristas(); 
       rodaVeiculos();
       rodaPassageiros();
    }

    public static void rodaVeiculos() throws IOException {
        PersistenciaVeiculos teste = new PersistenciaVeiculos(); 
        List<Veiculo> veiculos = teste.carregaVeiculos();
        for(Veiculo v : veiculos){
            System.out.println(v.getPlaca());
            System.out.println(v.getMarca());
            System.out.println(v.getCor());
            System.out.println(v.getCategoria());
        }
        veiculos.add(new Veiculo("MERDA KKKKKK", "AVON", "AZUL", "PEQUENO"));
        teste.persistenciaVeiculos(veiculos);
    }

    public static void rodaMotoristas(){
        PersistenciaMotoristas teste = new PersistenciaMotoristas(); 
        List<Motorista> motoristas = teste.carregaMotoristas();
        for(Motorista v : motoristas){
            System.out.println(v.getCpf());
            System.out.println(v.getNome());
            System.out.println(v.getFormaPagto());
        }
        motoristas.add(new Motorista("038.777", "John Cena", FormaPagamento.CARTAO));
        teste.persistenciaMotoristas(motoristas);
    }

    public static void rodaPassageiros() {
        PersistenciaPassageiros teste = new PersistenciaPassageiros();
        List<Passageiro> passageiros = teste.carregaPassageiros();
        for(Passageiro p : passageiros){
            System.out.println(p.getCPF());
            System.out.println(p.getNome());
            System.out.println(p.getPagamento());
            System.out.println(p.getnumCartao());
        }
        passageiros.add(new Passageiro("123450", "Mike Tyson", FormaPagamento.TODAS, "666"));
        teste.persistenciaPassageiros(passageiros);
    }
}

