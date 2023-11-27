
import java.util.ArrayList;


public class CaixaDoAtacado {
     ArrayList<Compra> compras = new ArrayList<>();
    String metodoPagamento;

    public void adicionarCompra(Compra compra) {
        compras.add(compra);
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }
    
    

    public double calcularTotal() {
        double total = 0;
        for (Compra compra : compras) {
            double precoBase = compra.produto.preco * compra.quantidade;
            double desconto = 0;
            if (compra.quantidade > 25) {
                desconto = 0.25;
            } else if (compra.quantidade > 15) {
                desconto = 0.20;
            } else if (compra.quantidade > 5) {
                desconto = 0.10;
            }
            total += precoBase * (1 - desconto);
        }
        if (metodoPagamento.equals("dinheiro")) {
            total *= 0.95;
        } else if (metodoPagamento.equals("credito")) {
            total *= 1.03;
        }
        return total;
    }
}
