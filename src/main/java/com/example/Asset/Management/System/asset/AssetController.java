package com.example.Asset.Management.System.asset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/asset")
public class AssetController {
    private final AssetService assetService;

    @Autowired
    public AssetController(AssetService assetService){
        this.assetService=assetService;
    }

    @GetMapping
    public List<Asset> getAssets(){
        return assetService.getAssets();
    }

    @GetMapping(path = "{assetName}")
    public Asset getAsset(@PathVariable("assetName") String assetName){
        return assetService.getAsset(assetName);
    }

    @DeleteMapping(path = "{assetName}")
    public String deleteAsset(@PathVariable("assetName") String assetName){
        return assetService.deleteAsset(assetName);
    }
    @PostMapping
    public String addNewAsset(Asset asset){
        return assetService.addNewAsset(asset);
    }

    @PutMapping(path = "{assetName}")
    public String updateAssetCategory(
            @PathVariable("assetName") String assetName,
            @RequestParam(required = false) LocalDate purchaseDate,
            @RequestParam(required = false) String conditionNotes,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String assignment
    ){
        return assetService.updateAsset(assetName,purchaseDate,conditionNotes,category,assignment);
    }
    @PutMapping(path = "/assign/{assetName}")
    public String assignAsset(@PathVariable("assetName") String assetName){
        return assetService.assignAssest(assetName);
    }
    @PutMapping(path = "/recover/{assetName}")
    public String recoverAsset(@PathVariable("assetName") String assetName){
        return assetService.recoverAsset(assetName);
    }
}
