package Siclo3.Reto3.repository;

import Siclo3.Reto3.model.Score;
import Siclo3.Reto3.repository.crud.ScoreCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Pacho
 */
@Repository
public class ScoreRepository {
    @Autowired
    private ScoreCrudRepository scoreCrudRepository;
    
    public List<Score>getAll(){
        return (List<Score>)scoreCrudRepository.findAll();
    }
    public Optional<Score>getScore(int id){
        return scoreCrudRepository.findById(id);
    }
    public Score save(Score s){
        return scoreCrudRepository.save(s);
    }
}
