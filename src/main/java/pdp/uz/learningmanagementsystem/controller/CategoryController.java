package pdp.uz.learningmanagementsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdp.uz.learningmanagementsystem.dto.CategoryDto;
import pdp.uz.learningmanagementsystem.service.impl.CategoryServiceImpl;
import pdp.uz.learningmanagementsystem.utill.ApiResult;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryServiceImpl categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        ApiResult<List<CategoryDto>> allCategories = categoryService.getAllCategories();
        return ResponseEntity.ok(allCategories.getData());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer id){
        ApiResult<CategoryDto> categoryById = categoryService.getCategoryById(id);
        return ResponseEntity.ok(categoryById.getData());
    }
    @PostMapping("/add")
    public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto categoryDto){
        ApiResult<CategoryDto> categoryDtoResult = categoryService.addCategory(categoryDto);
        return ResponseEntity.ok(categoryDtoResult.getData());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable Integer id,@RequestBody CategoryDto categoryDto){
        ApiResult<CategoryDto> categoryDtoApiResult = categoryService.updateCategory(id, categoryDto);
        return ResponseEntity.ok(categoryDtoApiResult.getData());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResult<Object>> deleteCategory(@PathVariable Integer id){
        ApiResult<Object> objectApiResult = categoryService.deleteCategory(id);
        return ResponseEntity.ok(objectApiResult);

    }

}
