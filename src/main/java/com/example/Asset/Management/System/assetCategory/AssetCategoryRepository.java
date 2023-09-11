package com.example.Asset.Management.System.assetCategory;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssetCategoryRepository extends
        JpaRepository<AssetCategory,Integer> {
    Optional<AssetCategory> findAssetCategoryByName(String name);

    boolean existsAssetCategoryByName(String name);

    void deleteAssetCategoryByName(String name);
}
