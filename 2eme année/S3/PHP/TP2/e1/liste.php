<?php
require('cred.php');
try {
	$bd = new PDO('pgsql:host=aquabdd;dbname=etudiants', $user, $pass);
} catch (PDOException $e) {
	die('<p> La conncetion a échoué:' . $e->getMessage() . '</p>');
}

$bd->query("SET NAMES 'utf8'");


function liste($bd) {
	$req = $bd->prepare('SELECT * from personnages');
	$req->execute();

	echo '<ul>';
	while ($ligne = $req->fetch(PDO::FETCH_ASSOC)) {
		echo '<li>';
		echo 'Id: ' . $ligne['id'] . ', nom: ' . $ligne['nom'] . ', prenom: ' . $ligne['prenom'];
	
		if($ligne['age'] === null){
			echo ', age non défini';
		} else {
			echo ', age: ' . $ligne['age'];
		}
		echo '</li>';
	}
	echo '</ul>';
}

liste($bd);
