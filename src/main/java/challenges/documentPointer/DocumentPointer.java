package challenges.documentPointer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *  Note: 1. document doesn't have info of the text.
 *        2. only the pointer has the idea of the text
 *        3. once the pointer is at end of a document, if a document next to it exists, pointer can advance or proceed
 *        4. if you proceed and there is no next occurrence of the text, the pointer will reach the end+1 and thus at an invalid location
 *
 * Example
 *              Document 1       Document 2       Document 3
 *   docId  123  123  123   234  234   234   234  234  234
 *   pos    1      2   3    1    2     3       1    2    3
 *
 *   text   Apple  is  a    good apple and     is apple  good
 *
 *   PointerImpl pimpl = new PointerImpl("Apple")  => Initializes pointer to search for apple
 *   pimpl.isValid() => returns true as pointer will be at apple in doc1d:123 at position 1
 *   pimpl.advance() => lands it on next position at docId:123 and at "is" text
 *   pimpl.proceed() => lands it on next apple in docId: 234 position 2
 *   pimple.seek(new Document(234, 3)) => will advance it to documentId: 234 position 3
 */
public class DocumentPointer {
    class Document {
        int documentId;
        int position;
    }

    interface Pointer {
        int get(); // gets the position of the document
        void proceed(); // goes to next occurrence of the word with which the pointer is initialized
        void seek(Document doc); // goes to the specified document
        boolean isValid(); // returns true if the pointer is at a valid location
        void advance(); // pointer advances by 1
    }

    static class PointerImpl implements Pointer {
        String text;
        PointerImpl (String text) { this.text = text; }
        @Override
        public int get() { return 0; }
        @Override
        public void proceed() { }
        @Override
        public void seek(Document doc) { }
        @Override
        public boolean isValid() { return false; }
        @Override
        public void advance(){ }
    }

    // Challenge 1: Given a string, get all distinct doc Ids the string is a part of
    public static List<Integer> getDistinctDocIds(String text) {
        List<Integer> res = new ArrayList<>();
        PointerImpl pointer = new PointerImpl(text);
        // TODO: Solve
        return res;
    }


    // Challenge 2
    // Given two strings bugs bunny return all doc Ids where this is the case
    // Case 1: some thing bugs bunny some thing
    // Case 2: some bugs thing bunny thing
    // Case 3: bunny some bugs thing bugs bunny
    public static void getDistinctDocIdsFor2AdjString(String text1, String text2) {

    }

}
