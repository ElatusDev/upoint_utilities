package com.upoint.utilities.mapper;

import org.springframework.stereotype.Component;

import com.upoint.dto.property.PropertyDto;
import com.upoint.model.product.Property;



@Component("propertyMapper")
public class PropertyMapper implements Mapper<PropertyDto, Property> {
	
	public Property mapFrom(PropertyDto dto) {
		Property property = new Property();
		property.setName(dto.getPropertyName());
		property.setAvailableUnits(dto.getPropertyAvailableUnits());
		property.setUnit(dto.getPropertyUnit());
		property.setValueType(dto.getPropertyValueType());
		return property;
	}
	public PropertyDto mapTo(Property entity) {
		PropertyDto propertyDto = new PropertyDto();
		propertyDto.setPropertyName(entity.getName());
		propertyDto.setPropertyAvailableUnits(entity.getAvailableUnits());
		propertyDto.setPropertyUnit(entity.getUnit());
		propertyDto.setPropertyValueType(entity.getValueType());
		return propertyDto;
	}
	

	
}
