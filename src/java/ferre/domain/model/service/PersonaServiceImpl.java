package ferre.domain.model.service;


import ferre.domain.model.entity.Entity;
import ferre.domain.model.entity.Persona;
import ferre.domain.model.repository.PersonaRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sourabh Sharma
 */
//@Service("userService")
public class PersonaServiceImpl extends BaseService<Persona, Integer>
        implements PersonaService {

    private PersonaRepository<Persona, Integer> personaRepository;

    /**
     *
     * @param userRepository
     */
    //@Autowired
    public PersonaServiceImpl(PersonaRepository<Persona, Integer> personaRepository) {
        super(personaRepository);
        this.personaRepository = personaRepository;
    }
    
    
    @Override
    public void add(Persona persona) throws Exception {
        
       /* if (persona.getLoginName()== null || "".equals(persona.getLoginName()) ){
              throw new Exception("El LoginName no puede ser nulo o cadena vacia.");
        }

        if (personaRepository.containsLoginName(persona.getLoginName())) {
            throw new Exception(String.format("Ya existe un usuario con el login name %s", persona.getLoginName()));
        }*/

        if (persona.getNombre() == null || "".equals(persona.getNombre())) {
            throw new Exception("El nombre del usuario no puede ser nulo o cadena vacia.");
        }
        
        if (persona.getApellido() == null || "".equals(persona.getApellido())) {
            throw new Exception("El apellido del usuario no puede ser nulo o cadena vacia.");
        }
        
        super.add(persona);
    }

    /**
     *
     * @param nombre
     * @param apellido
     * @return
     * @throws Exception
     */
    @Override
    public Collection<Persona> findByNombreApellido(String nombre, String apellido) throws Exception {
        return personaRepository.findByNombreApellido(nombre, apellido);
    }

    /**
     *
     * @param user
     * @throws Exception
     */
    @Override
    public void update(Persona persona) throws Exception {
        if (personaRepository.contains(persona.getId())==true)
            personaRepository.update(persona);
        else
             throw new Exception(String.format("no existe el id %d ", persona.getId()));
   
    }

    /**
     *
     * @param id
     * @throws Exception
     */
    @Override
    public void delete(Integer id) throws Exception {
        personaRepository.remove(id);
    }

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Entity findById(Integer id) throws Exception {
        return personaRepository.get(id);
    }

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public Collection<Persona> findByCriteria(Map<String, ArrayList<String>> name) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Persona> getClientes()  {
        try {
            return personaRepository.getClientes();
        } catch (Exception ex) {
            Logger.getLogger(PersonaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Collection<Persona> getEmpleados() {
          try {
            return personaRepository.getEmpleados();
        } catch (Exception ex) {
            Logger.getLogger(PersonaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;}

    @Override
    public Collection<Persona> getAdmins() {
          try {
            return personaRepository.findByRol(3);
        } catch (Exception ex) {
            Logger.getLogger(PersonaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;} 

    

}
