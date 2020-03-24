<?php
require("nbpn.php");

if (isset($_GET['id'])) {
  if ($_GET['id']<=$ligne[0] && $_GET['id']>=0) {
    try{
      require("Confidentiel.php");
      $db = new PDO('pgsql:host=aquabdd; dbname=etudiants', $user, $password);
      $req = $db->prepare('SELECT * FROM nobels WHERE id=:id;');
      $req->bindValue(":id",$_GET['id']);
      $req->execute();
      $lignes=$req->fetch(PDO::FETCH_ASSOC);
    }
    catch(PDOException $e){
      echo $e->getMessage();
    }

    echo '<ul>';
    foreach ($lignes as $key => $value) {
      echo '<li>' . $value . '</li>';
    }
    echo '</ul>';
  }
  else {
    echo 'Id incorrect';
  }
}
else {
  echo 'Y a r';
}

 ?>
