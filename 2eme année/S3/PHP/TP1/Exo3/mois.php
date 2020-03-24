<!doctype html>
<html>
<head>
<title> <?php echo 'Troisemen pas en PHP'; ?> </title>
<meta charset="utf-8"/>
</head>
<body>
  <h3> Mois de l'année </h1>
<?php $mois = [
    "janvier",
    "février",
    "mars",
    "avril",
    "mai",
    "juin",
    "juillet",
    "août",
    "septembre",
    "octobre",
    "novembre",
    "décembre"
];

$mois1 = [
   "janvier"   => 31,
   "février"   => 28,
   "mars"      => 31,
   "avril"     => 30,
   "mai"       => 31,
   "juin"      => 30,
   "juillet"   => 31,
   "août"      => 31,
   "septembre" => 30,
   "octobre"   => 31,
   "novembre"  => 30,
   "décembre"  => 31
];

?>

<?php
echo '<ul>';
for($i=0;$i<=11;$i++)

        echo '<li>' . "$mois[$i]" . ' : ' . $mois1[$mois[$i]] . " jours " . '</li>';

echo '</ul>';

?>

</body>
</html>
