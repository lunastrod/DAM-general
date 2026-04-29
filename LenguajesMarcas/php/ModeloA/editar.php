<?php
include("conexion.php");
?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Editar registro</title>
</head>
<body>
    <?php 
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $id = $_POST['id'];
        $titulo = $_POST['titulo'];
        $autor = $_POST['autor'];
        $precio = $_POST['precio'];
        $stock = $_POST['stock'];
        $fecha = $_POST['fecha'];
        //TODO deberia dejar la fecha o cambiarla?
        // yo creo que la voy a actualizar
    ?>
        <h1>Editar registro</h1>

        <form action="editarBD.php" method="POST">
            <input type="hidden" name="id" value="<?php echo $id; ?>">
            <label for="titulo">Título:</label>
            <input type="text" name="titulo" id="titulo" value="<?php echo $titulo; ?>">
			<br><br>
            <label for="autor">Autor:</label>
            <input type="text" name="autor" id="autor" value="<?php echo $autor; ?>">
			<br><br>
            <label for="precio">Precio:</label>
            <input type="number" name="precio" id="precio" value="<?php echo $precio; ?>" step="0.01">
			<br><br>
            <label for="stock">Stock:</label>
            <input type="number" name="stock" id="stock" value="<?php echo $stock; ?>" step="1">
			<br><br>
            <button type="submit">Actualizar</button>
			<br><br>
            <a href="index.php">Volver</a>
        </form>
    <?php 
        }
        else {
            echo "Acceso no autorizado.";
        }
    ?>
</body>
</html>
