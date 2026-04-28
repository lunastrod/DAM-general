<?php
    include 'conexion.php';


    $id = (int)$_POST['id'];
    echo "<p>ID a editar: $id</p>";

    $nombre = mysqli_real_escape_string($conexion, $_POST['nombre']);
    $descripcion = mysqli_real_escape_string($conexion, $_POST['descripcion']);
    $precio = (float)$_POST['precio'];

    $fotografia = "";
    if(isset($_FILES['fotografia']) && $_FILES['fotografia']['name'] != ""){
        $nombreArchivo = time() . "_" . $_FILES['fotografia']['name'];

        $rutaTemporal = $_FILES['fotografia']['tmp_name'];

        $rutaDestino = "imagenes/" . $nombreArchivo;

        if(move_uploaded_file($rutaTemporal, $rutaDestino)){
            $fotografia = $rutaDestino;
        }
    }

    $stmt = $conexion->prepare("UPDATE productos SET nombre = ?, descripcion = ?, precio = ?, fotografia = ? WHERE id_producto = $id");
    $stmt->bind_param("ssds", $nombre, $descripcion, $precio, $fotografia);

    if($stmt->execute() === TRUE){
        echo "<p>Producto editado correctamente.</p>";
    } else {
        echo "<p>Error al editar: " . $stmt->error . "</p>";
    }

    echo "<p><a href='formulario.php'>Volver al formulario</a></p>";
    echo "<p><a href='listar.php'>Ver Productos</a></p>";
?>