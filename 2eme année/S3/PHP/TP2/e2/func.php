<?php
require('cred.php');
try {
	$bd = new PDO('pgsql:host=aquabdd;dbname=etudiants', $user, $pass);
} catch (PDOException $e) {
	die('<p> La conncetion a échoué:' . $e->getMessage() . '</p>');
}

$bd->query("SET NAMES 'utf8'");
