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
    public void testNumberOfComponentsAndComponentDistributionForConnectedGraph() {

        Graph graph = ReadGraphFile.read("testConnectedGraph");
        ArrayList<Integer> graphArray = graph.componentDistribution();

        Assert.assertTrue(graphArray.size()==1);  // number of components: 1

        Assert.assertTrue(graphArray.contains(10)); // size of component is 10

    }

    @Test
    public void testNumberOfComponentsAndComponentDistributionForDisconnectedGraph() {

        Graph graph = ReadGraphFile.read("testDisconnectedGraph");
        ArrayList<Integer> graphArray = graph.componentDistribution();

        Assert.assertTrue(graphArray.size()==3);  // number of components: 3

        Assert.assertTrue(graphArray.contains(4));
        Assert.assertTrue(graphArray.contains(5));
        Assert.assertTrue(graphArray.contains(7));

    }
}