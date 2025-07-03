package pdp.uz.learningmanagementsystem.service;

import pdp.uz.learningmanagementsystem.dto.CategoryDto;
import pdp.uz.learningmanagementsystem.utill.ApiResult;

import java.util.List;


public interface CategoryService {

    ApiResult<CategoryDto> addCategory(CategoryDto categoryDto);

    ApiResult<CategoryDto> updateCategory(Integer id, CategoryDto categoryDto);

    ApiResult<Object> deleteCategory(Integer id);

    ApiResult<List<CategoryDto>> getAllCategories();

    ApiResult<CategoryDto> getCategoryById(Integer id);
}
