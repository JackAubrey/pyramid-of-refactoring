package pl.refactoring.interpreter.basement.specs;

import pl.refactoring.interpreter.basement.EstateMaterial;
import pl.refactoring.interpreter.basement.RealEstate;
import pl.refactoring.interpreter.basement.Spec;

public class MaterialSpec implements Spec {
    private final EstateMaterial material;

    public MaterialSpec(EstateMaterial material) {
        this.material = material;
    }

    @Override
    public boolean isSatisfiedBy(RealEstate estate) {
        return estate.getMaterial().equals(material);
    }
}