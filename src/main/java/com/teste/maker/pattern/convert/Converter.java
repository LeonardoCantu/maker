package com.teste.maker.pattern.convert;

import com.fasterxml.jackson.annotation.JsonAlias;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.json.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public abstract class Converter<E> implements Serializable {

    public E convertJsonToEntity(JSONObject json) {
        try {
            Class<E> c = (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];

            List<Field> fields = new ArrayList<>(Arrays.asList(c.getDeclaredFields()));

            HashMap<String, Object> mapPopulate = new HashMap<>();

            json.keys().forEachRemaining(key -> {
                Field fieldMap = fields.stream().filter(field -> key.trim().equals(field.isAnnotationPresent(JsonAlias.class)
                                ? field.getAnnotation(JsonAlias.class).value()[0].trim()
                                : field.getName().trim()))
                        .findFirst()
                        .orElse(null);

                if (fieldMap != null) {
                    mapPopulate.put(fieldMap.getName(), json.get(key));
                }
            });

            Object newObject = c.newInstance();
            BeanUtilsBean.getInstance().populate(newObject, mapPopulate);
            return (E) newObject;

        } catch (Exception e) {
            throw new RuntimeException("Não foi possivel converter a Json para uma entidade.");
        }
    }

}
