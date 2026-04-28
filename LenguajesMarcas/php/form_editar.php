<?php
// 1. Obtener el ID del producto desde la URL
$id = $_GET['id'];
$producto = obtenerProducto($conexion, $id); // Función que vimos antes
?>

<form method="post" action="actualizar.php">
    <input type="hidden" name="id" value="<?php echo $producto['id']; ?>">

    <label>Nombre:</label>
    <input type="text" name="nombre" value="<?php echo $producto['nombre']; ?>">

    <label>Precio:</label>
    <input type="text" name="precio" value="<?php echo $producto['precio']; ?>">

    <input type="submit" value="Guardar Cambios">
</form>
