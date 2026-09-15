<?php 
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        include 'conexion.php';

        $titulo = $_POST['titulo'];
        $autor = $_POST['autor'];
        $precio = $_POST['precio'];
        $stock = $_POST['stock'];
        $fecha_creacion=date("Y-m-d H:i:s",time());

        $stmt = $conn->prepare("INSERT INTO libros (titulo, autor, precio, stock, fecha_creacion) VALUES (?, ?, ?, ?,?)");
        $stmt->bind_param("ssdis", $titulo, $autor, $precio ,$stock, $fecha_creacion);

        if($stmt->execute() === TRUE){
            echo "<p>Producto guardado correctamente.</p>";
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