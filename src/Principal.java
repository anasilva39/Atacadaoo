
import java.util.HashMap;
import java.util.Scanner;


public class Principal {

    public static void main(String[] args) {
        // Criação dos produtos
        Produto cafe = new Produto(1, "Café 1kg", 53.00);
        Produto sabao = new Produto(2, "Sabão em pó", 36.00);
        Produto leite = new Produto(3, "Caixa de Leite", 82.00);
        Produto refrigerante = new Produto(4, "Refrigerante", 8.50);

        // Mapeamento dos produtos por ID
        HashMap<Integer, Produto> produtos = new HashMap<>();
        produtos.put(cafe.id, cafe);
        produtos.put(sabao.id, sabao);
        produtos.put(leite.id, leite);
        produtos.put(refrigerante.id, refrigerante);

        // Criação da caixa do atacado
        CaixaDoAtacado caixa = new CaixaDoAtacado();

        // Leitura da entrada
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha o método de pagamento (debito, dinheiro, credito):");
        String metodoPagamento = scanner.nextLine();
        caixa.setMetodoPagamento(metodoPagamento);

        System.out.println("Cardápio:");
        System.out.println("1 - Café 1kg - R$53,00");
        System.out.println("2 - Sabão em pó - R$36,00");
        System.out.println("3 - Caixa de Leite - R$82,00");
        System.out.println("4 - Refrigerante - R$8,50");
        System.out.println("Digite o ID do produto e a quantidade, separados por vírgula. Digite 'fim' para terminar.");

        while (true) {
            String linha = scanner.nextLine();
            if (linha.equals("fim")) {
                break;
            }
            String[] campos = linha.split(",");
            int id = Integer.parseInt(campos[0]);
            int quantidade = Integer.parseInt(campos[1]);
            Produto produto = produtos.get(id);
            caixa.adicionarCompra(new Compra(produto, quantidade));
        }

        // Cálculo e exibição do total
        System.out.println("O valor total é: " + caixa.calcularTotal());
    }
    }
    
    
    

