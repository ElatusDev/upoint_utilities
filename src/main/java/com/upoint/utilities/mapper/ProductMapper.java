package com.upoint.utilities.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

import com.upoint.model.product.Product;
import com.upoint.model.product.Property;
import com.upoint.dto.product.ProductDto;
import com.upoint.model.product.Category;

@Component("productMapper")
public class ProductMapper implements Mapper<ProductDto, Product> {
	
	
	/**
	 * creates new Product object and executes getter methods from parameter and setters from Product.
	 * it will create any necessary objects for initialization.
	 * @param ProductDto
	 * @return Product instance
	 */
	
	@Override
	public Product mapFrom(ProductDto dto) {
		Product product = new Product();
		product.setName(dto.getProductName());
		product.setCode(dto.getProductCode());
		product.setDescription(dto.getProductDescription());
		Category category = new Category();
		category.setId(dto.getCategoryId());
		product.setCategory(category);
		product.setCompanyId(dto.getCompanyId());
		product.setProperties(getProperties(dto.getPropertyIds()));
		
		return product;
	}
	
	

	private List<Property> getProperties(List<Integer> propertyIds){
		if (propertyIds != null) {
			List<Property> properties = new ArrayList<>();
			for(Integer id: propertyIds) {
				Property property = new Property();
				property.setId(id);
				properties.add(property);
			}
			
			return properties;
		} else {
			return null;
		}
		
		
	}
	
	@Override
	public ProductDto mapTo(Product product) {
		ProductDto productDto = new ProductDto();
		productDto.setProductId(product.getId());
		productDto.setProductName(product.getName());
		productDto.setProductCode(product.getCode());
		productDto.setProductDescription(product.getDescription());
		productDto.setCategoryId(product.getCategory().getId());
		productDto.setCompanyId(product.getCompanyId());
		productDto.setPropertyIds(getPropertyIds(product.getProperties()));
		
		return productDto;
			
		
		
	}
	
	private List<Integer> getPropertyIds(List<Property> list) {
		if(list != null) {
			List<Integer> ids = new ArrayList<>();
			for(Property property: list) {
				ids.add(property.getId());	
			}
			return ids;
			
		}else {
			return null;
		}
		
	}
	
	
	
}
