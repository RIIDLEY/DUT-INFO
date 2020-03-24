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
		require('credentials.php');
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
	
	public function get_last(){
		$req = $this->bd->prepare('select name,category,year,id< from nobels order by id desc limit 25');
		$req->execute();
		$nb = $req->fetchAll(PDO::FETCH_ASSOC);
		return $nb;
	}

	public function get_nb_nobel_prizes(){
		$req= $this->bd->prepare('select count(*) from nobels');
		$req->execute();
		$tabMag = $req->fetch();
		return $tabMag['count'];
	}
	
	public function get_nobel_prize_informations($id) {
		$req=$this->bd->prepare('select * from nobels where id = :id');
		$req->bindValue('id', $id);
		$req->execute();
		$data = $req->fetch(PDO::FETCH_ASSOC);
		if (empty($data)) {
			return false;
		} else {
			return $data;
		}
	}
}
