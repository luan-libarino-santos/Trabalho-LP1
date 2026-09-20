package restaurante;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        

        Produto hamburguer = new Produto("Hamburguer", 25.00, true);
        Produto suco = new Produto("Suco", 8.00, true);
        Produto refrigerante = new Produto("Refrigerante", 10.00, true);
        Produto batataFrita = new Produto("Batata Frita", 6.00, true);
        Produto milkShake = new Produto("Milkshake", 15.00, false);
        

        Mesa[] mesas = {new Mesa(1, true), new Mesa(2, true)};
        Pedido[] pedidosAtivos = new Pedido[2];
        int[] quantidadeItens = new int[2];
        Pedido[] historico = new Pedido[100];
        int totalFinalizados = 0;
        

        int opcao = 1;
        while (opcao != 0) {
            System.out.println("\n --RESTAURANTE--");
            System.out.println("Mesa 1 disponivel? " + mesas[0].isDisponivel());
            System.out.println("Mesa 2 disponivel? " + mesas[1].isDisponivel());
            System.out.println("1 - Abrir pedido");
            System.out.println("2 - Adicionar produto");
            System.out.println("3 - Consultar pedido da mesa");
            System.out.println("4 - Finalizar pedido da mesa");
            System.out.println("5 - Ver pedidos finalizados");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = entrada.nextInt();
            

            if (opcao >= 1 && opcao <= 4) {
                System.out.print("Numero da mesa (1 ou 2): ");
                int numero = entrada.nextInt();

                if (numero != 1 && numero != 2) {
                    System.out.println("Mesa inexistente.");
                } else {
                    int indice = numero - 1;
                    Pedido pedido = pedidosAtivos[indice];

                    if (opcao == 1) {
                        if (!mesas[indice].isDisponivel()) {
                            System.out.println("Essa mesa ja tem um pedido ativo.");
                        } else if (totalFinalizados == historico.length) {
                            System.out.println("O historico esta cheio.");
                        } else {
                            entrada.nextLine();
                            System.out.print("Nome do cliente: ");
                            String nome = entrada.nextLine();
                            System.out.print("CPF do cliente: ");
                            String cpf = entrada.nextLine();
                            Cliente cliente = new Cliente(nome, cpf);
                            pedidosAtivos[indice] = new Pedido(cliente, mesas[indice]);
                            quantidadeItens[indice] = 0;
                            System.out.println("Pedido aberto na mesa " + numero + ".");
                        }
                    } else if (pedido == null) {
                        System.out.println("Essa mesa nao tem pedido ativo.");
                    } else if (opcao == 2) {
                        System.out.println("1 - Hamburguer: R$ 25,00");
                        System.out.println("2 - Suco: R$ 8,00");
                        System.out.println("3 - Refrigerante: R$ 10,00");
                        System.out.println("4 - Batata Frita: R$ 6,00");
                        System.out.println("5 - Milkshake: R$ 15,00");
                        System.out.print("Produto: ");
                        int escolha = entrada.nextInt();

                        Produto produto = null;
                        if (escolha == 1) { 
                        	produto = hamburguer;
                        } else if (escolha == 2) {
                        	produto = suco;
                        } else if (escolha == 3) { 
                        	produto = refrigerante;
                        } else if (escolha == 4) { 
                        	produto = batataFrita;
                        } else if (escolha == 5) { 
                        	produto = milkShake;
                        }
                        

                        if (produto == null) {
                            System.out.println("Produto inexistente.");
                        } else if (!produto.isDisponivel()) {
                            System.out.println("Produto indisponivel.");
                        } else if (quantidadeItens[indice] == 100) {
                            System.out.println("O pedido ja tem 100 itens.");
                        } else {
                            System.out.print("Quantidade: ");
                            int quantidade = entrada.nextInt();
                            if (quantidade > 0) {
                                pedido.adicionarItem(produto, quantidade);
                                quantidadeItens[indice]++;
                                System.out.println("Produto adicionado.");
                            } else {
                                System.out.println("A quantidade deve ser maior que zero.");
                            }
                        }
                    } else if (opcao == 3) {
                        mostrarPedido(pedido);
                    } else if (opcao == 4) {
                        if (quantidadeItens[indice] == 0) {
                            System.out.println("Adicione pelo menos um item antes de finalizar.");
                        } else {
                            mostrarPedido(pedido);
                            pedido.finalizar();
                            historico[totalFinalizados] = pedido;
                            totalFinalizados++;
                            pedidosAtivos[indice] = null;
                            quantidadeItens[indice] = 0;
                            System.out.println("Pedido finalizado. Mesa liberada.");
                        }
                    }
                }
            } else if (opcao == 5) {
                if (totalFinalizados == 0) {
                    System.out.println("Nenhum pedido finalizado ainda.");
                } else {
                    for (int i = 0; i < totalFinalizados; i++) {
                        System.out.println("\nPedido finalizado " + (i + 1) + ":");
                        mostrarPedido(historico[i]);
                    }
                }
            } else if (opcao != 0) {
                System.out.println("Opcao invalida.");
            }
        }
        entrada.close();
    }

    public static void mostrarPedido(Pedido pedido) {
        System.out.println("Cliente: " + pedido.getCliente());
        System.out.println("Mesa: " + pedido.getMesa());
        System.out.println("Itens (produto e quantidade):");
        pedido.exibirItens(0);
        System.out.println("Total: R$ " + pedido.calcularTotal());
    }
}
