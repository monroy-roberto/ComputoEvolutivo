import gaframework.*;
import java.util.*;

public class BinarioFlotante implements Codification<Integer, Float>{
	
	final int numBitsEnt;
	final int numBitsDec;
	
	public Phenotype<Float> decode(Genotype<Integer> g){
		return null;
	}
	
	public Genotype<Integer> encode(Phenotype<Float> f){
		return null;
	}
	
	public BinarioFlotante(int a, int b){
		numBitsEnt = a;
		numBitsDec = b;
	}
	
	public Genotype<Integer> newRandomGenotype(){
		int size = numBitsDec+numBitsEnt;
		Genotype<Integer> g = new Genotype<Integer>(size);
		Random r = new Random();
		for(int i = 0; i < size; i++){
			if(r.nextDouble() > 0.5){
				g.setGene(i, new Integer(0));
			}else{
				g.setGene(i, new Integer(1));
			}
		}
		return g;
	}	
	
}
