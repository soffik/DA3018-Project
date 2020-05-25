import org.junit.Assert;
import org.junit.Test;
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
    public void testDegreeDistributionForTestFile2() {
        Graph graph = ReadDataFile.readFile("testFile2.txt");
        HashMap<Integer, Integer> degreeMap = graph.degreeDistribution();

        Assert.assertTrue(degreeMap.containsKey(1)); // All nodes has only one neighbor

        Assert.assertTrue(degreeMap.size()==1);  // check size

        Assert.assertTrue(degreeMap.get(1)==40);
    }

    @Test
    public void testDegreeDistributionForTestFile3() {
        Graph graph = ReadDataFile.readFile("testFile3.txt");
        HashMap<Integer, Integer> degreeMap = graph.degreeDistribution();

        Assert.assertTrue(degreeMap.containsKey(1));
        Assert.assertTrue(degreeMap.containsKey(2));
        Assert.assertTrue(degreeMap.containsKey(7));

        Assert.assertTrue(degreeMap.size()==3);  // check size

        Assert.assertTrue(degreeMap.get(1)==22);
        Assert.assertTrue(degreeMap.get(2)==2);
        Assert.assertTrue(degreeMap.get(7)==2);
    }


    @Test
    public void testNumberOfComponentsAndComponentDistributionForConnectedGraph() {

        Graph graph = ReadGraphFile.read("testConnectedGraph");

        HashMap<Integer, Integer> compSizeMap = graph.componentDistribution();

        Assert.assertTrue(compSizeMap.size()==1);  // one component

        // check number of components:
        int size = 0;
        for (Integer i: compSizeMap.values())
            size += i;

        Assert.assertTrue(size==1);

        Assert.assertTrue(compSizeMap.containsKey(10)); // size of component is 10
        Assert.assertTrue(compSizeMap.get(10)==1);  // only one components has size 10

    }

    @Test
    public void testNumberOfComponentsAndComponentDistributionForDisconnectedGraph() {

        Graph graph = ReadGraphFile.read("testDisconnectedGraph");
        HashMap<Integer, Integer> compSizeMap = graph.componentDistribution();

        Assert.assertTrue(compSizeMap.size()==3);

        // check number of components:
        int size = 0;
        for (Integer i: compSizeMap.values())
            size += i;

        Assert.assertTrue(size==3);

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

        Assert.assertTrue(compSizeMap.size()==4);

        // check number of components:
        int size = 0;
        for (Integer i: compSizeMap.values())
            size += i;

        Assert.assertTrue(size==4);

        Assert.assertTrue(compSizeMap.containsKey(2));
        Assert.assertTrue(compSizeMap.get(2)==1);

        Assert.assertTrue(compSizeMap.containsKey(5));
        Assert.assertTrue(compSizeMap.get(5)==1);

        Assert.assertTrue(compSizeMap.containsKey(8));
        Assert.assertTrue(compSizeMap.get(8)==1);

        Assert.assertTrue(compSizeMap.containsKey(9));
        Assert.assertTrue(compSizeMap.get(9)==1);

    }

    @Test
    public void testNumberOfComponentsAndComponentDistributionForTestFile2() {

        Graph graph = ReadDataFile.readFile("testFile2.txt");
        HashMap<Integer, Integer> compSizeMap = graph.componentDistribution();

        Assert.assertTrue(compSizeMap.size()==1);

        // check number of components:
        int size = 0;
        for (Integer i: compSizeMap.values())
            size += i;

        Assert.assertTrue(size==20);

        Assert.assertTrue(compSizeMap.containsKey(2));  // all components has size 2
        Assert.assertTrue(compSizeMap.get(2)==20);

    }

    @Test
    public void testNumberOfComponentsAndComponentDistributionForTestFile3() {

        Graph graph = ReadDataFile.readFile("testFile3.txt");
        HashMap<Integer, Integer> compSizeMap = graph.componentDistribution();

        Assert.assertTrue(compSizeMap.size()==3);

        // check number of components:
        // check number of components:
        int size = 0;
        for (Integer i: compSizeMap.values())
            size += i;

        Assert.assertTrue(size==6);

        Assert.assertTrue(compSizeMap.containsKey(2));
        Assert.assertTrue(compSizeMap.get(2)==2);

        Assert.assertTrue(compSizeMap.containsKey(3));
        Assert.assertTrue(compSizeMap.get(3)==2);

        Assert.assertTrue(compSizeMap.containsKey(8));
        Assert.assertTrue(compSizeMap.get(8)==2);

    }

}