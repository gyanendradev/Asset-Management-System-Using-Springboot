package com.example.Asset.Management.System.asset;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository public interface AssetRepository extends JpaRepository<Asset,String> {
    void deleteAssetByName(String assetName);

    boolean existsAssetByName(String assetName);

    Asset findByName(String assetName);
    Asset getAssetByName(String asset);


}
