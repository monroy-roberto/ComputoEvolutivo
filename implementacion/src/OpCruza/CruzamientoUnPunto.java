
import gaframework.*;
import java.util.*;

public class CruzamientoUnPunto<G> implements CrossoverOp<G>{

    /**
     * Método para hacer cruzamiento de un punto
     * Seleccionamos un punto al azar de dos genotipos
     * Combinamos los dos genotipos para generar dos nuevos
     * @param lista - La lista de genotipos de la poblacion actual
     * @return lista - La lista con los dos nuevos genotipos que generamos
     */
    public List<Genotype<G>> crossover(List<Genotype<G>> lista){
	Random random = new Random();
	//Verificamos que al menos haya dos genotipos en la lista
	if(!lista.isEmpty() && lista.size() > 1){
	    //Sacamos los dos primeros genotipos de la lista
	    Genotype<G> gen1 = lista.get(0);
	    Genotype<G> gen2 = lista.get(1);
	    int tam = gen1.size();
	    //Genera el punto de corte
	    int punto = Math.abs(random.nextInt()) % tam;
	    //Creamos dos nuevos genotipos para llenarlos al hacer el punto de corte en los otros dos genotipos que sacamos de la lista
	    Genotype<G> cop1 = new Genotype<>(tam);
	    Genotype<G> cop2 = new Genotype<>(tam);
	    for(int i=0;i < punto+1;i++){
		G g1 = gen1.getGene(i);
		cop1.setGene(i,g1);
	    }
	    for(int j=punto+1; j < tam;j++){
		G g2 = gen2.getGene(j);
		cop1.setGene(j,g2);
	    }
	    for(int k=0;k < punto+1;k++){
		G g3 = gen2.getGene(k);
		cop2.setGene(k,g3);
	    }
	    for(int l=punto+1;l < tam;l++ ){
		G g4 = gen1.getGene(l);
		cop2.setGene(l,g4);
	    }
	    lista.add(cop1);
	    lista.add(cop2);
	}

	return lista;
	
    }
    
}
