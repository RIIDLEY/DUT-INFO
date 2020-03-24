<?php
require('Model.php');
// Récupérer le nombre de prix nobels dans la base de données pour l'afficher à la place de TO FILL.
$m = Model::getModel();
$last25 = $m->get_last();
require "begin.html";
?>
<h1> List of the nobel prizes </h1>

<?
echo '<table>';

$header = $last25[0]; # Première ligne
foreach($header as $k => $v){
	echo '<th>';
	echo $k;
	echo '</th>';
}

foreach ($last25 as $ligne){
	echo '<tr>';
	foreach ($ligne as $elem){
		echo '<td>';
		echo $elem;
		echo '</td>';
	}
	echo '</tr>';
}
echo '</table>';
?>


<?php require "end.html"; ?>
