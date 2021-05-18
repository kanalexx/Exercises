package com.kanaa.exbase.dataobject;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataObjectParser {
    private DataObject dataObject;
    public String dataObjectName;
    /** Имя поля - строковое преставление поля */
    public Map<String, String> fields;

    public DataObjectParser(DataObject dataObject) {
        this.dataObject = dataObject;
        Class<? extends DataObject> aClass = dataObject.getClass();
        Annotation[] annotations = aClass.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof Data) {
                dataObjectName = ((Data) annotation).name();
            }
        }
        assert dataObjectName == null || dataObjectName.isEmpty();

        Field[] aClassFields = aClass.getFields();
        fields = new HashMap<>(aClassFields.length);
        try {
            for (Field field : aClassFields) {
                com.kanaa.exbase.dataobject.Field fieldAnnotation = field.getAnnotation(com.kanaa.exbase.dataobject.Field.class);
                if (fieldAnnotation != null) {
                    String fieldName = fieldAnnotation.name();
                    String fieldValue;
                    switch (fieldAnnotation.type()) {
                        case STRING:
                            fieldValue = field.get(dataObject).toString();
                            break;
                        case LONG:
                            fieldValue = String.valueOf(field.getLong(dataObject));
                            break;
                        default:
                            fieldValue = "";
                    }
                    fields.put(fieldName, fieldValue);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
