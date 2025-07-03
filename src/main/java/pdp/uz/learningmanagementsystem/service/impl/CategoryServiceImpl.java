package pdp.uz.learningmanagementsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pdp.uz.learningmanagementsystem.dto.CategoryDto;
import pdp.uz.learningmanagementsystem.entity.Category;
import pdp.uz.learningmanagementsystem.mapper.CategoryMapper;
import pdp.uz.learningmanagementsystem.repository.CategoryRepository;
import pdp.uz.learningmanagementsystem.service.CategoryService;
import pdp.uz.learningmanagementsystem.utill.ApiResult;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;


    @Override
    @Transactional
    public ApiResult<CategoryDto> addCategory(CategoryDto categoryDto) {
        Category category = categoryMapper.categoryDtoTOcategory(categoryDto);
        categoryRepository.save(category);
        return ApiResult.success(categoryMapper.categoryTOcategoryDto(category));
    }

    @Override
    @Transactional
    public ApiResult<CategoryDto> updateCategory(Integer id, CategoryDto categoryDto) {

        return categoryRepository.findById(id)
                .map(existingCategory -> {
                    categoryMapper.updateCategoryFromDto(categoryDto, existingCategory);
                    categoryRepository.save(existingCategory);
                    return ApiResult.success(
                            "Category updated successfully",
                            categoryMapper.categoryTOcategoryDto(existingCategory));
                })
                .orElse(ApiResult.error("Category not found with id: " + id));
    }

    @Override
    public ApiResult<Object> deleteCategory(Integer id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            categoryRepository.deleteById(id);
            return ApiResult.success("Category deleted successfully");
        }
        return ApiResult.error("Category not found with id: " + id);

    }

    @Override
    public ApiResult<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> categories = categoryRepository.findAll()
                .stream()
                .map(categoryMapper::categoryTOcategoryDto)
                .toList();
        return ApiResult.success(categories);
    }

    @Override
    public ApiResult<CategoryDto> getCategoryById(Integer id) {
        Optional<Category> byId = categoryRepository.findById(id);
        return byId
                .map(category -> ApiResult.success(categoryMapper.categoryTOcategoryDto(category)))
                .orElseGet(() -> ApiResult.error("Category not found with id: " + id));
    }
}
