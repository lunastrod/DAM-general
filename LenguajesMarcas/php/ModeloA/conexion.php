<?php

$host = 'localhost';
$puerto = '3307';
$usuario = 'root';
$password = '';
$basedatos = 'biblioteca';
$servidor = $host . ':' . $puerto;

$conn = new mysqli($servidor, $usuario, $password, $basedatos);

if ($conn->connect_error) {
    die("Error de conexión: " . $conn->connect_error);
}

?>