
package Siclo3.Reto3.service;

import Siclo3.Reto3.model.Score;
import Siclo3.Reto3.repository.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pacho
 */
@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepoitory;
    
    public List<Score>getAll(){
        return scoreRepoitory.getAll();
    }
    public Optional<Score>getScore(int id){
        return scoreRepoitory.getScore(id);
    }
    public Score save(Score s){
        if(s.getId()==null){
            return scoreRepoitory.save(s);
        }else{
            Optional<Score> saux=scoreRepoitory.getScore(s.getId());
            if(saux.isEmpty()){
                return scoreRepoitory.save(s);
            }else{
                return s;
            }
        }
    }
}
