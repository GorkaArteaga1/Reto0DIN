package dataAccessTier;

import classes.User;

/**
 *
 * Esta interfaz incluye métodos para recoger datos de un usuario.
 */
public interface DataAccessible {

    /**
     * Recupera los datos de un usuario.
     *
     * @return Un objeto (User) que contiene la información del usuario
     * recuperada. Puede retornar un objeto User vacío si no se encuentran
     * datos.
     */
    public User recogerDatos() throws Exception;
}
