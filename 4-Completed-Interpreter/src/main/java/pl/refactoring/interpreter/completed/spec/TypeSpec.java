/**
 * Copyright (c) 2020 IT Train Wlodzimierz Krakowski (www.refactoring.pl)
 * Sources are available only for personal usage by Udemy students of this course.
 */
package pl.refactoring.interpreter.completed.spec;

import pl.refactoring.interpreter.completed.EstateType;
import pl.refactoring.interpreter.completed.RealEstate;
import pl.refactoring.interpreter.completed.Spec;

final class TypeSpec implements Spec {
    private final EstateType type;

    TypeSpec(EstateType type) {
        this.type = type;
    }

    public boolean isSatisfiedBy(RealEstate estate) {
        return estate.getType().equals(type);
    }
}
