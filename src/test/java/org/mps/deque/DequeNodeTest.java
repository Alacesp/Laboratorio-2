package org.mps.deque;
/*
  Test cases

  Cases when the node is empty
  1. Item == null
  2. Previous == null
  3. Next == null
  4. setItem
  5. setPrevious
  6. setNext

  Cases with multiple nodes
  7. checks node1 is the first node
  8. checks node 2 is not terminal
  9. checks node 1 is terminal
  10. checks node 3 is terminal
  11. checks node 3 is last
 */
/**
 * @author Alvaro Acedo Espejo
 * @author Jose Torres Postigo
 */

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("A node")
public class DequeNodeTest {
    @Nested
    @DisplayName("Cases when the node is empty")
    class TestCasesNodeEmpty{
        DequeNode<Integer> node;
        @BeforeEach
        void setup(){
            node = new DequeNode<Integer>(null,null,null);
        }
        @Test
        void emptyNodeNullItem(){
            assertEquals(null, node.getItem());
        }

        @Test
        void emptyNodeNullPrevious(){
            assertEquals(null, node.getPrevious());
        }

        @Test
        void emptyNodeNullNext(){
            assertEquals(null, node.getNext());
        }

        @Test
        void emptyNodeSetItem(){
            node.setItem(3);
            assertEquals(3, node.getItem());
        }


        @Test
        void emptyNodeSetPrevious(){
            DequeNode <Integer> other = new DequeNode<>(null, null, null);
            node.setPrevious(other);
            assertEquals(other, node.getPrevious());
        }

        @Test
        void emptyNodeSetNext(){
            DequeNode <Integer> other = new DequeNode<>(null, null, null);
            node.setNext(other);
            assertEquals(other, node.getNext());
        }

        @AfterEach
        void shutdown(){
            node = null;
        }

    }
    @Nested
    @DisplayName("Cases with multiple nodes")
    class TestCasesMultipleNodes{
        DequeNode <Integer> node1;
        DequeNode <Integer> node2;
        DequeNode <Integer> node3;
        @BeforeEach
        void setup(){
            node1 = new DequeNode<>(4, null, null);
            node2 = new DequeNode<>(2, null, null);
            node3 = new DequeNode<>(0, null, null);
            node1.setNext(node2);
            node2.setPrevious(node1);
            node2.setNext(node3);
            node3.setPrevious(node2);
        }
        @Test
        void primerNodo(){
            assertEquals(true, node1.isFirstNode());
        }
        @Test
        void esNodoIntermedio(){
            assertEquals(true, node2.isNotATerminalNode());
        }
        @Test
        void noEsNodoIntermedioPrimero(){
            assertEquals(false, node1.isNotATerminalNode());
        }
        @Test
        void noEsNodoIntermedioUltimo(){
            assertEquals(false, node3.isNotATerminalNode());
        }
        @Test
        void ultimoNodo(){
            assertEquals(true, node3.isLastNode());
        }
        @AfterEach
        void shutdown(){
            node1 = null;
            node2 = null;
            node3 = null;
        }
    }
}
