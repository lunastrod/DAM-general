<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
    <?php
        // Tipos de datos en PHP
        // Escalares: int, float, string, bool
        // Compuestos: array, object
        $valor = 42; // int
        $valor = (int) "42"; // int
        function suma(int $a, int $b): int {
            return $a + $b;
        }
        $valor = 3.14; // float
        $valor = "Hola"; // string
        $valor = true; // bool
        echo json_encode($valor); // Imprime true o false
        $valor = [1, 2, 3]; // array
        class Persona {
            public $nombre;
            public function __construct($nombre) {
                $this->nombre = $nombre;
            }
        }
        $valor = new Persona("Juan"); // object
        $valor = (object) ["nombre" => "Juan"]; // object

        echo gettype($valor); // Imprime el tipo de dato actual de $valor
        
    ?>
</body>
</html>