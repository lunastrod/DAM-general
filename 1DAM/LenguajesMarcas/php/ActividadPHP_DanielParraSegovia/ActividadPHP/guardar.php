<?php 
    include 'conexion.php';

    $nombre = $_POST['nombre'];
    $descripcion = $_POST['descripcion'];
    $precio = $_POST['precio'];
    $fotografia = "";

    if(isset($_FILES['fotografia']) && $_FILES['fotografia']['name'] != ""){
        $nombreArchivo = time() . "_" . $_FILES['fotografia']['name'];

        $rutaTemporal = $_FILES['fotografia']['tmp_name'];

        $rutaDestino = "imagenes/" . $nombreArchivo;

        if(move_uploaded_file($rutaTemporal, $rutaDestino)){
            $fotografia = $rutaDestino;
        }
    }

    $stmt = $conexion->prepare("INSERT INTO productos (nombre, descripcion, precio, fotografia) VALUES (?, ?, ?, ?)");
    $stmt->bind_param("ssds", $nombre, $descripcion, $precio, $fotografia);

    if($stmt->execute() === TRUE){
        echo "<p>Producto guardado correctamente.</p>";
    } else {
        echo "<p>Error al insertar: " . $stmt->error . "</p>";
    }

    echo "<p><a href='formulario.php'>Volver al formulario</a></p>";
    echo "<p><a href='listar.php'>Ver Productos</a></p>";

    $conexion->close();

?>