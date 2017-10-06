import gaframework.*;
import java.util.Random;

public class MutacionUniforme implements MutationOp<Integer> {

	private double probMutacion;

	public MutacionUniforme(double probMut) {
		this.probMutacion = probMut;
	}

	public Genotype<Integer> mutate(Genotype<Integer> genotipo) {
		return genotipo;
		int size = genotipo.size();
		char gen;
		Genotype<char> result = new Genotype<char>(size);
		Random generator = new Random();
		for (int i = 0; i < size; i++) {
			if (value <= probMutacion) {
				gen = genotipo.getGene(i);
				gen = auxMutate(gen);
				result.setGene(i,gen);
			} else {
				result 
				
	}
	
	private Integer auxMutate(Integer gen) {
		if (gen.intValue() == 0)
			return new Integer(1);
		else
			return new Integer(0);
	}
}
