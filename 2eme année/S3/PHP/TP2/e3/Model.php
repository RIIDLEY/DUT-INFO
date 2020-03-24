<?php
class Model{
	private $bd; //Attribut privé contenant l'objet PDO
	
	//Attribut qui contiendra l'unique instance du modèle
	private static $instance = null;
	/**
	* Constructeur créant l'objet PDO et l'affectant à $bd
	*/
	private function __construct(){
		//Fichier contenant les dsn, login et mot de passe
		require('cred.php');
		try{
			$this->bd = new PDO($dsn, $user, $pass);
		}catch (PDOException $e){
			die('<p> Erreur['.$e->getCode().'] : '.$e->getMessage().'</p>');
		}
		$this->bd->query('SET NAMES utf8');
		$this->bd->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
	}
	/**
	* Méthode permettant de récupérer l'instance de la classe Model
	*/
	public static function getModel(){
		//Si la classe n'a pas encore été instanciée
		if (is_null(self::$instance))
			self::$instance = new Model(); //On l'instancie
		return self::$instance; //On retourne l'instance
	}
	
	public function getAll(){
		$req = $this->bd->prepare('SELECT * from personnages');
		$req->execute();

		return $req->fetchAll(PDO::FETCH_ASSOC);
	}
}
