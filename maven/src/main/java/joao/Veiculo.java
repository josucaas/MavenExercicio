package joao;

public class Veiculo{
    private String placa, marca, cor, categoria;

    public Veiculo(String placa, String marca, String cor, String categoria){
        this.placa = placa;
        this.marca = marca;
        this.cor = cor;
        this.categoria = categoria;
    }

    public String getPlaca(){
        return placa;
    }

    public String getMarca(){
        return marca;
    }

    public String getCor(){
        return cor;
    }

    public String getCategoria(){
        return categoria;
    }
}