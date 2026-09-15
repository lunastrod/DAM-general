<?php 
    if ($_SERVER["REQUEST_METHOD"] == "POST") {

    include 'conexion.php';

    $id = $_POST['id'];
    echo "<p>ID a eliminar: $id</p>";
    $stmt = $conn->prepare("DELETE FROM libros WHERE id = ?");
    $stmt->bind_param("i", $id);

    if($stmt->execute() === TRUE){
        echo "<p>Producto eliminado correctamente.</p>";
    } else {
        echo "<p>Error al eliminar: " . $stmt->error . "</p>";
    }

    echo "<p><a href='index.php'>Volver</a></p>";
    }
    else {
        echo "Acceso no autorizado.";
    }

?>