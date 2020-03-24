/**
 *  utilisation de classes existantes
 *  @author Françoise GAYRAL
 */

import java.awt.Point;
import java.awt.Polygon;
import java.util.*;
public class TestUtilisationClasses
{
  public static void main(String[] args)	{
	// Pour l'exo B.1 sur les chaînes : utilisation de la classe String
	String sb = "Bonjour tout le monde ";
	String m = "monde";
	String mb = "    monde        "; //3 blancs au départ, 5 blancs à la fin
	String me = "et merci";
	// à compléter sur
  String mb1 = mb.trim();
  int b = m.length();
  int a = mb1.length();
  char c = m.charAt(0);
  String sbminus = sb.toLowerCase();
	System.out.println("la longueur de m est " + b + " et de mb " + a);
	System.out.println(c);
  System.out.println(sbminus);

  String fin="";
//  int i=0;
//  while (i<b)
//  {
//    fin = fin + m.charAt(i)+"-";
//    i++;
//  }
//    System.out.println(fin);

  for(int i = 0; i<b; i++)
   {
     fin = fin + m.charAt(i)+"-";
   }
   System.out.println(fin);

if(m.equals(mb))
{
   System.out.println("Egales");
}
else{
  System.out.println("Diff");
}

if(sb.charAt(sb.length()-1)=='m')
{
  System.out.println("fin est m");
}
else{
  System.out.println("ne fini pas par m");
}

if(sb.contains(m))
{
   System.out.println("Egales");
}
else{
  System.out.println("Diff");
}

  System.out.println(sb + me);

String o = me.replace('i','o');
System.out.println(o);


	// Pour l'exo B.1 sur les Point
	Point p1 = new Point(50,30);
	// B1.1 à compléter



	Point p2 = new Point(50,30);
  if(p2==p1)
  {
     System.out.println("Egales");
  }
  else{
    System.out.println("Diff");
  }

  if(p2.equals(p1))
  {
     System.out.println("Egales");
  }
  else{
    System.out.println("Diff");
  }

	// B1.2 à compléter




	Point p3 = p1;
  if(p3==p1)
  {
     System.out.println("Egales");
  }
  else{
    System.out.println("Diff");
  }

  if(p3.equals(p1))
  {
     System.out.println("Egales");
  }
  else{
    System.out.println("Diff");
  }
	// B1.3 à compléter




   }	// fin du main
}// fin de la classe TestUtilisationClasses
