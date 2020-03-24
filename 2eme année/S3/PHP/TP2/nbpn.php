<?php

try{
  require("Confidentiel.php");
  $db = new PDO('pgsql:host=aquabdd; dbname=etudiants', $user, $password);
}
catch(PDOException $e){
  echo $e->getMessage();
}


$req = $db->prepare('SELECT count(*) FROM nobels;');
$req->execute();
$ligne=$req->fetch(PDO::FETCH_NUM);
//echo '<p>' . $ligne[0] . '</p>';






 ?>
