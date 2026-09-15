<?php
include("conexion.php");
?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Gestión de libros</title>
</head>
<body>
    <?php
        $consultar = "SELECT * from libros";
        $registros = mysqli_query($conn, $consultar);
    ?>
        <h1>Gestión de libros</h1>

        <a href="crear.php">Nuevo registro</a>

        <table border="2">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Título</th>
                    <th>Autor</th>
                    <th>Precio</th>
                    <th>Stock</th>
                    <th>Fecha creación</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <?php
                while($unRegistro=mysqli_fetch_row($registros)){
                ?>
                <tr>
                    <td><?php echo $unRegistro[0];?></td>
                    <td><?php echo $unRegistro[1];?></td>
                    <td><?php echo $unRegistro[2];?></td>
                    <td><?php echo $unRegistro[3];?></td>
                    <td><?php echo $unRegistro[4];?></td>
                    <td><?php echo $unRegistro[5];?></td>
                    <td>
                        <form action="confirmacion.php" method="POST">
                            <input type="hidden" name="id" value="<?php echo $unRegistro[0]; ?>">
                            <input type="submit" value="eliminar">
                        </form>
                        <form action="editar.php" method="POST">
                            <input type="hidden" name="id" value="<?php echo $unRegistro[0]; ?>">
                            <input type="hidden" name="titulo" value="<?php echo $unRegistro[1]; ?>">
                            <input type="hidden" name="autor" value="<?php echo $unRegistro[2]; ?>">
                            <input type="hidden" name="precio" value="<?php echo $unRegistro[3]; ?>">
                            <input type="hidden" name="stock" value="<?php echo $unRegistro[4]; ?>">
                            <input type="hidden" name="fecha" value="<?php echo $unRegistro[5]; ?>">
                            <input type="submit" value="editar">
                        </form>
                    </td>
                </tr>
                <?php 
                    }
                ?>
            </tbody>
        </table>
</body>
</html>
<?php
$conn->close();
?>