import gaframework.*;
import java.util.*;

public class BinarioFlotante implements Codification<Integer, Float>{
	
	final int numBitsEnt;
	final int numBitsDec;
	final int semilla;
	
	public Phenotype<Float> decode(Genotype<Integer> g){
		return null;
	}
	
	public Genotype<Integer> encode(Phenotype<Float> f){
		return null;
	}
	
	public BinarioFlotante(int a, int b, int c ){
		numBitsEnt = a;
		numBitsDec = b;
		semilla = c; 
	}
	
	public Genotype<Integer> newRandomGenotype(){
		int size = numBitsDec+numBitsEnt;
		Genotype<Integer> g = new Genotype<Integer>(size);
		Random r = new Random(semilla);
		for(int i = 0; i < size; i++){
			if(r.nextDouble() > 0.5){
				g.setGene(i, new Integer(0));
			}else{
				g.setGene(i, new Integer(1));
			}
		}
		return g;
	}
	
	public static void main(String[] args){
		BinarioFlotante bf =  new BinarioFlotante(5,5,5);
		System.out.println(bf.newRandomGenotype());
	}
	
}
