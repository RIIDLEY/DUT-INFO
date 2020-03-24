<?php
require('Model.php');
// Récupérer le nombre de prix nobels dans la base de données pour l'afficher à la place de TO FILL.
$m = Model::getModel();
require "begin.html";

if( ! isset($_GET['id'])){
	echo "Erreur: pas de id dans la requête";
	exit();
}

$record = $m->get_nobel_prize_informations($_GET['id']);
if( ! $record) {
	echo "L'id n'existe pas";
	exit();
}

?>

<h1> Information on <?= $record['name']?> </h1>
<?php
echo '<table>';

foreach ($record as $k => $v){
	echo '<tr>';
	echo '<td>' . $k . '</td>' . '<td>' . $v . '</td>';
	echo '</tr>';
}
echo '</table>';
?>

<?php require "end.html"; ?>
