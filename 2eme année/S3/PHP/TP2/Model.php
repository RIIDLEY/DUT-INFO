<?php


    class Model {
      private $db;
      private static $instance = null;

      public function __construct(){
        try{
          require("Confidentiel.php");
        $db = new PDO('pgsql:host=aquabdd; dbname=etudiants', $user, $password);
        $db->query("SET NAMES 'utf8'");
        $db->setAttribute(PDO::ATTR_ERRMODE,PDO::ERRMODE_EXCEPTION);
        $this->db = $db;
        }catch(PDOException $e){
          echo $e->getMessage();
        }
      }

      public static function getModel(){
        if (is_null(self::$instance)) {
          self::$instance = new Model();
        }
        return self::$instance;
      }

      public function get_last(){
        $req=$this->db->prepare('SELECT category FROM nobels ORDER BY year desc limit 25;');
        $req->execute();
        $lignes=$req->fetchall(PDO::FETCH_ASSOC);
        echo '<ul>';
        foreach ($lignes as $key => $value) {
            echo '<li>' . implode(" ",$value) . '</li>';
        }
        echo '</ul>';
      }

      public function get_nb_nobel_prizes(){
        $req = $this->db->prepare('SELECT count(*) FROM nobels;');
        $req->execute();
        $ligne=$req->fetch(PDO::FETCH_NUM);
        foreach ($ligne as $value) {
          echo $value;
        }
      }
    }


$m1 = new Model();
$m1->getModel();
$m1->get_last();
$m1->get_nb_nobel_prizes();


?>
