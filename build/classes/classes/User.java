package classes;

/**
 * La clase (User) gestiona la información básica de un usuario en el sistema.
 * Proporciona métodos para acceder y modificar el DNI, nombre, contraseña y
 * edad del usuario.
 */
public class User {

    private String dni;
    private String nombre;
    private String passwd;
    private String edad;

    /**
     * Devuelve el DNI del usuario.
     *
     * @return DNI del usuario.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el DNI del usuario.
     *
     * @param dni nuevo DNI del usuario.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Devuelve el nombre del usuario.
     *
     * @return Nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre nuevo nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la contraseña del usuario.
     *
     * @return Contraseña del usuario.
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param passwd nueva contraseña del usuario.
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    /**
     * Devuelve la edad del usuario.
     *
     * @return Edad del usuario.
     */
    public String getEdad() {
        return edad;
    }

    /**
     * Establece la edad del usuario.
     *
     * @param edad nueva edad del usuario.
     */
    public void setEdad(String edad) {
        this.edad = edad;
    }

    /**
     * Devuelve una cadena del objeto Usuario.
     *
     * @return Una cadena con los valores del DNI, nombre, contraseña y edad.
     */
    @Override
    public String toString() {
        return "Usuario{" + "dni=" + dni + ", nombre=" + nombre + ", passwd=" + passwd + ", edad=" + edad + '}';
    }
}
