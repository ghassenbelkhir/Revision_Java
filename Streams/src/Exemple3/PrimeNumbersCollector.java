package Exemple3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class PrimeNumbersCollector implements Collector<Integer,Map<Boolean,List<Integer>>,Map<Boolean,List<Integer>>> {

	@Override
	public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Characteristics> characteristics() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Supplier<Map<Boolean, List<Integer>>> supplier() {
		// TODO Auto-generated method stub
		return () -> new HashMap<Boolean,List<Integer>>()
				{{
					put(true,new ArrayList<Integer>());
					put(false,new ArrayList<Integer>());
					
				}};
	}

}
