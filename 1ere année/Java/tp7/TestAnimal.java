import java.util.ArrayList;

public class TestAnimal{
  public static void main(String[] args) {
    Animal a;
    a=new Animal();
    a.crier();
    a=new Chien();
    a.crier();

    ArrayList<Animal> menagerie=new ArrayList<Animal>();
    menagerie.add(new Chien());
    menagerie.add(new Animal());
    menagerie.add(new Chat());

    for (Animal animal : menagerie)
        animal.crier();

    Chien c=new Chien();
    a=new Chat(9);
    c.manger();
    ((Chat)a).manger();
    ((Chien)c).manger();

    //Chien c=new Animal();
    //Chien c=new Chat();

    c.manger();
    c.crier();
    a=((Animal)c);
    a.crier();

  }
}
