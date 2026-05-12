<?php 
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        include 'conexion.php';

        $id = $_POST['id'];
        $titulo = $_POST['titulo'];
        $autor = $_POST['autor'];
        $precio = $_POST['precio'];
        $stock = $_POST['stock'];
        $fecha_creacion=date("Y-m-d H:i:s",time());

        $stmt = $conn->prepare("UPDATE libros SET titulo = ?, autor = ?, precio = ?, stock = ?, fecha_creacion = ? WHERE id = ?");
        $stmt->bind_param("ssdisi", $titulo, $autor, $precio ,$stock, $fecha_creacion, $id);

        if($stmt->execute() === TRUE){
            echo "<p>Producto editado correctamente.</p>";
        } else {
            echo "<p>Error al insertar: " . $stmt->error . "</p>";
        }

        echo "<p><a href='index.php'>Volver</a></p>";

        $conn->close();

    }
    else {
        echo "Acceso no autorizado.";
    }
?>