<!DOCTYPE html>
  <head>
    <meta charset="utf-8">
    <title></title>
  </head>
  <body>

<?php
$tabMagazines = [
  'le monde'              => ['frequence' => 'quotidien', 'type' => 'actualité', 'prix' => 220],
  'le point'              => ['frequence' => 'hebdo'    , 'type' => 'actualité', 'prix' => 80 ],
  'causette'              => ['frequence' => 'mensuel'  , 'type' => 'féministe', 'prix' => 180],
  'politis'               => ['frequence' => 'hebdo'    , 'type' => 'opinion'  , 'prix' => 100],
  'le monde diplomatique' => ['frequence' => 'mensuel'  , 'type' => 'analyse'  , 'prix' => 60 ]
];

$tabMagazinesAbonne = ['le monde', 'le monde diplomatique'];

ksort($tabMagazines);
$b = array_keys($tabMagazines);
echo implode(",",$b);

echo '<ul>';
foreach ($tabMagazines as $key => $value) {
    echo '<li>' . $key  . '(';
    foreach ($value as $cle => $valeur) {
      echo $valeur . ",";
    }
    echo ") </li>";
}
echo '</ul>';

$prix=0;
foreach ($tabMagazinesAbonne as $key) {
    $prix += $tabMagazines[$key]['prix'] ;
    }

echo "le prix de l'abonnement est de : " . $prix

 ?>
  </body>
</html>
