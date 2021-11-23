<?php

class Controller_set extends Controller{

  public function form_add(){
        $m = Model::getModel();
        $data = $m->getCategories();
        $this->render("form_add", ['category'=>$data]);
  }

  public function action_add(){
        $m = Model::getModel();
      if(isset($_POST['category']) and !preg_match("#^\s*$#",$_POST['category']) and isset($_POST['name']) and !preg_match("#^\s*$#",$_POST['name']) and isset($_POST['year']) and preg_match("#^[0-9]*$#",$_POST['year'])){
        $info = ['year'=>$_POST['year'],'category'=>$_POST['category'],'name'=>$_POST['name'],'birthdate'=>intval($_POST['birthdate']),'birthplace'=>$_POST['birthPlace'],'county'=>$_POST['county'],'motivation'=>$_POST['motivation']];
        $data = $m->addNobelPrize($info);
          $this->message("C'est bon");
      }
      else {
        $this->message("C'est pas bon");
      }

  }

  public function action_default(){
    $this->form_add();
  }

  public function message($message=''){
    $data = [
      'title'=>"message",
      'message'=>$message
    ];
    $this->render("message",$data);
  }

  public function action_remove(){
    $m = Model::getModel();
    if (isset($_GET['id']) and $m->isInDataBase($_GET['id'])) {
      $m->removeNobelPrize($_GET['id']);
      $this->message("Supprimer");
    }
    else {
      $this->message("Pas supprimer");
    }
  }



}

?>
