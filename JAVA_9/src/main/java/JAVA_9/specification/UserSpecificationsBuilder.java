package JAVA_9.specification;

import JAVA_9.entity.Employees;
import JAVA_9.utils.filter.SearchOperation;
import JAVA_9.utils.filter.SpecSearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public final class UserSpecificationsBuilder {

    private final List<SpecSearchCriteria> params;

    public UserSpecificationsBuilder() {
        params = new ArrayList<>();
    }


    public final UserSpecificationsBuilder with(final String key, final String operation, final Object value, final String prefix, final String suffix) {
        return with(null, key, operation, value, prefix, suffix);
    }

    public final UserSpecificationsBuilder with(final String orPredicate, final String key, final String operation, final Object value, final String prefix, final String suffix) {
        SearchOperation op = SearchOperation.getSimpleOperation(operation.charAt(0));
        if (op != null) {
            if (op == SearchOperation.EQUALITY) { // the operation may be complex operation
                final boolean startWithAsterisk = prefix != null && prefix.contains(SearchOperation.ZERO_OR_MORE_REGEX);
                final boolean endWithAsterisk = suffix != null && suffix.contains(SearchOperation.ZERO_OR_MORE_REGEX);

                if (startWithAsterisk && endWithAsterisk) {
                    op = SearchOperation.CONTAINS;
                } else if (startWithAsterisk) {
                    op = SearchOperation.ENDS_WITH;
                } else if (endWithAsterisk) {
                    op = SearchOperation.STARTS_WITH;
                }
            }
            params.add(new SpecSearchCriteria(orPredicate, key, op, value));
        }
        return this;
    }

    public Specification<Employees> build() {

        if (params.size() == 0)
            return null;

        Specification<Employees> result = new UserSpecification(params.get(0));

        for (int i = 1; i < params.size(); i++) {
            result = params.get(i)
                    .isOrPredicate()
                    ? Specification.where(result)
                    .or(new UserSpecification(params.get(i)))
                    : Specification.where(result)
                    .and(new UserSpecification(params.get(i)));

        }

        return result;
    }

    public final UserSpecificationsBuilder with(UserSpecification spec) {
        params.add(spec.getCriteria());
        return this;
    }

    public final UserSpecificationsBuilder with(SpecSearchCriteria criteria) {
        params.add(criteria);
        return this;
    }

}