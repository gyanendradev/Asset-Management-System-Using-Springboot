package com.example.Asset.Management.System.assetCategory;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AssetCategoryService {
    private AssetCategoryRepository assetCategoryRepository;
    @Autowired
    public AssetCategoryService(AssetCategoryRepository assetCategoryRepository){
        this.assetCategoryRepository=assetCategoryRepository;
    }
    public List<AssetCategory> getCategories() {
        return assetCategoryRepository.findAll();
    }

    public String addNewAssetCategory(AssetCategory assetCategory) {
        boolean exists=assetCategoryRepository.existsAssetCategoryByName(assetCategory.getName());
        if(exists ){
            throw new IllegalStateException("Asset with "+assetCategory.getName()+" already exists");
        }
        if(assetCategory.getName().isEmpty()){
            throw new IllegalStateException("Asset without name can not exists");
        }
        assetCategoryRepository.save(assetCategory);
        return assetCategory.getName()+" is added";
    }

    @Transactional
    public String deleteAssetcategory(String assetCategoryName) {
        boolean exists=assetCategoryRepository.existsAssetCategoryByName(assetCategoryName);
        if(!exists){
            throw new IllegalStateException("Asset with "+assetCategoryName+" does not exists");
        }
        assetCategoryRepository.deleteAssetCategoryByName(assetCategoryName);
        return assetCategoryName+" has been deleted";
    }

    @Transactional
    public String updateAssetCategory(Integer assetCategoryId, String assetCategoryName, String description) {
        AssetCategory assetCategory=assetCategoryRepository.findById(assetCategoryId)
                .orElseThrow(()->new IllegalStateException(
                        "student with id"+assetCategoryId+"does not exists"
                ));
        if(assetCategoryName!=null && !assetCategoryName.isEmpty() && !Objects.equals(assetCategory.getName(),assetCategoryName)){
            assetCategory.setName(assetCategoryName);
        }
        if(description!=null && !description.isEmpty() && !Objects.equals(assetCategory.getDescription(),description)){
            assetCategory.setDescription(description);
        }
        return assetCategoryId+" is updated";
    }
}
