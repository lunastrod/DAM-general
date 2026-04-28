<?php
    $servidor = 'localhost:3307';
    $usuario = 'root';
    $password = '';
    $base_datos = 'productobd2';

    $conexion = mysqli_connect($servidor, $usuario, $password, $base_datos);

    if (!$conexion) {
        die("Error de conexión: " . mysqli_connect_error());
    }
    echo "Conexión exitosa a la base de datos " . $base_datos;
?>