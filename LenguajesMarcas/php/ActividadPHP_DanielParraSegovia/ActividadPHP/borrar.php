<?php 
    include 'conexion.php';

    $id = $_GET['id'];
    echo "<p>ID a eliminar: $id</p>";
    $stmt = $conexion->prepare("DELETE FROM productos WHERE id_producto = ?");
    $stmt->bind_param("i", $id);

    if($stmt->execute() === TRUE){
        echo "<p>Producto eliminado correctamente.</p>";
    } else {
        echo "<p>Error al eliminar: " . $stmt->error . "</p>";
    }

    echo "<p><a href='formulario.php'>Volver al formulario</a></p>";
    echo "<p><a href='listar.php'>Ver Productos</a></p>";

?>