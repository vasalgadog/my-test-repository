
package DTO;

/**
 *
 * @author vasal
 */
public class TrabajadorDTO {
    private int id;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String rut;
    private byte sexo_id;
    private String email;
    private int anio_ingreso;
    private byte departamento_id;

    public TrabajadorDTO(int id, String nombre, String apellido_paterno, String apellido_materno, String rut, byte sexo_id, String email, int anio_ingreso, byte departamento_id) {
        this.id = id;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.rut = rut;
        this.sexo_id = sexo_id;
        this.email = email;
        this.anio_ingreso = anio_ingreso;
        this.departamento_id = departamento_id;
    }

    public TrabajadorDTO() {
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

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public byte getSexo_id() {
        return sexo_id;
    }

    public void setSexo_id(byte sexo_id) {
        this.sexo_id = sexo_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAnio_ingreso() {
        return anio_ingreso;
    }

    public void setAnio_ingreso(int anio_ingreso) {
        this.anio_ingreso = anio_ingreso;
    }

    public byte getDepartamento_id() {
        return departamento_id;
    }

    public void setDepartamento_id(byte departamento_id) {
        this.departamento_id = departamento_id;
    }
    
    
}
