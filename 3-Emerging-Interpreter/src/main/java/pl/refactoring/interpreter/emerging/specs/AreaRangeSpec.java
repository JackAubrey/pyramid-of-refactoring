package pl.refactoring.interpreter.emerging.specs;

import pl.refactoring.interpreter.emerging.RealEstate;
import pl.refactoring.interpreter.emerging.Spec;

public class AreaRangeSpec implements Spec {
    private final float min;
    private final float max;

    public AreaRangeSpec(float min, float max) {
        this.min = min;
        this.max = max;
    }

     public boolean isSatisfiedBy(RealEstate estate) {
        return estate.getBuildingArea() >= min && estate.getBuildingArea() <= max;
    }
}