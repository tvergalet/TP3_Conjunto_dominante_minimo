package bd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import modelo.grafo.Vertice;

public class AdmBaseDatos {

	private String bd_Vertices = "src/bd/vertice.json";
		
	public ArrayList<Vertice> obtenerVertices() {
		
		ArrayList<Vertice> listaVertices = new ArrayList<Vertice>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(bd_Vertices));
            Type tipoListaVertices = new TypeToken<ArrayList<Vertice>>() {}.getType();

            listaVertices = new Gson().fromJson(bufferedReader, tipoListaVertices);

            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listaVertices;
	}
	
	public void guardarVertices(ArrayList<Vertice> vertices) {
		try( FileWriter fileWriter = new FileWriter(bd_Vertices) ){
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			fileWriter.write(gson.toJson(vertices));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
