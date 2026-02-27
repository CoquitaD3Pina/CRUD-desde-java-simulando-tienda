package tienda.dto;

public class ClienteDTO {

    private int id;
    private String nombre;

    public ClienteDTO(){

    }
    
    public ClienteDTO(int id, String nombre){
        this.id=id;
        this.nombre=nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

}
