<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $id = $_POST['id'];
    $nombre = $_POST['nombre'];
    $precio = $_POST['precio'];

    $sql = "UPDATE productos SET nombre = ?, precio = ? WHERE id = ?";
    $stmt = $conexion->prepare($sql);
    $stmt->bind_param("sdi", $nombre, $precio, $id);
    
    if ($stmt->execute()) {
        echo "Datos actualizados correctamente.";
    } else {
        echo "Error al actualizar: " . $stmt->error;
    }
}
?>