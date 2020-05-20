import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphTest {


    @Test
    public void testDegreeDistributionForConnectedGraph() {
        Graph graph = ReadGraphFile.read("testConnectedGraph");
        HashMap<Integer, Integer> degreeMap = graph.degreeDistribution();

        Assert.assertTrue(degreeMap.containsKey(1)); // check that all keys are there
        Assert.assertTrue(degreeMap.containsKey(2));
        Assert.assertTrue(degreeMap.containsKey(3));
        Assert.assertTrue(degreeMap.containsKey(4));

        Assert.assertTrue(degreeMap.size()==4);  // check size

        Assert.assertTrue(degreeMap.get(1)==2);  // check values
        Assert.assertTrue(degreeMap.get(2)==4);
        Assert.assertTrue(degreeMap.get(3)==2);
        Assert.assertTrue(degreeMap.get(4)==2);
    }

    @Test
    public void testDegreeDistributionForDisconnectedGraph() {
        Graph graph = ReadGraphFile.read("testDisconnectedGraph");
        HashMap<Integer, Integer> degreeMap = graph.degreeDistribution();

        Assert.assertTrue(degreeMap.containsKey(1)); // check that all keys are there
        Assert.assertTrue(degreeMap.containsKey(2));
        Assert.assertTrue(degreeMap.containsKey(3));
        Assert.assertTrue(degreeMap.containsKey(4));
        Assert.assertTrue(degreeMap.containsKey(6));

        Assert.assertTrue(degreeMap.size()==5);  // check size

        Assert.assertTrue(degreeMap.get(1)==4);  // check values
        Assert.assertTrue(degreeMap.get(2)==5);
        Assert.assertTrue(degreeMap.get(3)==4);
        Assert.assertTrue(degreeMap.get(4)==2);
        Assert.assertTrue(degreeMap.get(6)==1);
    }

    @Test
    public void testDegreeDistributionForTestFile1() {
        Graph graph = ReadDataFile.readFile("testFile1.txt");
        HashMap<Integer, Integer> degreeMap = graph.degreeDistribution();

        Assert.assertTrue(degreeMap.containsKey(1)); // check that all keys are there
        Assert.assertTrue(degreeMap.containsKey(4));
        Assert.assertTrue(degreeMap.containsKey(7));
        Assert.assertTrue(degreeMap.containsKey(8));

        Assert.assertTrue(degreeMap.size()==4);  // check size

        Assert.assertTrue(degreeMap.get(1)==21);  // check values
        Assert.assertTrue(degreeMap.get(4)==1);
        Assert.assertTrue(degreeMap.get(7)==1);
        Assert.assertTrue(degreeMap.get(8)==1);
    }

    @Test
    public void testNumberOfComponentsAndComponentDistributionForConnectedGraph() {

        Graph graph = ReadGraphFile.read("testConnectedGraph");

        HashMap<Integer, Integer> compSizeMap = graph.componentDistribution();

        Assert.assertTrue(compSizeMap.size()==2);  // one component and component size

        // check number of components:
        Assert.assertTrue(compSizeMap.containsKey(-1)); //
        Assert.assertTrue(compSizeMap.get(-1)==1);  // only one component

        Assert.assertTrue(compSizeMap.containsKey(10)); // size of component is 10
        Assert.assertTrue(compSizeMap.get(10)==1);  // only one components has size 10

    }

    @Test
    public void testNumberOfComponentsAndComponentDistributionForDisconnectedGraph() {

        Graph graph = ReadGraphFile.read("testDisconnectedGraph");
        HashMap<Integer, Integer> compSizeMap = graph.componentDistribution();

        Assert.assertTrue(compSizeMap.size()==4);

        // check number of components:
        Assert.assertTrue(compSizeMap.containsKey(-1));
        Assert.assertTrue(compSizeMap.get(-1)==3);  // 3 components

        Assert.assertTrue(compSizeMap.containsKey(4));
        Assert.assertTrue(compSizeMap.get(4)==1);

        Assert.assertTrue(compSizeMap.containsKey(5));
        Assert.assertTrue(compSizeMap.get(5)==1);

        Assert.assertTrue(compSizeMap.containsKey(7));
        Assert.assertTrue(compSizeMap.get(7)==1);

    }

    @Test
    public void testNumberOfComponentsAndComponentDistributionForTestFile1() {

        Graph graph = ReadDataFile.readFile("testFile1.txt");
        HashMap<Integer, Integer> compSizeMap = graph.componentDistribution();

        Assert.assertTrue(compSizeMap.size()==5);

        // check number of components:
        Assert.assertTrue(compSizeMap.containsKey(-1)); //
        Assert.assertTrue(compSizeMap.get(-1)==4);  // 4 components

        Assert.assertTrue(compSizeMap.containsKey(2));
        Assert.assertTrue(compSizeMap.get(2)==1);

        Assert.assertTrue(compSizeMap.containsKey(5));
        Assert.assertTrue(compSizeMap.get(5)==1);

        Assert.assertTrue(compSizeMap.containsKey(8));
        Assert.assertTrue(compSizeMap.get(8)==1);

        Assert.assertTrue(compSizeMap.containsKey(9));
        Assert.assertTrue(compSizeMap.get(9)==1);

    }
}