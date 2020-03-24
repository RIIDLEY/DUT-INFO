<?php
class TODOlist{
  private $to_dos;

  public function __construct(){
    $this->to_dos=[];
  }

  public function add_to_do($str){
    if (preg_match("#^\s*#",$str)) {
      $this->to_dos[] = $str;
    }
  }

  public function remove_to_do($id){
    unset($this->to_dos[$id]);
  }

  public function is_empty(){
    if (count($this->to_dos) === 0){
      return true;
    }
    else {
      return false;
    }
  }

  public function get_html()
  {
    print_r($this->to_dos);
    if(! $this->is_empty())
    {
      echo '<ul>' ;
      foreach ($this->to_dos as $key => $value) {
        echo '<li>' . $value . '</li>';
      }
      echo'</ul>';
    } else {
      echo  '<p>Aucune tâche à faire !</p>';
    }
}
}
?>
