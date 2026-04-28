<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Formulario String</title>
</head>
<body>
    <h1>Introduce tu nombre</h1>
    <form method="post" action="procesar.php">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required>
        <br><br>
        <input type="submit" value="Enviar">
    </form>
</body>
</html>