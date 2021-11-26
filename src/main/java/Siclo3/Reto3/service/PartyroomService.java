package Siclo3.Reto3.service;

import Siclo3.Reto3.model.Partyroom;
import Siclo3.Reto3.repository.PartyroomRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pacho
 */
@Service
public class PartyroomService {
    @Autowired
    private PartyroomRepository partyroomRepository;
    
    public List<Partyroom>getAll(){
        return partyroomRepository.getAll();
    }
    
    public Optional<Partyroom>getParyroom(int id){
        return partyroomRepository.getPartyroom(id);
    }
    
    public Partyroom save(Partyroom p){
        if (p.getId()==null){
            return partyroomRepository.save(p);
        }else{
            Optional<Partyroom> paux=partyroomRepository.getPartyroom(p.getId());
            if(paux.isEmpty()){
                return partyroomRepository.save(p);
            }else{
                return p;
            }
        }
    }
    
}

