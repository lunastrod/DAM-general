<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php 
        if ($_SERVER["REQUEST_METHOD"] == "POST") {
            $id = (int)$_POST['id'];
    ?>
    <p>Seguro que desea eliminar este elemento?</p>
    <form action="eliminar.php" method="POST">
        <input type="hidden" name="id" value="<?php echo $id; ?>">
        <input type="submit" value="Sí">
    </form>
    <td><a href="index.php">No</a></td>
    <?php 
        }
        else {
            echo "Acceso no autorizado.";
        }
    ?>
</body>
</html>