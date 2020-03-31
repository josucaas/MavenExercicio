package joao;

public class Passageiro{
    private String CPF;
    private String nome;
    private FormaPagamento pagamento;
    private String numCartao;

    public Passageiro(String CPF, String nome, FormaPagamento pagamento, String numCartao){
        this.CPF = CPF;
        this.nome = nome;
        this.pagamento = pagamento;
        this.numCartao = numCartao;
    }

    public String getCPF(){
        return CPF;
    }

    
    public String getNome(){
        return nome;
    }

    
    public FormaPagamento getPagamento(){
        return pagamento;
    }
    
    public String getnumCartao(){
        return numCartao;
    }
}