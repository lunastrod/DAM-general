<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Crear registro</title>
</head>
<body>
        <h1>Nuevo registro</h1>

        <form action="guardar.php" method="POST">
            <label for="titulo">Título:</label>
            <input type="text" name="titulo" id="titulo">
			<br><br>
            <label for="autor">Autor:</label>
            <input type="text" name="autor" id="autor">
			<br><br>
            <label for="precio">Precio:</label>
            <input type="number" name="precio" id="precio" step="0.01">
			<br><br>
            <label for="stock">Stock:</label>
            <input type="number" name="stock" id="stock" step="1">
			<br><br>
            <button type="submit">Guardar</button>
			<br><br>
            <a href="index.php">Volver</a>
        </form>
</body>
</html>
