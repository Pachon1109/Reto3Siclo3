package Siclo3.Reto3.service;

import Siclo3.Reto3.model.Message;
import Siclo3.Reto3.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pacho
 */
@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    
    public List<Message>getMessage(){
        return messageRepository.getMessage();
    }
    public Optional<Message>getIdMessage(int id){
        return messageRepository.getMessage(id);
    }
    public Message save(Message m){
        if (m.getIdMessage()==null){
            return messageRepository.save(m);        
    }else{
            Optional<Message> maux=messageRepository.getMessage(m.getIdMessage());
            if(maux.isEmpty()){
                return messageRepository.save(m);
            }else{
                return m;
            }
        }
    }
}
