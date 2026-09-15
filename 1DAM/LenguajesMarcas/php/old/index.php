<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Ejemplo 1 Formulario PHP</title>
</head>
<body>
    <h1>Ejemplo 1 Formulario PHP</h1>
    <form action="pruebasphp.php" method="post">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre"><br><br>
        <label for="apellido">Apellido:</label>
        <input type="text" id="apellido" name="apellido"><br><br>
        <input type="submit" value="Enviar">
    </form>

    <?php
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $nombre = $_POST["nombre"];
        $apellido = $_POST["apellido"];
        echo "<h2>Hola, " . htmlspecialchars($nombre) . " " . htmlspecialchars($apellido) . "!</h2>";
    }
    ?>
</body>
</html>