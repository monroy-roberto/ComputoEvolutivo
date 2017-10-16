import gaframework.Genotype;
import gaframework.MutationOp;
import java.util.Random;

/**
 * Implementación del operador de mutación uniforme para 
 * maximizar una función, 
 **/
public class MutacionUniforme implements MutationOp<Integer> {

    private double probMutation;

    /**
     * Construye un operador de mutación uniforme con una probabilidad de mutación
     * indicada
     * @param probMut La probabilidad de mutación
     **/
    public MutacionUniforme(double probMut) {
        this.probMutation = probMut;
    }

    /**
     * Muta el genotipo dado utilizando el método de mutación uniforme, con
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
     * Función auxiliar que cambia el valor de un gen 
     * @param gen El gen a mutar
     * @return El gen mutado
     **/
    private Integer auxMutate(Integer gen) {
        if (gen.intValue() == 0)
            return new Integer(1);
        else
            return new Integer(0);
    }
    
    /**
     * Funcion pequena para probar el operador de mutacion.
     * Muta el genotipo {0,1,0,1,0,1,0,1,0,1} dada una mutacion en formato de 
     * punto decimal, si no se indica probabilidad de mutacion se toma la probabilidad
     * 0.10
     * Utilizando la semilla long seed = 25693; con probMutacion de 0.25 se obtuvo el
     * resultado {0,1,1,1,0,1,0,1,1,0}
     */
    public static void main(String[] args){
        double probMut = 0.10;
        if (args.length != 0 && args[0] != null)
            probMut = Double.parseDouble(args[0]);
        Genotype<Integer> test = new Genotype<>(10);
        MutacionUniforme mutator = new MutacionUniforme(probMut);
        Integer j;
        for (int i = 0; i < test.size(); i++) {
            if (i % 2 == 0)
                j = new Integer(0);
            else
                j = new Integer(1);
            test.setGene(i,j);
        }
        int repetitions = 0;
        System.out.println("Genotipo sin mutar:" + '\n' + test.toString());
        test = mutator.mutate(test);
        System.out.println("Genotipo Mutado" + '\n' + test.toString());
    }
}
