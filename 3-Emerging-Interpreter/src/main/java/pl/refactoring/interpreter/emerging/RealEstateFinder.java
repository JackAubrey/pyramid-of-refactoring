/**
 * Copyright (c) 2020 IT Train Wlodzimierz Krakowski (www.refactoring.pl)
 * Sources are available only for personal usage by Udemy students of this course.
 */
package pl.refactoring.interpreter.emerging;

import pl.refactoring.interpreter.emerging.specs.*;

import java.util.List;
import java.util.stream.Collectors;

public class RealEstateFinder {
    private List<RealEstate> repository;

    /**
     *
     * @param repository
     */
    public RealEstateFinder(List<RealEstate> repository) {
        this.repository = repository;
    }

    /**
     *
     * @param spec
     * @return
     */
    public List<RealEstate> bySpec(Spec spec) {
        return repository.stream()
                .filter(spec::isSatisfiedBy)
                .collect(Collectors.toList());
    }

    /**
     *
     * @param maxBuildingArea
     * @return
     */
    public List<RealEstate> byBelowArea(float maxBuildingArea){
        return bySpec(new BelowAreaSpec(maxBuildingArea));
    }

    /**
     *
     * @param material
     * @return
     */
    public List<RealEstate> byMaterial(EstateMaterial material){
        return bySpec(new MaterialSpec(material));

    }

    /**
     * 
     * @param material
     * @param maxBuildingArea
     * @return
     */
    public List<RealEstate> byMaterialBelowArea(EstateMaterial material, float maxBuildingArea){
        return bySpec(new AndSpec(new MaterialSpec(material), new BelowAreaSpec(maxBuildingArea)));
    }

    /**
     *
     * @param placement
     * @return
     */
    public List<RealEstate> byPlacement(EstatePlacement placement){
        return bySpec(new PlacementSpec(placement));
    }

    /**
     *
     * @param placement
     * @return
     */
    public List<RealEstate> byAvoidingPlacement(EstatePlacement placement){
        return bySpec(new NotSpec(new PlacementSpec(placement)));
    }

    /**
     *
     * @param minArea
     * @param maxArea
     * @return
     */
    public List<RealEstate> byAreaRange(float minArea, float maxArea){
        return bySpec(new AreaRangeSpec(minArea, maxArea));
    }

    /**
     *
     * @param type
     * @return
     */
    public List<RealEstate> byType(EstateType type){
        return bySpec(new TypeSpec(type));
    }

    /**
     *
     * @param type
     * @param placement
     * @param material
     * @return
     */
    public List<RealEstate> byTypePlacementMaterial(EstateType type, EstatePlacement placement, EstateMaterial material){
        TypeSpec typeSpec = new TypeSpec(type);
        PlacementSpec placementSpec = new PlacementSpec(placement);
        MaterialSpec materialSpec = new MaterialSpec(material);

        return bySpec(new AndSpec(typeSpec, placementSpec, materialSpec));
    }

}
