package tpop;

import org.apache.commons.configuration.Configuration;
import org.apache.tinkerpop.gremlin.orientdb.OrientGraph;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.process.traversal.step.map.GraphStep;
import org.apache.tinkerpop.gremlin.structure.*;
import org.apache.tinkerpop.gremlin.tinkergraph.structure.TinkerGraph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__.as;
import static org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__.has;


public class TinkerPopApplication {

    public static void main(String args[]) {
        System.out.println("faf");

        Graph graph= OrientGraph.open("remote:localhost/demo-hackathon", "root", "rootpwd");


//        ((OrientGraph) graph).createVertexClass("user");
//
//        ((OrientGraph) graph).createVertexClass("job");
//
//        ((OrientGraph) graph).createEdgeClass("has job");

//        Graph graph = OrientGraph.open("remote:localhost/demo-hackathon", "root", "rootpwd");
//        graph.tx().open();
//        Vertex marko = graph.addVertex(T.label, "person", "name", "marko", "age", 29);
//        Vertex vadas = graph.addVertex(T.label, "person", "name", "vadas", "age", 27);
//        Vertex lop = graph.addVertex(T.label, "software", "name", "lop", "lang", "java");
//        Vertex josh = graph.addVertex(T.label, "person",  "name", "josh", "age", 32);
//        Vertex ripple = graph.addVertex(T.label, "software",  "name", "ripple", "lang", "java");
//        Vertex peter = graph.addVertex(T.label, "person",   "name", "peter", "age", 35);
//        Vertex nu = graph.addVertex(T.label, "company", "name", "acqio", "duration", 2);
//        Vertex nu3 = graph.addVertex(T.label, "company", "name", "ragevg", "duration", 9);
//        marko.addEdge("knows", vadas,   "weight", 0.5f);
//        marko.addEdge("knows", josh,   "weight", 1.0f);
//        marko.addEdge("created", lop,   "weight", 0.4f);
//        josh.addEdge("created", ripple,   "weight", 1.0f);
//        josh.addEdge("created", lop,   "weight", 0.4f);
//        peter.addEdge("created", lop,   "weight", 0.2f);
//
//        ripple.addEdge("works", nu,   "weight", 0.2f);
//        lop.addEdge("works", nu3,   "weight", 0.2f);



//        Set<String> vertexKeys = ((OrientGraph) graph).getVertexIndexedKeys("software");
//
//        System.out.println(((OrientGraph) graph).existClass("person"));
//
//
//       vertexKeys = ((OrientGraph) graph).getIndexedKeys("person");
//
//        System.out.println(graph.features());
//
//        graph.traversal().V().explain();

        Iterator<Vertex> vertexIterator = graph.vertices();

        Set<String> propertyKeys = new HashSet<String>();

        Set<String> vertexClassSet = new HashSet<String>();

        while (vertexIterator.hasNext()) {
           // System.out.println(iterator.next().keys());
            Vertex vertex = vertexIterator.next();

            if(vertex.label().equalsIgnoreCase("software")){
                propertyKeys.addAll(vertex.keys());

                Iterator<Vertex> outwardConnectedVertexIterator = vertex.vertices(Direction.OUT);

                while(outwardConnectedVertexIterator.hasNext()) {

                    vertexClassSet.add(outwardConnectedVertexIterator.next().label());
                }

            }


        }



        //        Set<String> vertexKeys = ((OrientGraph) graph).getVertexIndexedKeys("software");
//
//        System.out.println(((OrientGraph) graph).existClass("person"));
//
//
//       vertexKeys = ((OrientGraph) graph).getIndexedKeys("person");
//
//        System.out.println(graph.features());
//
//        graph.traversal().V().explain();

       // graph.vertices("#39:0").next();


        System.out.println(String.format("Attributes list is %s ", propertyKeys));

        System.out.println(String.format("List of connected vertex classes are %s ", vertexClassSet));


//        System.out.println(graph.traversal().V().hasLabel("person").outE("knows").toList().get(0).id());
//
//        System.out.println(graph.traversal().V().match(as("per").out("created").as("software")).toList());
//
//        System.out.println(graph.traversal().V().hasLabel("person").outE().outV().outE().outV().toList());
//
//        System.out.println(graph.traversal().V().hasLabel("person").out("created").toList());

        System.out.println(graph.traversal().V().hasLabel("person").in("works").toList());



        Iterator<Vertex> vertexIterator1 = graph.vertices();

        String from = "person";

        GraphTraversal graphTraversal;

        while(vertexIterator1.hasNext()) {

            Vertex vertex = vertexIterator1.next();


            if(vertex.label().equals(from)) {

               graphTraversal = graph.traversal().V().hasLabel("person");

            //   graphTraversal = graphTraversal.outE().outV().toList();

              // System.out.println(graphTraversal.values()).values("lang").next()



              //  while()
            }

        }

        //System.out.println(graph.traversal().V().match(as("person").out("created").as("software"), has()));





    }
}
