import model.Cliente;
import repositories.ClienteRepository;

import javax.swing.*;



/**
 * @author: Diego Patrício
 * */
public class Application {
    public static void main(String[] args) {

        ClienteRepository cr = new ClienteRepository();

        //-------SALVAR E ATUALIZAR ---------
        //Cliente cliente = new Cliente();
        //cliente.setNome("FULANO");
        //cliente.setCpf("1245678951");
        //cr.salvarCliente(cliente);
        //-------------------------------------

        //-------------- LISTAR ---------------
        //Cliente cliente = cr.listarCliente(4);
        //System.out.println(cliente.getNome());
        //-------------------------------------

        //-------------- DELETAR -------------
        //cr.deletarCliente(1);
        //-------------------------------------
        String opcao = "", opcao2 = "";
        String menuPrincipal =
                "1 - Manutenção de Clientes \n"
                + "2 - Manutenção de Produtos \n"
                + "0 - Sair";

        while (!opcao.equals("0")) {
            opcao = JOptionPane.showInputDialog(menuPrincipal);
            switch (opcao) {
                case "1":
                    String menuCliente =
                            "1 - Adicionar Cliente  \n"
                            + "2 - Buscar Cliente \n"
                            + "3 - Atualizar Cliente \n"
                            + "4 - Deletar Cliente \n"
                            + "0 - Sair";

                    while (!opcao2.equals("0")) {

                        opcao2 = JOptionPane.showInputDialog(menuCliente);

                        switch (opcao2) {
                            case "1":
                                Cliente cliente = new Cliente();
                                cliente.setNome(JOptionPane.showInputDialog("Nome do Cliente: "));
                                cliente.setCpf(JOptionPane.showInputDialog("CPF: "));
                                cr.salvarCliente(cliente);
                                JOptionPane.showMessageDialog(null, "Cliente Cadastrado com Sucesso!");
                                break;
                            case "2":
                                String id = JOptionPane.showInputDialog("Insira o ID do Cliente: ");
                                int novoId = Integer.parseInt(id);
                                Cliente c = cr.buscarCliente(novoId);
                                JOptionPane.showMessageDialog(null," ID: " + c.getId()
                                        + " | Nome: " + c.getNome() +
                                        " | CPF: " + c.getCpf());
                                break;
                            case "3":
                                String updateId = JOptionPane.showInputDialog("Insira o ID do Cliente que deseja Atualizar: ");
                                int idUpdate = Integer.parseInt(updateId);
                                Cliente upc = cr.atualizarCliente(idUpdate);
                                upc.setNome(JOptionPane.showInputDialog("Nome: "));
                                upc.setCpf(JOptionPane.showInputDialog("CPF: "));
                                JOptionPane.showMessageDialog(null, "O cliente foi atualizado com sucesso!");
                                break;

                            case "4":
                                String deleteId = JOptionPane.showInputDialog("Insira o ID do Cliente que deseja Deletar: ");
                                int idDelete = Integer.parseInt(deleteId);
                                Cliente clienteDelete = cr.deletarCliente(idDelete);
                                JOptionPane.showMessageDialog(null, "O cliente " + clienteDelete.getNome()
                                + " foi Deletado.");
                                break;
                        }
                    }
                    break;

                case "0":

                    JOptionPane.showMessageDialog(null, "O sistema foi finalizado.");
                    break;
                default:
                    break;
            }

        }
    }
}
