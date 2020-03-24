<?php
require('Model.php');
$m = Model::getModel();
$last25 = $m->get_last();
require "begin.html";
?>
<h1> List of the nobel prizes </h1>

<?
echo '<table>';

$header = $last25[0]; # Première ligne
foreach($header as $k => $v){
	if($k !== 'id'){
		echo '<th>';
		echo $k;
		echo '</th>';
	}
}

foreach ($last25 as $ligne){
	echo '<tr>';
	foreach ($ligne as $k => $elem){
		if($k !== 'id'){
			echo '<td>';
			if($k === 'name'){
				echo '<a href="informations.php?id=' . $ligne['id'] . '">';
			}
			echo $elem;
			if($k === 'name'){
				echo '</a>';
			}
			echo '</td>';
		}
	}
	echo '</tr>';
}
echo '</table>';
?>


<?php require "end.html"; ?>
