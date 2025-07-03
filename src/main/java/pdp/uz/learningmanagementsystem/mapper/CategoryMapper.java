package pdp.uz.learningmanagementsystem.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import pdp.uz.learningmanagementsystem.dto.CategoryDto;
import pdp.uz.learningmanagementsystem.entity.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category categoryDtoTOcategory(CategoryDto categoryDto);
    CategoryDto categoryTOcategoryDto(Category category);

    void updateCategoryFromDto(CategoryDto categoryDto, @MappingTarget Category existingCategory);
}
