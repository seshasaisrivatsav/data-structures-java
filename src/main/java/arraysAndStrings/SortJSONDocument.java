public static Document sortDocument(Document document, String propertyCode) {
        try {
            TreeMap<String, Object> sortedMap = new TreeMap<>();
            for (Map.Entry<String, Object> entry : document.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (key.equalsIgnoreCase("_class")) {
                    continue;
                }
                if (!(value instanceof String)) {
                    if (value instanceof Document) {
                      
                        value = sortDocument((Document) value, propertyCode);
                    } else if (value instanceof ArrayList<?>) {
                        value = sortListOfElements((ArrayList<?>) value, propertyCode);
                    }
                }

                if (value != null) sortedMap.put(key, value);
            }

            // Create a new Document from the sortedMap
            return new Document(sortedMap);
        } catch (Exception ex) {
            log.error("Exception occurred while sorting document: {}", ex.getMessage());
        }
        return document;
    }

    /**
     * Method to sort the collection of documents, custom  objects
     *
     * @param listOfElements list of elements to sort
     * @param propertyCode   property code of the document
     * @return Returns sorted list of elements
     */
    public static TreeSet<Object> sortListOfElements(ArrayList<?> listOfElements, String propertyCode) {
        try {
            TreeSet<Object> sortedElements = new TreeSet<>();
            for (Object attribute : listOfElements) {
                if (!(attribute instanceof String)) {
                    if (attribute instanceof Document) {
                        attribute = sortDocument((Document) attribute, propertyCode).toJson();
                    } else {
                        ObjectMapper docMapper = new ObjectMapper();
                        attribute = sortDocument((Document) docMapper.convertValue(attribute, Document.class), propertyCode).toJson();
                    }
                }
                if (attribute != null) {
                    sortedElements.add(attribute);
                }
            }
            return sortedElements;
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException(("Exception occurred while sorting list of elements {}"), ex);
        }

    }
