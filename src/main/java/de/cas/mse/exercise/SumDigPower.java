package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Take a Number And Sum Its Digits Raised To The Consecutive Powers
 * The number 89 is the first integer with more than one digit that fulfills the property partially introduced in the title of this kata. What's the use of saying "Eureka"? Because this sum gives the same number.
 * In effect: 89 = 8^1 + 9^2
 * The next number in having this property is 135.
 * See this property again: 135 = 1^1 + 3^2 + 5^3
 */
public class SumDigPower {

	public List<Long> evaluateInRange(long start, long end) {
		List<Long> sumDigPowerNumbers = new ArrayList<Long>();

		for (long candidate = start; candidate < end; candidate++) {
			List<Long> bases = extractBases(candidate);

			long sum = calculateSum(bases);

			if (sum == candidate) {
				sumDigPowerNumbers.add(sum);
			}
		}

        System.out.println(sumDigPowerNumbers);
		return sumDigPowerNumbers;
	}

	private long calculateSum(List<Long> bases) {
		long sum = 0;
		for (int i = 1; i <= bases.size(); i++) {
			sum += Math.pow(bases.get(i - 1), i);
		}
		return sum;
	}

	private List<Long> extractBases(long candidate) {
		List<Long> bases = new ArrayList<Long>();
		String temp = Long.toString(candidate);

		for (int i = 0; i < temp.length(); i++) {
			String digit = temp.substring(i, i + 1);
			bases.add(Long.valueOf(digit));
		}

		return bases;
	}
}