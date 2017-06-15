import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Graph {
	public int[][] lengths = new int[10][10];
	public Vertex[] vertex = new Vertex[10];
	public int[] weight = new int[9];
	public int[] mst = new int[10];

	public Graph() {

		vertex[0] = new Vertex("Psychology");
		vertex[1] = new Vertex("History");
		vertex[2] = new Vertex("Engineering");
		vertex[3] = new Vertex("Sociology");
		vertex[4] = new Vertex("Biology");
		vertex[5] = new Vertex("Business");
		vertex[6] = new Vertex("Languages");
		vertex[7] = new Vertex("Tourism");
		vertex[8] = new Vertex("Mathematics");
		vertex[9] = new Vertex("Theology");
        readFile();
        fillEdges();
	}

	public void readFile() {
		String[] splitted = null;
		String[] splitted2 = null;
		String[] splitted3 = null;
		String[] splitted4 = null;
		String[] splitted5 = null;
		String[] splitted6 = null;
		File file = new File("input.txt");
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String lines = null;
		try {
			lines = reader.readLine();
		} catch (IOException e) {

			e.printStackTrace();
		}

		for (int i = 0; i < 10; i++) {
			splitted = lines.split("\t");

			for (int j = 0; j < splitted.length; j++) {
				lengths[i][j] = Integer.parseInt(splitted[j]);
				
			}
			try {
				lines = reader.readLine();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		int index = getIndex(lines);

		for (int i = 0; i < 9; i++) {

			try {
				lines = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			splitted2 = lines.split("\t");

			for (int j = 0; j < splitted2.length; j++) {
				weight[j] = Integer.parseInt(splitted2[j]);

			}
			vertex[index].addBook(new Book(weight[0], weight[1]));
		}
		try {
			lines = reader.readLine();
		} catch (IOException e) {
			  e.printStackTrace();
		}
		int index1 = getIndex(lines);
		for (int i = 0; i < 9; i++) {

			try {
				lines = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			splitted3 = lines.split("\t");

			for (int j = 0; j < splitted3.length; j++) {
				weight[j] = Integer.parseInt(splitted3[j].trim());

			}
			vertex[index1].addBook(new Book(weight[0], weight[1]));
		}

		try {
			lines = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int index2 = getIndex(lines);
		for (int i = 0; i < 9; i++) {

			try {
				lines = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			splitted4 = lines.split("\t");

			for (int j = 0; j < splitted4.length; j++) {
				weight[j] = Integer.parseInt(splitted4[j].trim());

			}
			vertex[index2].addBook(new Book(weight[0], weight[1]));
		}
		try {
			lines = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int index3 = getIndex(lines);
		for (int i = 0; i < 6; i++) {

			try {
				lines = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			splitted5 = lines.split("\t");

			for (int j = 0; j < splitted5.length; j++) {
				weight[j] = Integer.parseInt(splitted5[j].trim());

			}
			vertex[index3].addBook(new Book(weight[0], weight[1]));
		}
		try {
			lines = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int index4 = getIndex(lines);
		for (int i = 0; i < 6; i++) {

			try {
				lines = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			splitted6 = lines.split("\t");

			for (int j = 0; j < splitted6.length; j++) {
				weight[j] = Integer.parseInt(splitted6[j].trim());

			}
			vertex[index4].addBook(new Book(weight[0], weight[1]));
		}

	}

	public void fillEdges() {
		for (int i = 0; i < lengths.length; i++) {
			for (int j = 0; j < lengths.length; j++) {
				if (lengths[i][j] != 0) {
					vertex[i].addEdges(new Edge(vertex[j], lengths[i][j]));
				}
			}
		}
	}

	public int getIndex(String name) {
		int k = 0;
		for (int i = 0; i < vertex.length; i++) {

			if ((vertex[i].name.equals(name))) {
				k = i;
				break;
			}
		}
		return k;

	}
	int minKey(int key[], Boolean mstSet[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index=-1;
 
        for (int v = 0; v < vertex.length; v++)
            if (mstSet[v] == false && key[v] < min)
            {
                min = key[v];
                min_index = v;
            }
 
        return min_index;
    }
 

    void primMST(Graph g)
    {
        // Array to store constructed MST
        int parent[] = new int[vertex.length];
 
        // Key values used to pick minimum weight edge in cut
        int key[] = new int [vertex.length];
 
        // To represent set of vertices not yet included in MST
        Boolean mstSet[] = new Boolean[vertex.length];
 
        
        for (int i = 0; i < vertex.length; i++)
        {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
 
        
        key[0] = 0;     
        parent[0] = -1; // First node is always root of MST
      int sum=0;
        
        for (int count = 0; count < vertex.length; count++)
        {
            
            int u = minKey(key, mstSet);
            if(count != 0){
            System.out.println(vertex[parent[u]].name+" --  "+vertex[u].name+"  ---  "+lengths[u][parent[u]]+ "m.");
            sum+=lengths[u][parent[u]];
            }
            // Add the picked vertex to the MST Set
            mstSet[u] = true;
 
            // Update key value and parent index of the adjacent
            // vertices of the picked vertex. Consider only those
            // vertices which are not yet included in MST
            for (int v = 0; v < vertex.length; v++)
 
                if (g.lengths[u][v]!=0 && mstSet[v] == false && g.lengths[u][v] <  key[v])
                {
                    parent[v]  = u;
                    key[v] = g.lengths[u][v];
                }
        }
        System.out.println();
        System.out.println("Total length of the MST : "+ sum+"m.");
    }
	
}