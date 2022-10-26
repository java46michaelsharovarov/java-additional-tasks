package msh.util;

import java.util.LinkedList;
import java.util.List;
import java.util.function.ToLongFunction;
import java.util.stream.Collector;
import java.util.stream.Collector.Characteristics;

public class MaxRatedWinnersCollector {
	private MaxRatedWinnersCollector() {} // hidden constructor

	public static <T> Collector<T, ?, RateAccumulator<T>> of(ToLongFunction<T> rater) {
		return Collector.of(
				() -> new RateAccumulator<T>(rater), 
				RateAccumulator::accumulate, 
				RateAccumulator::combine, 
				Characteristics.UNORDERED);
	}
	static class RateAccumulator<T> {
		private ToLongFunction<T> rater;
		private LinkedList<T> currentWinnersList = new LinkedList<>();
		private long currentMax;

		public RateAccumulator(ToLongFunction<T> rater) {
			this.rater = rater;
		}

		public void accumulate(T value) {
			long rate = rater.applyAsLong(value);
			if(currentWinnersList.isEmpty()) {
				currentMax = rate;
			} else {
				if(rate < currentMax) {
					return;
				 } 
				if(rate > currentMax) {
					currentMax = rate;
					currentWinnersList.clear();
				 }				
			}
			currentWinnersList.add(value);
		}
		public RateAccumulator<T> combine(RateAccumulator<T> other) {
			if(this.currentMax == other.currentMax) {
				this.currentWinnersList.addAll(other.currentWinnersList);
			}
			if(this.currentMax < other.currentMax){
				this.currentMax = other.currentMax;
				this.currentWinnersList = other.currentWinnersList;
			}
			return this;
		}
		public List<T> res() {
			return currentWinnersList;			
		}
	}
	
	
}
