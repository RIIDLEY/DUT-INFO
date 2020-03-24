<?php
require('func.php');

if (isset($_GET['family'])) {
	$family = $_GET['family'];
	if ( preg_match('#_w+$#', $family) ){
		liste_famille($bd, $family);
	}
}

function liste_famille($bd, $nom_famille) {
	
	$req = $bd->prepare('SELECT * from personnages where nom = :nom');
	$req->bindValue(':nom', $nom_famille);
	$req->execute();

	$tab = $req->fetchAll(PDO::FETCH_ASSOC);
	
	echo '<ul>';
	foreach($tab as $line) {
		echo '<li>';
		echo implode(', ', $line);
		echo '</li>';
	}
	echo '</ul>';
}

?>
<form action=<?php $_SERVER['PHP_SELF']?>>
	<input type='text' name='family'></input>
</form>
