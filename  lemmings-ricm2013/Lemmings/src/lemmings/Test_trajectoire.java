package lemmings;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;




public class Test_trajectoire {
	
public static void main(String[] args) throws IOException{
	
		
		trajectoireparaphysique tp = new trajectoireparaphysique(0, 0, 200,Math.PI/4 ,0);
		for(int i = 0 ; i<200;i++){
			int y = tp.calculy(i);
			int x=tp.calculx(i);
			System.out.println("valeur de x finale");			
			System.out.println(x);
			System.out.println("valeur de y finale");			
			System.out.println(y);	}
		
	}

}
