package joao;

public class Motorista {
    private String cpf, nome;
    private Veiculo veiculo;
    private FormaPagamento formaPagto;

    public Motorista(String cpf, String nome, FormaPagamento formaPagto) {
        this.cpf = cpf;
        this.nome = nome;
        this.formaPagto = formaPagto;
    }


    public Motorista(String cpf, String nome, Veiculo veiculo, FormaPagamento formaPagto) {
        this.cpf = cpf;
        this.nome = nome;
        this.veiculo = veiculo;
        this.formaPagto = formaPagto;
    }
    
    public FormaPagamento getFormaPagto() {
        return formaPagto;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }
    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }

}