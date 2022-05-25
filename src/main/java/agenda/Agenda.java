
package agenda;

//import exceptions.ContactoInexistenteException;
import exceptions.ContactoRepetidoException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author loned
 */
public class Agenda {

    private HashMap<String, Contacto> contactos = new HashMap();
    private static int n = 0;
    private static int count = 0; 
    private static String nombreAgenda="";

    public String getnombreAgenda(Agenda a){
            return this.nombreAgenda;
    }
    public void setnombreAgenda(String name){
            this.nombreAgenda=name;
    }
    public Agenda(String name){    
        if (name != ""){
            this.nombreAgenda = name;
        }else this.nombreAgenda ="Untitled";
    }
        
    /**
     * Añade un contacto a la agenda
     * @param contacto Contacto que queremos añadir
     * @return Devuelve el contacto añadido o genera una excepcion si ya existia
     * @throws ContactoRepetidoException Excepcion programada, ver paquete exception. 
     */    
    public Contacto addContacto(Contacto contacto) throws ContactoRepetidoException {
        if (contactos.containsKey(contacto.getEmail())) {
            //
            throw new ContactoRepetidoException("Ya existe un contacto con email: " + contacto.getEmail());
        }
        n++;
        contacto.setN(n);
        contactos.put(contacto.getEmail(), contacto);
        count++;
        return contacto;
    }

    /**
     * Elimina un contacto de la agenda
     * @param email Email del contacto que se quiere eliminar
     * @return Devuelve el contacto eliminado
     */
    public Contacto eliminarContacto(String email) { 
        Contacto contacto = buscarContacto(email);
        if (contacto != null) {
        contactos.remove(email);
        count--;
        }
        return contacto;
    }

    /**
     * Busca un contacto en la agenda
     * @param email Email del contacto que se quiere buscar
     * @return Devuelve el contacto si está y si no está devuelve null
     */
    public Contacto buscarContacto(String email) { 
        Contacto contacto = null;
        if (!contactos.containsKey(email)) {

            return null;
        }
        else{
        return contactos.get(email);
        }
    }

    /**
     * En esta funcion se almacenan todos los contactos
     * @return Devuelve la lista de todos los contactos.
     */
    public ArrayList<Contacto> getContactos() {
        ArrayList<Contacto> contactosList = new ArrayList<>();
        contactosList.addAll(contactos.values());
        return contactosList;
    }
    
    

}
