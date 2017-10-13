import gaframework.*;
import java.lang.*;
import java.math.*;

public class BinarioFlotante<G,P> implements Codification<Integer,Double>{
    private final static int numBitsEnt = 4;
    private final static int numBitsDec = 4;
    
    public Phenotype<Double> decode(Genotype<Integer> genotype){
	String geno = genotype.toString();
	String entera = geno.substring(0,numBitsEnt); //Cuantosdigitos
        String decimal = geno.substring(numBitsEnt,numBitsDec);//inlcusivo exclusivo
        Double feno1 = new Double(0);
	Double feno2 = new Double(0);
	feno1 = Double.longBitsToDouble(new BigInteger(entera,2).longValue());
	feno2 = Double.longBitsToDouble(new BigInteger("."+decimal,2).longValue());
        Double fenofase3 = feno1 + feno2;
	Phenotype<Double> resultado = new Phenotype<>(1);
	resultado.setAllele(0,fenofase3);
	System.out.println(fenofase3);
	return resultado;
    }

    public Genotype<Integer> newRandomGenotype() {
	Genotype<Integer> este = new Genotype<Integer>(numBitsEnt+numBitsDec);
	for (int i = 0; i < (numBitsEnt + numBitsDec); i++) {
	    este.setGene(i,new Integer(1));
	}
	return este;
    }

    public Genotype<Integer> encode(Phenotype<Double> phenotype) {
	return new Genotype<Integer>(numBitsEnt+numBitsDec);
    }

    public void main(String... agrs) {	
	Genotype<Integer> este =  newRandomGenotype();
	System.out.println(este.toString());
    }
}
