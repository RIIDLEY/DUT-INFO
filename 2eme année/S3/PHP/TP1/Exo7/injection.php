<?php

$personnes = [
  'mdupond' => ['Prénom' => 'Martin', 'Nom' => 'Dupond', 'Age' => 25, 'Ville' => 'Paris'       ],
  'jm'      => ['Prénom' => 'Jean'  , 'Nom' => 'Martin', 'Age' => 20, 'Ville' => 'Villetaneuse'],
  'toto'    => ['Prénom' => 'Tom'   , 'Nom' => 'Tonge' , 'Age' => 18, 'Ville' => 'Epinay'      ],
  'arn'     => ['Prénom' => 'Arnaud', 'Nom' => 'Dupond', 'Age' => 33, 'Ville' => 'Paris'       ],
  'email'   => ['Prénom' => 'Emilie', 'Nom' => 'Ailta' , 'Age' => 46, 'Ville' => 'Villetaneuse'],
  'dask'    => ['Prénom' => 'Damien', 'Nom' => 'Askier', 'Age' => 7 , 'Ville' => 'Villetaneuse']
];
if (isset($_GET['pseudo']) or !preg_match("#[ , ]{0}#",$_GET['pseudo'])) {
  $pseudo=$_GET['pseudo'];
  if (isset($personnes[$pseudo])) {
    echo "pseudo=$pseudo :";
    print_r($personnes[$pseudo]);
  } else {
    $personnes[$pseudo]=array('Prénom'=>$_GET['prenom'], 'Nom'=>$_GET['nom'], 'Age'=>$_GET['age'], 'Ville'=>$_GET['ville']);
  }
  }


print_r($personnes);



?>
