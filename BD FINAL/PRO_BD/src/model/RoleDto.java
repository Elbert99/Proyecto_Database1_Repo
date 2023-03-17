package model;

/**
 *
 * @author Victor
 */
public class RoleDto {
    private String nombrerol;

    public RoleDto(String nombrerol) {
        this.nombrerol = nombrerol;
    }
    
    public boolean isGerente(){
      return nombrerol.equals("Gerente");
    }
    public boolean isConsultor(){
        return nombrerol.equals("Consultor");
    }
    public boolean isTrabajador(){
        return nombrerol.equals("Trabajador");
    }
    public boolean isAdministrador(){
        return nombrerol.equals("Administrador");
    }
    public boolean isInformatico(){
        return nombrerol.equals("Informatico");
    }
    
    //Get
    public String getNombrerol() {
        return nombrerol;
    }
  
    @Override
    public String toString() {
        return nombrerol;
    }
    
    
}
