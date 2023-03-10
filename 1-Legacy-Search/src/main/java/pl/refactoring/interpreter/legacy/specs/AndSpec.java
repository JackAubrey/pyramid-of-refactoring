package pl.refactoring.interpreter.legacy.specs;

import pl.refactoring.interpreter.legacy.RealEstate;
import pl.refactoring.interpreter.legacy.Spec;

public class AndSpec implements Spec {
    private final Spec firstSpec;
    private final Spec secondSpec;

    public AndSpec(Spec firstSpec, Spec secondSpec) {
        this.firstSpec = firstSpec;
        this.secondSpec = secondSpec;
    }

    @Override
    public boolean isSatisfiedBy(RealEstate estate) {
        return firstSpec.isSatisfiedBy(estate) && secondSpec.isSatisfiedBy(estate);
    }
}
