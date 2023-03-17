package org.mps.deque;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

/*
    Test Cases

    Cases related to creation of Deque
    1. Deque must not be null
    2. Deque must be empty


    Cases related to first node
        Prepending
            3. a null value -> Throws exception
            4. values to a Deque add them at the beginning

        Deleting
            5. in a empty Deque -> Throws exception
            6. in a non empty Deque erases the first node

        Get first node value
            7. in a empty Deque -> Throws exception
            8. in a Deque returns the first value


    Cases related to last node
        Appending
            9. a null value -> Throws exception
            10. values to a Deque add them at the end

        Deleting
            11. in a empty Deque -> Throws exception
            12. in a non empty Deque erases the last node

        Get last node value
            13. in a empty Deque -> Throws exception
            14. in a Deque returns the last value

*/

/**
 * @author Alvaro Acedo Espejo
 * @author Jose Torres Postigo
 */

@DisplayName("A deque")
public class DoublyLinkedListDequeTest {

    DoublyLinkedListDeque<Integer> dq;

    @BeforeEach
    void setUp() {
        dq = new DoublyLinkedListDeque<Integer>();
    }

    @AfterEach
    void tearDown() {
        dq = null;
    }

    @DisplayName("When created, deque must not be null.")
    @Test
    void dequeNotNull() {
        assertNotNull(dq);
    }

    @DisplayName("When created, deque must be empty.")
    @Test
    void dequeIsEmpty() {
        int expectedSize = 0;
        int actualSize = dq.size();
        assertEquals(expectedSize, actualSize);
    }

    @DisplayName("Methods related to first node:")
    @Nested
    class methodsForFirstNode{

        @DisplayName("Prepending")
        @Nested
        class prependingTest{
            @Test
            void prependWithNullValueThrowsException(){
                assertThrows(DoubleEndedQueueException.class, ()-> dq.prepend(null));
            }
            @Test
            void prependToDeque(){
                Integer[] values = {1, 2, 3, 4, 5};

                for (Integer value : values) {
                    dq.prepend(value);
                    assertEquals(value, dq.first());
                }
            }
        }

        @DisplayName("Deleting first node")
        @Nested
        class deletingFirstNode{

            @DisplayName("of a empty deque throws exception")
            @Test
            void deleteFirstNodeOfEmptyDequeThrowsException() {
                assertThrows(DoubleEndedQueueException.class, () -> dq.deleteFirst());
            }

            @DisplayName("of a Deque ")
            @Test
            void deleteFirstNodeOfNonEmptyDeque() {
                Integer[] values = {1, 2, 3, 4, 5};

                for (Integer value : values) {
                    dq.prepend(value);
                }

                for (int i = values.length -2; i >= 0; i--) {
                    dq.deleteFirst();
                    int expectedValue = values[i];
                    int actualValue = dq.first();
                    assertEquals(expectedValue, actualValue);
                }
                dq.deleteFirst();
                assertEquals(0, dq.size());
            }
        }

        @DisplayName("Getting first node value")
        @Nested
        class gettingFirstNodeValueTests {
            @DisplayName("of a empty deque throws exception")
            @Test
            void lastOfEmptyDequeThrowsException() {
                assertThrows(DoubleEndedQueueException.class, () -> dq.first());
            }

            @DisplayName("of a deque returns first node value")
            @Test
            void firstNodeValue() {
                int expectedValue = 1;
                dq.prepend(expectedValue);
                int actualValue = dq.first();

                assertEquals(expectedValue, actualValue);
            }
        }
    }

    @DisplayName("Methods related to last node:")
    @Nested
    class methodsForLastNode {


        @DisplayName("Appending")
        @Nested
        class appendingTests {

            @DisplayName("a null value to a deque throws an exception.")
            @Test
            void appendWithNullValueThrowsException() {
                assertThrows(DoubleEndedQueueException.class, () -> dq.append(null));
            }

            @DisplayName("to a deque adds the item in the last position.")
            @Test
            void appendToDeque() {
                Integer[] values = {1, 2, 3, 4, 5};

                for (Integer value : values) {
                    dq.append(value);
                    assertEquals(value, dq.last());
                }
            }
        }

        @DisplayName("Deleting last node")
        @Nested
        class deletingLastTests {

            @DisplayName("of a empty deque throws exception")
            @Test
            void deleteLastNodeOfEmptyDequeThrowsException() {
                assertThrows(DoubleEndedQueueException.class, () -> dq.deleteLast());
            }

            @DisplayName("of a Deque ")
            @Test
            void deleteLastNodeOfNonEmptyDeque() {
                Integer[] values = {1, 2, 3, 4, 5};

                for (Integer value : values) {
                    dq.append(value);
                }

                for (int i = values.length - 2; i >= 0; i--) {
                    dq.deleteLast();
                    int expectedValue = values[i];
                    int actualValue = dq.last();
                    assertEquals(expectedValue, actualValue);
                }
                dq.deleteLast();
                assertEquals(0, dq.size());
            }
        }

        @DisplayName("Getting last node value")
        @Nested
        class gettingLastNodeValueTests {
            @DisplayName("of a empty deque throws exception")
            @Test
            void lastOfEmptyDequeThrowsException() {
                assertThrows(DoubleEndedQueueException.class, () -> dq.last());
            }

            @DisplayName("of a deque returns last node value")
            @Test
            void lastNodeValue() {
                int expectedValue = 1;
                dq.append(expectedValue);
                int actualValue = dq.last();

                assertEquals(expectedValue, actualValue);
            }
        }
    }

    @Nested
    @DisplayName("Cases for the complex functions")
    class methodsForComplexFunctions{
        @DisplayName("Using get() ")
        @Nested
        class usingGet{
            @DisplayName("throws an error for incorrect index (below 0)")
            @Test
            void incorrectValueInferiorToCeroGet(){
                assertThrows(IndexOutOfBoundsException.class, ()-> dq.get(-1));
            }

            @DisplayName("throws an error for incorrect index (over size)")
            @Test
            void incorrectValueGreaterThanSizeGet(){
                assertThrows(IndexOutOfBoundsException.class, ()-> dq.get(12));
            }

            @DisplayName("returns item for correct index")
            @Test
            void correctValueGet(){
                Integer[] values = {1, 2, 3, 4, 5};

                for (Integer value : values) {
                    dq.append(value);
                }

                assertEquals(2, dq.get(1));
            }
        }
        @DisplayName("Using contains()")
        @Nested
        class usingContains{
            @DisplayName("returns true if the value is contained")
            @Test
            void theValueIsContained(){
                Integer[] values = {1, 2, 3, 4, 5};

                for (Integer value : values) {
                    dq.append(value);
                }
                assertTrue(dq.contains(2));
            }
            @DisplayName("returns false if the value is not contained")
            @Test
            void theValueIsNotContained(){
                Integer[] values = {1, 2, 3, 4, 5};

                for (Integer value : values) {
                    dq.append(value);
                }
                assertFalse(dq.contains(9));
            }
        }
        @DisplayName("Using remove()")
        @Nested
        class usingRemove{
            @DisplayName("makes the selected node dissapear")
            @Test
            void nodeIsDeleted(){
                Integer[] valuesBefore = {1, 2, 3, 4, 5};
                Integer[] valuesAfter = {1, 3, 4, 5};

                for (Integer value : valuesBefore) {
                    dq.append(value);
                }

                dq.remove(2);

                for( Integer value : valuesAfter ){
                    assertEquals(value, dq.first());
                    dq.deleteFirst();
                }

            }
            @DisplayName("The value is not in the list")
            @Test
            void theValueToRemoveIsNotFound(){
                Integer[] valuesBefore = {1, 2, 3, 4, 5};
                Integer[] valuesAfter = {1, 2, 3, 4, 5};

                for (Integer value : valuesBefore) {
                    dq.append(value);
                }

                dq.remove(9);

                for( Integer value : valuesAfter ){
                    assertEquals(value, dq.first());
                    dq.deleteFirst();
                }
            }
        }
        @DisplayName("Sorting ")
        @Nested
        class sortMethod{
            @DisplayName("an empty deque")
            @Test
            void sortEmptyDeque(){
                assertThrows(DoubleEndedQueueException.class, () -> dq.sort(Comparator.naturalOrder()));
            }

            @DisplayName("a one-element deque")
            @Test
            void sortOneElementDeque(){
                dq.append(1);
                assertThrows(DoubleEndedQueueException.class, () -> dq.sort(Comparator.naturalOrder()));
            }

            @DisplayName("an ordinary deque")
            @Test
            void sortDeque(){
                Integer[] inputs = {6, 33, 420, 69, 50};

                for(Integer input : inputs){
                    dq.append(input);
                }

                Arrays.sort(inputs);
                dq.sort(Comparator.reverseOrder());

                int i = 0;
                while(i < dq.size()){
                    Integer expectedValue = inputs[i];
                    Integer actualValue = dq.get(i);
                    assertEquals(expectedValue, actualValue);

                    i++;
                }
            }
        }
    }
}
