import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        if (args.length==1) {
            Graph graph = ReadDataFile.readFile(args[0]);

            HashMap<Integer, Integer> degreeMap = graph.degreeDistribution();
            HashMap<Integer, Integer> compSizeMap = graph.componentDistribution();

            // code below is inspired from:
            // https://www.javacodeexamples.com/write-hashmap-to-text-file-in-java-example/2353

            File degreeFile = new File("result/d_" + args[0]);  // containing result of degree distribution
            File compFile = new File("result/c_" + args[0]); // containing result of comp-size distribution
            File numNodeAndComp = new File("result/nrNodesAndComps.txt");

            BufferedWriter bfDegree = null;
            BufferedWriter bfComp = null;
            BufferedWriter bfNum = null;

            int numberOfNodes = 0;
            int numberOfComponents = 0;

            try{

                //create new BufferedWriter for the output file
                bfDegree = new BufferedWriter( new FileWriter(degreeFile) );
                bfComp = new BufferedWriter( new FileWriter(compFile) );
                bfNum = new BufferedWriter( new FileWriter(numNodeAndComp) );

                //iterate map entries
                for(Map.Entry<Integer, Integer> entry : degreeMap.entrySet()){

                    //put key and value separated by a space
                    bfDegree.write( entry.getKey() + " " + entry.getValue() );

                    numberOfNodes += entry.getValue();

                    //new line
                    bfDegree.newLine();
                }

                for(Map.Entry<Integer, Integer> entry : compSizeMap.entrySet()){

                    bfComp.write( entry.getKey() + " " + entry.getValue() );

                    numberOfComponents += entry.getValue();

                    bfComp.newLine();
                }

                bfNum.write("Number of nodes: " + numberOfNodes);
                bfNum.newLine();
                bfNum.write("Number of components: " + numberOfComponents);

                bfDegree.flush();
                bfComp.flush();
                bfNum.flush();

            }catch(IOException e){
                System.err.println(e.getMessage());
            }finally{

                try{
                    if (bfDegree != null) {
                        bfDegree.close();
                    }
                    if (bfComp != null) {
                        bfComp.close();
                    }
                    if (bfNum != null) {
                        bfNum.close();
                    }
                } catch(IOException e){
                    System.err.println(e.getMessage());
                }
            }


        }
    }


}
