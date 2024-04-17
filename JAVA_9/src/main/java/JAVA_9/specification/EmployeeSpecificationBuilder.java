package JAVA_9.specification;

import JAVA_9.entity.Employees;
import JAVA_9.utils.filter.SearchOperation;
import JAVA_9.utils.filter.SpecSearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class EmployeeSpecificationBuilder {
    private final List<SpecSearchCriteria> params;
    public EmployeeSpecificationBuilder() {
        params = new ArrayList<>();
    }

//    public final EmployeeSpecificationBuilder with(String key, String operation, Object value) {
//        return with(key, operation, value);
//    }

    public final EmployeeSpecificationBuilder with(String key, String operation, Object value,
                                                   String prefix, String suffix) {
        return with(null, key, operation, value, prefix, suffix);
    }

    public final EmployeeSpecificationBuilder with(String orPredicate, String key, String operation,
                                                   Object value, String prefix, String suffix) {
        SearchOperation op = SearchOperation.getSimpleOperation(operation.charAt(0));
        if (op != null) {
            if (op == SearchOperation.EQUALITY) { // the operation may be complex operation
                boolean startWithAsterisk = prefix != null &&
                prefix.contains(SearchOperation.ZERO_OR_MORE_REGEX);
                boolean endWithAsterisk = suffix != null &&
                        suffix.contains(SearchOperation.ZERO_OR_MORE_REGEX);

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

    public Specification<Employees> build(){
        if (params.size() == 0)
            return null;

        Specification<Employees> result = new EmployeeSpecification(params.get(0));

        for (int i = 1; i < params.size(); i++) {
            result = params.get(i).isOrPredicate()
                    ? Specification.where(result).or(new EmployeeSpecification(params.get(i)))
                    : Specification.where(result).and(new EmployeeSpecification(params.get(i)));
        }

        return result;
    }

    public final EmployeeSpecificationBuilder with(EmployeeSpecification spec) {
        params.add(spec.getCriteria());
        return this;
    }

    public final EmployeeSpecificationBuilder with(SpecSearchCriteria criteria) {
        params.add(criteria);
        return this;
    }


}
