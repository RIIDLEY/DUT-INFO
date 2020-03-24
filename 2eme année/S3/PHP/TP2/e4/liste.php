<?php
require('Model.php');

$m = Model::getModel();

$tab = $m->getAll();

echo '<table>';
foreach ($tab as $ligne){
	echo '<tr>';
	foreach ($ligne as $elem){
		echo '<td>';
		echo $elem;
		echo '</td>';
	}
	echo '</tr>';
}
echo '</table>';
