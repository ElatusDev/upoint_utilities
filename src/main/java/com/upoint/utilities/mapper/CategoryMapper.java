package com.upoint.utilities.mapper;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

import com.upoint.dto.category.CategoryDto;
import com.upoint.model.product.Category;

@Component("categoryMapper")
public class CategoryMapper implements Mapper<CategoryDto, Category> {
	

	@Override
	public Category mapFrom(CategoryDto dto) {
		
		Category category = new Category();
		category.setName(dto.getCategoryName());
		category.setId(dto.getCategoryId());
		category.setDescription(dto.getCategoryDescription());
		category.setChildren(getChildren(dto.getChildren()));
		return category;
	}
	
	private List<Category> getChildren(List<CategoryDto> children){
		if(children != null) {
			List<Category> list = new ArrayList<>();
			for(CategoryDto dto: children) {
				Category category = new Category();
				category = mapFrom(dto);
				list.add(category);
				
				}
			return  list;
		} else {
			return null;
		}
	}
	
	@Override
	public CategoryDto mapTo(Category entity) {
		
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setCategoryName(entity.getName());
		categoryDto.setCategoryId(entity.getId());
		categoryDto.setCategoryDescription(entity.getDescription());
		categoryDto.setChildren(getList(entity.getChildren()));
		
		return categoryDto;
	}
	
	private List<CategoryDto> getList(List<Category> list){
		if(list != null) {
		List<CategoryDto> dtos = new ArrayList<>();
		for(Category entity: list) {
			CategoryDto categoryDto = new CategoryDto();
			categoryDto = mapTo(entity);
			dtos.add(categoryDto);
			}
		return dtos;
		} else {
			return null;
		}
	
		
	}

}
