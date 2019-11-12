package org.improving.tag.DataBase;

import javafx.css.converter.InsetsConverter;
import org.improving.tag.Adversary;
import org.improving.tag.items.Item;
import org.improving.tag.items.UniqueItems;
import org.springframework.util.StringUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

@Converter(autoApply = true)
public class UniqueItemsConverter implements AttributeConverter<UniqueItems, String> {

    @Override
    public String convertToDatabaseColumn(UniqueItems item) {
        return item.getName();
    }

    @Override
    public UniqueItems convertToEntityAttribute(String item) {
                    return (Arrays
                    .stream(UniqueItems.values())
                    .filter(uniqueItems -> uniqueItems.getName().equals(item))
                    .findFirst()
                    .orElse(null));

    }
}
