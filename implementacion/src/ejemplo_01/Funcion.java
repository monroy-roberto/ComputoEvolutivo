import gaframework.*;
import java.util.*;

public class Funcion implements FitnessFunction<Float>{

	public double evaluate(Phenotype<Float> p){
		Float x = p.getAllele(0);
		double y = ((11.0/2)*x) - (7.0/2);
		return (1-(y*y)) * (Math.cos(y)+1) + 2;
	}
	
	public static void main(String[] args){
		Funcion f = new Funcion();
		Phenotype<Float> ft = new Phenotype<Float>(1);
		ft.setAllele(0,1.3f);
		System.out.println(f.evaluate(ft));
	}

}