<?php

try{
  require("confidentials.php");
  $db = new PDO('pgsql:host=aquabdd; dbname=etudiants', $user, $password);
}
catch(PDOException $e){
  echo "Erreur";
}

function liste($db){
  $req = $db->prepare('SELECT nom, prenom, age FROM personnages;');
  $req->execute();
  echo '<ul>';
  while($ligne = $req->fetch(PDO::FETCH_ASSOC)){
    if($ligne['age'] === null){
      $ligne['age'] = "Age non défini";
    }
    else{
      $ligne['age'] = $ligne['age'] . ' ans';
    }
    echo '<li>' .  implode(', ', $ligne) . '</li>';
  }
  echo '</ul>';
}

//liste($db);

function liste_famille($db, $nom){
  $req = $db->prepare('SELECT nom, prenom, age FROM personnages WHERE nom = :nom');
  $req->bindValue(':nom', $nom);
  $req->execute();
  echo '<ul>';
  $ligne = $req->fetchAll(PDO::FETCH_ASSOC);
  print_r($ligne);
  foreach($ligne as $key){
    echo '<li>' .  implode(', ', $key) . '</li>';
  }
  echo '</ul>';
}

liste_famille($db, "Faisy");
?>
