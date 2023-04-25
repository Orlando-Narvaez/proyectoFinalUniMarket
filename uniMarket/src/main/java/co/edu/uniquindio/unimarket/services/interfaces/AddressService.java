package co.edu.uniquindio.unimarket.services.interfaces;

public interface AddressService
{
    int crearDireccion(DireccionDTO direccionDTO)  throws Exception;
    // Método que permite actualizar una dirección por medio de su código
    int actualizarDireccion(int codigoDireccion, DireccionDTO direccionDTO) throws Exception;
    // Método que permite eliminar una dirección de la base de datos por medio de se código
    boolean eliminarDireccion(int codigoDireccion) throws Exception;
    // Método que permite obtener las direcciones de un usuario por medio de su código
    List<DireccionGetDTO> obtenerDireccionUsuario(String cedulaUsuario) throws Exception;
    Direccion obtenerDireccionBD(int codigoDireccion) throws Exception;
    DireccionGetDTO transformarDireccion(Direccion direccion);
}
