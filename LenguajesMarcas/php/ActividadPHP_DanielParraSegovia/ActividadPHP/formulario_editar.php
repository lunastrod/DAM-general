<html>
    <head>
        <meta charset="UTF-8">
        <title>Index</title>
    </head>
    <body>
        <h1>Insertar Producto</h1>
        <form action="editar.php" method="POST" enctype="multipart/form-data">
            <input type="hidden" name="id" value="<?php echo $_GET['id']; ?>">
            <p>
                <label for="nombre">Nombre: </label><br>
                <input type="text" name="nombre">
            </p>

            <p>
                <label for="descripcion">Descripción: </label><br>
                <input type="text" name="descripcion">
            </p>

            <p>
                <label for="precio">Precio: </label><br>
                <input type="number" name="precio">
            </p>

            <p>
                <label for="fotografia">Fotografia: </label><br>
                <input type="file" name="fotografia">
            </p>

            <p>
                <input type="submit" value="Guardar Cambios">
            </p>
        </form>

    </body>
</html>