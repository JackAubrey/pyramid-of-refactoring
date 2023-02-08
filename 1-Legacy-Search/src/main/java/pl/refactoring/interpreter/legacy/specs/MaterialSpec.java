package pl.refactoring.interpreter.legacy.specs;

import pl.refactoring.interpreter.legacy.EstateMaterial;
import pl.refactoring.interpreter.legacy.RealEstate;
import pl.refactoring.interpreter.legacy.Spec;

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