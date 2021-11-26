package Siclo3.Reto3.service;

import Siclo3.Reto3.model.Client;
import Siclo3.Reto3.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pacho
 */
@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    
    public List<Client>getAll(){
        return clientRepository.getAll();
    }
    
    public Optional<Client>getClient(int id){
        return clientRepository.getClient(id);
    }
    
    public Client save(Client c){
        if (c.getIdClient()==null){
            return clientRepository.save(c);
        }else{
            Optional<Client> cpaux=clientRepository.getClient(c.getIdClient());
            if(cpaux.isEmpty()){
                return clientRepository.save(c);
            }else{
                return c;
            }
        }
    }
}
