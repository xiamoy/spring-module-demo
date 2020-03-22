package com.example.spring2.config;

import com.example.spring2.external.SelectorModel;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class ModelImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{SelectorModel.class.getName()};
    }
}
