package bd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import modelo.grafo.Vertice;

public class AdmBaseDatos {

	private String bd_Vertices = "src/bd/vertice.json";
		
	public Set<Vertice> obtenerVertices() {
		
        Set<Vertice> listaVertices = new HashSet<Vertice>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(bd_Vertices));
            Type tipoListaVertices = new TypeToken<Set<Vertice>>() {}.getType();

            listaVertices = new Gson().fromJson(bufferedReader, tipoListaVertices);

            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listaVertices;
	}
	
	public void guardarVertices(Set<Vertice> vertices) {
		try( FileWriter fileWriter = new FileWriter(bd_Vertices) ){
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			fileWriter.write(gson.toJson(vertices));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
