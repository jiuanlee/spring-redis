/**
 * 
 */
package com.lambda.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import static java.util.Comparator.comparing;

/**
 * 行为参数化
 * 
 * @author jal
 *
 */
public class FilterApples {
	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple("green",
				new BigDecimal(80)), new Apple("red", new BigDecimal(155)),
				new Apple("green", new BigDecimal(165)));
		// 1.行为参数化
		// System.out.println(filterApples(inventory, new
		// ColorApplePredicate()));

		// 匿名内部类
		System.out.println(filterApples(inventory, new ApplePredicate() {
			@Override
			public boolean test(Apple apple) {
				return apple.getWeight().compareTo(new BigDecimal(150)) >= 0;
			}
		}));
		// lambda表达式
		System.out.println(filterApples(
				inventory,
				(Apple apple) -> new BigDecimal(150).compareTo(apple
						.getWeight()) <= 0 && "red".equals(apple.getColor())));

		// lambda 常用表达
		// Thread t = new Thread(() -> System.out.println("Hello lambda!!!"));
		// t.start();
		forEach(Arrays.asList(1, 2, 3, 4, 5), (Integer i) -> {
			System.out.println(i);
		});

		// 匿名内部类
		inventory.sort(new Comparator<Apple>() {
			public int compare(Apple a1, Apple a2) {
				return a1.getWeight().compareTo(a2.getWeight());
			}
		});
		// lambda 表达式
		inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(
				a2.getWeight()));
		// 方法引用
		inventory.sort(comparing(Apple::getWeight));
	}

	public static <T> void forEach(List<T> list, Consumer<T> c) {
		for (T i : list)
			c.accept(i);
	}

	public static List<Apple> filterApples(List<Apple> inventory,
			ApplePredicate p) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (p.test(apple))
				result.add(apple);
		}

		return result;
	}

}
