package pairmatching.domain.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Pair {

    private final String name;
    private final String otherName;

    public Pair(String name, String otherName) {
        this.name = name;
        this.otherName = otherName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;

        Set<String> set = new HashSet<>(Arrays.asList(name, otherName));
        set.addAll(Arrays.asList(pair.name, pair.otherName));
        return (set.size() == 2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, otherName) + Objects.hash(otherName, name);
    }
}
