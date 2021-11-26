package Siclo3.Reto3.service;

import Siclo3.Reto3.model.Admin;
import Siclo3.Reto3.repository.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pacho
 */
@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    
    public List<Admin>getAll(){
        return adminRepository.getAll();
    }
    public Optional<Admin>getAdmin(int id){
        return adminRepository.getAdmin(id);
    }
    public Admin save(Admin a){
        if(a.getId()==null){
            return adminRepository.save(a);        
    }else{
            Optional<Admin> aaux=adminRepository.getAdmin(a.getId());
            if(aaux.isEmpty()){
                return adminRepository.save(a);
            }else{
                return a;
            }
        }
    }
}
