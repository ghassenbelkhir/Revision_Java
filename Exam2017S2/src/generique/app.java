package generique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.function.BiPredicate;
import java.util.function.Supplier;

public class app {


	// Examen Deuxi�me Session  28/06/2017

	//une m�thode qui prend en argument deux listes l1, l2 d'objets Comparable entre eux et
	//qui remplace chaque �l�ment l1 par l'�l�ment � la m�me position en l2, si ce dernier est
	//plus grand (on suppose que les deux listes aient la m�me taille) ;

	public <T extends Comparable<T> > void question1(List<? super T > listdst ,List<? extends T> listsrc)
	{
		for(int i=0;i<listdst.size();i++)
		{
			listdst.set(i, listsrc.get(i));
		}
		
		
	}


	

	//une m�thode qui prend en argument une liste l de Supplier et qui renvoie la liste qui
	//contient, pour chaque element s de l, les trois premiers �l�ments produits par s ;

	public <T> List<T> question2(List<Supplier<? extends T>> l)
	{

		List<T> newlist = new ArrayList<T>();
		for (Supplier<? extends T> s: l)
		{
			newlist.add(s.get());
			newlist.add(s.get());
			newlist.add(s.get());
		}
		return newlist;

	}

	//une m�thode qui prend en argument une liste de listes l, et un �l�ment e. On dit qu'un liste
	//est "bonne" si elle contient e. La m�thode doit renvoyer l'ensemble de tous les �l�ments
	//qui appartiennent � au moins une bonne liste de l.

	public <T> List<T> question3(List<? extends List<? extends T>> l,  T e)
	{
		List<T> newlist = new ArrayList<>();

		for( List<? extends T> ll : l) {

			if(ll.contains(e))
				newlist.addAll(ll);
		}

		return newlist;
	}


	//Examen Premi�re Session   14/12/2016

	// une m�thode qui prend en entr�e deux Supplier d'objets Comparable et qui renvoie le
	//plus petits �l�ment produit par les deux suppliers ;

	public <T  extends Comparable<T>> T MinSupplier(Supplier<? extends T> sup1,Supplier<? extends T> sup2)
	{
		T element1 = sup1.get();
		T element2 = sup1.get();
		if(element1.compareTo(element2)>0)
			return sup2.get();
		else 
			return sup1.get();
	}

	//une m�thode qui prend en entr�e une List ls et un Comparator et qui renvoie une List
	//qui contient les trois plus petits �l�ments de ls ;

	public static  <T extends Comparable<T>> List<T> petitElm(List<? extends T> ls,Comparator<T> cmp)
	{
		List<T> newlist = new ArrayList<T>();
		ls.sort(ls,cmp);
		newlist.add(ls.get(0));
		newlist.add(ls.get(1));
		newlist.add(ls.get(2));

		return newlist;
	}


	//une m�thode qui prend en entr�e une Collection c de List et qui renvoie une List qui
	//contient tous les �l�ments qui apparaissent dans toutes les listes de c ;

	public static <T> List<T> includeLists(Collection<List<? extends T>> c)
	{
		List<T> ll = new ArrayList<>();

		for (List<? extends T> l : c)
		{
			ll.addAll(l);
		}

		return ll;

	}



	//Examen Premi�re Session   20/12/2017

	// une methode qui prend en entr�� deux List et un comarator et qui renvoie une list qui contient les elements
	// des deux listes tri�s en ordre croissant
	public static <T > List<T> ListTrie(List<? extends T> l1,List< ?  extends T> l2, Comparator<T> cmp)
	{
		List<T> ll = new ArrayList<>();

		ll.addAll(l1);
		ll.addAll(l2);

		ll.sort(cmp); 

		return ll;


	}


	//une m�thode qui prend en entr�e une list l de Map, et un object k, et qui renvoie une List qui contient tous les �lements
	// qui sont associ�s � k par une des maps de la list l.

	public static <K,T> List<T> AssocieMap(List<Map<? extends K,? extends T>> listOfMap, K k)
	{
		List<T> ll = new ArrayList<>();
		for(Map<? extends K, ? extends T> mymap :listOfMap )
		{
			ll.add(mymap.get(k));
		}
		return ll;
	}



	// une m�thode qui prend en entr�e un BiPredicate p d'objets Comparable et qui renvoie le BiPredicate qui test 
	// si p est vrai et si le premier argument est plus petit que le deuxieme

	public static <T extends Comparable<T>>  BiPredicate<T,T> TestPredicate(BiPredicate<T,T> p)
	{
		return p.and((a,b)->{ if(a.compareTo(b)>0)

			return false;
		else
			return true;
		});
	}

	public static void main(String[] args) {
		List<Integer> l1 = Arrays.asList(1,2,5);
		List<Integer> l2 = Arrays.asList(9,8,0);
		
		List<Integer> ll = ListTrie(l1,l2,Integer::compareTo);
		
		System.out.println(ll);
		
		ArrayList<B> ll1 = new ArrayList<>();
		ArrayList<B> ll2 = new ArrayList<>();
		
		List<B> lll = ListTrie(ll1,ll2,null);
		
		System.out.println(lll);
	
		
	}


}
