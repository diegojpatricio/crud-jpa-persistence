import model.Cliente;
import repositories.ClienteRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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

        //-------------- DELETAR --------------
        Cliente cliente = cr.buscarCliente(1);
        System.out.println("Este é o cliente " + cliente.getNome() +
                " de ID: " + cliente.getId());
        cr.deletarCliente(cliente);
        //-------------------------------------


    }
}
