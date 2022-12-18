package ferre.domain.model.service;


import ferre.domain.model.entity.Entity;
import ferre.domain.model.entity.Persona;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;


/**
 *
 * @author Sourabh Sharma
 */
public interface PersonaService {

    /**
     *
     * @param persona
     * @throws Exception
     */
    public void add(Persona persona) throws Exception;

    /**
     *
     * @param persona
     * @throws Exception
     */
    public void update(Persona persona) throws Exception;

    /**
     *
     * @param id
     * @throws Exception
     */
    public void delete(Integer id) throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Entity findById(Integer id) throws Exception;

    /**
     *
     * @param nombre
     * @param apellido
     * @return
     * @throws Exception
     */
    public Collection<Persona> findByNombreApellido(String nombre, String apellido) throws Exception;

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    public Collection<Persona> findByCriteria(Map<String, ArrayList<String>> name) throws Exception;
     /**
     *
     * @return
     */
    public Collection<Persona> getClientes();
     /**
     *
     * @return
     */
    public Collection<Persona> getEmpleados();
     /**
     *
     * @return
     */
    public Collection<Persona> getAdmins();
    
   // public LogResponse isLog(Persona persona);
      /**
     * @param idAlumno
     * @param PasswordOld
     * @param PasswordNew
     * @return
     * @throws Exception
     */
    //public Password responsePassword(String PasswordOld, String PasswordNew,int idAlumno) throws Exception; 
}
