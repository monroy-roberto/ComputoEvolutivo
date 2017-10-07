import gaframework.*;
import java.util.Random;

/**
 * Implemenatcion del operado de mutación uniforme para 
 * maximizar una función
 **/
public class MutacionUniforme implements MutationOp<Integer> {

    private double probMutation;

    public MutacionUniforme(double probMut) {
        this.probMutation = probMut;
    }

    /**
     * Muta el genotipo dado utilizando el método de mutación uniforme utilizando
     * una probabilidad de mutación descrita en el constructor
     * @param genotyoe El genotipo a mutar
     * @return El genotipo mutado
     **/
    public Genotype<Integer> mutate(Genotype<Integer> genotype) {
        int size = genotype.size();
        Integer gen;
        Genotype<Integer> mutatedGeno = new Genotype<Integer>(size);
        Random generator = new Random();
        double dice; 
        for (int i = 0; i < size; i++) {
            dice = generator.nextDouble();
            if (dice <= probMutation) {
                gen = genotype.getGene(i);
                gen = auxMutate(gen);
                mutatedGeno.setGene(i,gen);
            } else {
                mutatedGeno.setGene(i,genotype.getGene(i));
            }
        }
        return mutatedGeno;
    }
    
    /**
     * Función auxiliar que cambian el valor de un gen 
     * @param gen El gen a mutar
     * @return El gen mutado
     **/
    private Integer auxMutate(Integer gen) {
        if (gen.intValue() == 0)
            return new Integer(1);
        else
            return new Integer(0);
    }
}
