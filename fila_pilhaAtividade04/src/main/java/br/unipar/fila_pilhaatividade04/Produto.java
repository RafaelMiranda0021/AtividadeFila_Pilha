package br.unipar.fila_pilhaatividade04;


public class Produto {
    private int codProduto;
    private String descricao;
    private String dataEntrada;
    private String ufOrigem;
    private String ufDestino;

    public Produto(int codProduto, String descricao, String dataEntrada, String ufOrigem, String ufDestino) {
        this.codProduto = codProduto;
        this.descricao = descricao;
        this.dataEntrada = dataEntrada;
        this.ufOrigem = ufOrigem;
        this.ufDestino = ufDestino;
    }

    @Override
    public String toString() {
        return "Código: " + codProduto + ", Descrição: " + descricao + ", Data de Entrada: " + dataEntrada + 
               ", UF Origem: " + ufOrigem + ", UF Destino: " + ufDestino;
    }
}
