<?php
    // Comprobamos si el formulario ha sido enviado
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        
        // Verificamos que el campo 'nombre' exista en el array $_POST
        if (isset($_POST['nombre'])) {
            // Obtenemos y sanitizamos el valor para mayor seguridad
            $nombre = htmlspecialchars($_POST['nombre']);
            echo "<h1>Resultado</h1>";
            echo "El nombre recibido es: " . $nombre;
        }
    }
?>