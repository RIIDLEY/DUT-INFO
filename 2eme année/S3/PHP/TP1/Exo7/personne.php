<?php

$personnes = [
  'mdupond' => ['Prénom' => 'Martin', 'Nom' => 'Dupond', 'Age' => 25, 'Ville' => 'Paris'       ],
  'jm'      => ['Prénom' => 'Jean'  , 'Nom' => 'Martin', 'Age' => 20, 'Ville' => 'Villetaneuse'],
  'toto'    => ['Prénom' => 'Tom'   , 'Nom' => 'Tonge' , 'Age' => 18, 'Ville' => 'Epinay'      ],
  'arn'     => ['Prénom' => 'Arnaud', 'Nom' => 'Dupond', 'Age' => 33, 'Ville' => 'Paris'       ],
  'email'   => ['Prénom' => 'Emilie', 'Nom' => 'Ailta' , 'Age' => 46, 'Ville' => 'Villetaneuse'],
  'dask'    => ['Prénom' => 'Damien', 'Nom' => 'Askier', 'Age' => 7 , 'Ville' => 'Villetaneuse']
];
$pseudo="";
if (isset($_GET['pseudo'])) {
    $pseudo= $_GET['pseudo'];
    if (isset($personnes[$pseudo])) {
      print_r($personnes[$pseudo]);
    }
    echo "Le pseudo n'est pas dispo";

}


?>

 <h1> Mon Formulaire </h1>
 <form action="personne.php" method="GET">
   <label> pseudo: </label>
   <input type="text" name="pseudo"/>
   <input type="submit"/>
 </form>

<<?php
echo 'input type="text name="pseudo" v';
 ?>
