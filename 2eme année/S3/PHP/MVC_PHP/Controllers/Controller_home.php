<?php

class Controller_home extends Controller{

  public function action_home(){
    $m = Model::getModel();
    $tab = ['nb_nobels' => $m->getNbNobelPrizes()];

    $this->render('home', $tab);
  }

  public function action_default(){
    $this->action_home();
  }
}

?>
