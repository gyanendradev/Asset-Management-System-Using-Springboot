package com.example.Asset.Management.System.assetCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/category") public class AssetCategoryController {
    private AssetCategoryService assetCategoryService;
    @Autowired
    public AssetCategoryController(AssetCategoryService assetCategoryService){
        this.assetCategoryService=assetCategoryService;
    }
    @GetMapping
    public List<AssetCategory> getCategories(){
        return assetCategoryService.getCategories();
    }


    @PostMapping
    public String addNewAssetCategory(AssetCategory assetCategory){
        return assetCategoryService.addNewAssetCategory(assetCategory);
    }


    @DeleteMapping(path = "{assetCategoryName}")
    public String deleteAssetcategory(@PathVariable("assetCategoryName") String assetCategoryName){
        return assetCategoryService.deleteAssetcategory(assetCategoryName);
    }


    @PutMapping(path = "{assetCategoryId}")
    public String updateAssetCategory(
            @PathVariable("assetCategoryId") Integer assetCategoryId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description
    ){
        return assetCategoryService.updateAssetCategory(assetCategoryId,name,description);
    }
}
