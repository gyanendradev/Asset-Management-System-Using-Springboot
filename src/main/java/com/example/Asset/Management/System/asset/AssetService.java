package com.example.Asset.Management.System.asset;

import com.example.Asset.Management.System.assetCategory.AssetCategory;
import com.example.Asset.Management.System.assetCategory.AssetCategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class AssetService {
    private final AssetRepository assetRepository;
    private  final AssetCategoryRepository assetCategoryRepository;

    @Autowired
    public AssetService(AssetRepository assetRepository,AssetCategoryRepository assetCategoryRepository)
    {
        this.assetCategoryRepository=assetCategoryRepository;
        this.assetRepository=assetRepository;
    }
    public List<Asset> getAssets() {
        return assetRepository.findAll();
    }



    public String addNewAsset(Asset asset) {
        boolean exists=assetRepository.existsAssetByName(asset.getName());
        if(exists){
            throw new IllegalStateException("Asset with name "+asset.getName()+" already exists");
        }
        List<AssetCategory> categories=assetCategoryRepository.findAll();
        boolean flag=false;
        for(int i = 0; i<categories.size();i++){
            if(Objects.equals(categories.get(i).getName().toUpperCase(), asset.getCategory().toUpperCase())){
                flag=true;
                break;
            }
        }
        if(!flag){
            return asset.getCategory()+" is not in Asset category so, this asset cannot be added";
        }
        assetRepository.save(asset);
        return asset.getName()+" is added";
    }


    public String deleteAsset(String assetName) {
        boolean exists=assetRepository.existsAssetByName(assetName);
        if(!exists){
            throw new IllegalStateException("Asset wih "+assetName+" does not exists");
        }
        Asset asset=assetRepository.findByName(assetName);
        if(asset.getAssignment().equals("Assigned") || asset.getAssignment().equals("assigned")){
            throw new IllegalStateException(assetName+" is assigned so, It can not be deleted");
        }
        assetRepository.deleteAssetByName(assetName);
        return assetName+" is deleted";
    }


    public String updateAsset(String assetName, LocalDate purchaseDate, String conditionNotes, String category, String assignment) {
        boolean exists=assetRepository.existsAssetByName(assetName);
        if(!exists){
            throw new IllegalStateException("Asset wih "+assetName+" does not exists");
        }
        Asset asset=assetRepository.findByName(assetName);
        if(purchaseDate!=null && !Objects.equals(asset.getPurchaseDate(),purchaseDate)){
            asset.setPurchaseDate(purchaseDate);
        }
        if(conditionNotes!=null && !Objects.equals(asset.getConditionNotes(),conditionNotes)){
            asset.setConditionNotes(conditionNotes);
        }
        if(category!=null && !Objects.equals(asset.getCategory(),category)){
            asset.setCategory(category);
        }
        if(assignment!=null && !Objects.equals(asset.getAssignment(),assignment)){
            asset.setAssignment(assignment);
        }
        return assetName+" is updated";
    }

    public Asset getAsset(String assetName) {
        return assetRepository.getAssetByName(assetName);

    }


    public String assignAssest(String assetName) {
        boolean exists=assetRepository.existsAssetByName(assetName);
        if(!exists){
            throw new IllegalStateException("Asset wih "+assetName+" does not exists");
        }
        Asset asset=assetRepository.findByName(assetName);
        if(asset.getAssignment().equals("Assigned")){
            return assetName+" is already Assigned";
        }
        asset.setAssignment("Assigned");
        return assetName+" is assigned";
    }

    public String recoverAsset(String assetName) {
        boolean exists = assetRepository.existsAssetByName(assetName);
        if (!exists) {
            throw new IllegalStateException("Asset wih " + assetName + " does not exists");
        }
        Asset asset = assetRepository.findByName(assetName);
        if (asset.getAssignment().equals("Available")) {
            return assetName + " is already Available";
        }
        System.out.println(assetName + asset + asset.getAssignment());
        asset.setAssignment("Available");
        System.out.println(assetName + asset + asset.getAssignment());
        return assetName + " is recovered";
    }
}
