package com.example.isabelmelo.todolist.utils;

import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.data.mapping.model.Property;

import java.beans.PropertyDescriptor;
import java.util.HashSet;

public class utils {

    public static  void copyNonNullProperties(Object source, Object target){
        BeanUtils.copyProperties(source, target, getNullPropertyNames(source));

    }

public static  String[] getNullPropertyNames(Object source) {
    final BeanWrapper src = new BeanWrapperImpl(source);

  PropertyDescriptor[]pds = src.getPropertyDescriptors();
  HashSet<Object> emptyNames = new HashSet<>();
    for(PropertyDescriptor pd: pds){
    Object scrValue = src.getPropertyValue(pd.getName());
    if(scrValue == null) {
        emptyNames.add(pd.getName());
    }
    }

    String[] result = new String[emptyNames.size()];
    return  emptyNames.toArray(result);
}
}
