//import java.util.*;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.bson.Document;
//
//public class DocSorter {
//
//    public static Document sortDocument(Document document, String propertyCode) {
//        if (document == null) return null;
//
//        try {
//            // TreeMap gives you key-sorted (lexicographic) ordering
//            Map<String, Object> sortedMap = new TreeMap<>();
//            for (Map.Entry<String, Object> entry : document.entrySet()) {
//                String key = entry.getKey();
//                Object value = entry.getValue();
//
//                if (value != null && !(value instanceof String)) {
//                    if (value instanceof Document) {
//                        value = sortDocument((Document) value, propertyCode);
//                    } else if (value instanceof List<?>) {
//                        value = sortListOfElements((List<?>) value, propertyCode);
//                    }
//                }
//
//                if (value != null) {
//                    sortedMap.put(key, value);
//                }
//            }
//            return new Document(sortedMap);
//        } catch (Exception ex) {
//            // log if you have a logger; falling back to original
//            return document;
//        }
//    }
//
//    /**
//     * Sort a collection of elements.
//     * - Documents are recursively sorted and stored as JSON strings for stable comparison.
//     * - Non-String, non-Document objects are converted to Document (via Jackson) then to JSON.
//     * - Strings are kept as-is.
//     * Result is a TreeSet<String> to ensure deterministic order.
//     */
//    public static SortedSet<String> sortListOfElements(List<?> listOfElements, String propertyCode) {
//        SortedSet<String> sortedElements = new TreeSet<>();
//        if (listOfElements == null) return sortedElements;
//
//        try {
//            ObjectMapper docMapper = new ObjectMapper();
//
//            for (Object attribute : listOfElements) {
//                if (attribute == null) continue;
//
//                if (attribute instanceof String) {
//                    sortedElements.add((String) attribute);
//                } else if (attribute instanceof Document) {
//                    Document sortedDoc = sortDocument((Document) attribute, propertyCode);
//                    sortedElements.add(sortedDoc.toJson());
//                } else {
//                    // Convert arbitrary POJO/Map to Document → sort → JSON
//                    Document converted = docMapper.convertValue(attribute, Document.class);
//                    Document sortedDoc = sortDocument(converted, propertyCode);
//                    sortedElements.add(sortedDoc.toJson());
//                }
//            }
//            return sortedElements;
//        } catch (IllegalArgumentException ex) {
//            // If conversion fails, return what we accumulated so far
//            return sortedElements;
//        }
//    }
//}
