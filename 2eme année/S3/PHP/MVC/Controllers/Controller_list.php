<?php

class Controller_list extends Controller{

  public function action_list(){
    $m = Model::getModel();
    $data = ['tab' => $m->getLast()];

    $this->render('last', $data);
  }

  public function action_default(){
    $this->action_list();
  }

  public function action_informations(){
    $m = Model::getModel();
    if (isset($_GET['id']) and $_GET['id'] > 0) {
          $data = $m->getNobelPrizeInformations($_GET['id']);
          foreach ($data as $key =>$value) {
            if ($value == NULL) {
              $data[$key] = "???";
            }
          }
          $this->render('informations', $data);
    }
    else {
      $this->action_error("Erreur");
    }
  }

}

?>
