<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title></title>
  </head>
  <body>

<?php $personnes = [
  'mdupond' => ['Prénom' => 'Martin', 'Nom' => 'Dupond', 'Age' => 25, 'Ville' => 'Paris'       ],
  'jm'      => ['Prénom' => 'Jean'  , 'Nom' => 'Martin', 'Age' => 20, 'Ville' => 'Villetaneuse'],
  'toto'    => ['Prénom' => 'Tom'   , 'Nom' => 'Tonge' , 'Age' => 18, 'Ville' => 'Epinay'      ],
  'arn'     => ['Prénom' => 'Arnaud', 'Nom' => 'Dupond', 'Age' => 33, 'Ville' => 'Paris'       ],
  'email'   => ['Prénom' => 'Emilie', 'Nom' => 'Ailta' , 'Age' => 46, 'Ville' => 'Villetaneuse'],
  'dask'    => ['Prénom' => 'Damien', 'Nom' => 'Askier', 'Age' => 7 , 'Ville' => 'Villetaneuse']
];

$scores = [
  ['Joueur' => 'Camille'  , 'score' => 156 ],
  ['Joueur' => 'Guillaume', 'score' => 254 ],
  ['Joueur' => 'Julien'   , 'score' => 192 ],
  ['Joueur' => 'Nabila'   , 'score' => 317 ],
  ['Joueur' => 'Lorianne' , 'score' => 235 ],
  ['Joueur' => 'Tom'      , 'score' => 83  ],
  ['Joueur' => 'Michael'  , 'score' => 325 ],
  ['Joueur' => 'Eddy'     , 'score' => 299 ]
];


 ?>
 <?php
  //echo '<table>' ;
  //for ($i=0; $i <4 ; $i++) {
    //echo '<th>' . array_keys($personnes[array_keys($personnes)[0]])[$i] . '</th>';
  //}
//foreach ($personnes as $key => $value){

    //echo '<tr>' ;
    //foreach ($value as $keys => $valeur) {
    //  echo '<td>' . $valeur . '</td>' ;
  //  }



//    echo '</tr>' ;
//}

//  echo '</table>' ;
 ?>


 <?php
//   echo '<table>' ;
//   for ($i=0; $i <2 ; $i++) {
//     echo '<th>' . array_keys($scores[array_keys($scores)[0]])[$i] . '</th>';
//   }
// foreach ($scores as $key => $value){ 
//
//     echo '<tr>' ;
//  //     echo '<td>' . $valeur . '</td>' ;
  //   }



  //   echo '</tr>' ;
 //}

  // echo '</table>' ;
  ?>

<?php
  function affichetab($tab,$a){
    echo '<table>' ;
    for ($i=0; $i <$a ; $i++) {
      echo '<th>' . array_keys($tab[array_keys($tab)[0]])[$i] . '</th>';
    }
    foreach ($tab as $key => $value){

      echo '<tr>' ;
      foreach ($value as $keys => $valeur) {
        echo '<td>' . $valeur . '</td>' ;
      }



      echo '</tr>' ;
    }

    echo '</table>' ;
  }

  affichetab($personnes,4);
  affichetab($scores,2);
?>
  </body>
</html>
