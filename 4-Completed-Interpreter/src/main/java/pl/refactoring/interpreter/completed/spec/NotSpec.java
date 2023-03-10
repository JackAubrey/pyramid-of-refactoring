/**
 * Copyright (c) 2020 IT Train Wlodzimierz Krakowski (www.refactoring.pl)
 * Sources are available only for personal usage by Udemy students of this course.
 */
package pl.refactoring.interpreter.completed.spec;

import pl.refactoring.interpreter.completed.RealEstate;
import pl.refactoring.interpreter.completed.Spec;

final class NotSpec implements Spec {
    private final Spec spec;

    NotSpec(Spec spec) {
        this.spec = spec;
    }

    public boolean isSatisfiedBy(RealEstate estate) {
        return ! spec.isSatisfiedBy(estate);
    }
}
