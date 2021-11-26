package Siclo3.Reto3.repository;

import Siclo3.Reto3.repository.crud.PartyroomCrudRepository;
import Siclo3.Reto3.model.Partyroom;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Pacho
 */
@Repository
public class PartyroomRepository {
    @Autowired
    private PartyroomCrudRepository partyroomCrudRepository;
    
    public List<Partyroom>getAll(){
        return (List<Partyroom>)partyroomCrudRepository.findAll();
    }
    public Optional<Partyroom>getPartyroom(int id){
        return partyroomCrudRepository.findById(id);
    }
    public Partyroom save(Partyroom p){
        return partyroomCrudRepository.save(p);
    }
    
}
