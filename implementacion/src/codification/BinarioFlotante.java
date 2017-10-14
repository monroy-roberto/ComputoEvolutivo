import gaframework.*;
import java.lang.*;
import java.util.*;

public class BinarioFlotante implements Codification<Integer,Float>{
    final int numBitsEnt;
    final int numBitsDec;
    final int semilla;
    
    public BinarioFlotante(int ent, int dec, int sem) {
    	numBitsEnt = ent;
    	numBitsDec = dec;
	semilla = sem;
    }
    
    public Phenotype<Float> decode(Genotype<Integer> genotype){
	String binario = genotype.toString();
	String pEntera = binario.substring(0,numBitsEnt);
        String pDecimal = binario.substring(numBitsEnt,numBitsDec+numBitsEnt);
	float entFloat = (float) Integer.parseInt(pEntera,2);
	float decFloat = (float) Integer.parseInt(pDecimal,2);
	while (decFloat > 1) {
	    decFloat = decFloat/10;
	}
        Float feno = new Float(entFloat+decFloat);
	Phenotype<Float> resultado = new Phenotype<>(1);
	resultado.setAllele(0,feno);
	return resultado;
    }

    public Genotype<Integer> newRandomGenotype() {
	Genotype<Integer> geno = new Genotype<Integer>(numBitsEnt+numBitsDec);
	Random r = new Random(semilla);
	for (int i = 0; i < (numBitsEnt + numBitsDec); i++) {
	    geno.setGene(i,new Integer((r.nextBoolean())?1:0));
	}
	return geno;
    }

    public Genotype<Integer> encode(Phenotype<Float> phenotype) {
	return new Genotype<Integer>(numBitsEnt+numBitsDec);
    }

    // public void main(String... agrs) {	
    // 	Genotype<Integer> este =  newRandomGenotype();
    // 	System.out.println(este.toString());
    // }
}
