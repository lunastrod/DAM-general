<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Listar Productos</title>
    </head>
    <body>
        <h1>Listado de productos</h1>
       <?php 
        include "conexion.php";
        $consultar = "SELECT * from productos";
        $registros = mysqli_query($conexion, $consultar);
       ?> 
       <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Descripción</th>
                    <th>Precio</th>
                    <th>Fotografia</th>
                    <th>Borrar</th>
                    <th>Editar</th>
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
                    
                    <td>
                        <?php 
                            if(!empty($unRegistro[4])){
                                echo "<img src='" . $unRegistro[4] . "' width='50' height='50'>";
                            }else{
                                echo "Sin imagen";
                            }
                        ?>
                    </td>
                    <td><a href="borrar.php?id=<?php echo $unRegistro[0];?>">Borrar</a></td>
                    <td><a href="formulario_editar.php?id=<?php echo $unRegistro[0];?>">Editar</a></td>
                </tr>
                <?php 
                    }

                    echo "<p><a href='formulario.php'>Volver al formulario</a></p>";
                ?>
            </tbody>
       </table>
    </body>
</html>