package com.patterns.top.k.elements;

import java.util.Comparator;

public class ElementComparator implements Comparator<Element> {
	public int compare(Element e1, Element e2) {
		if (e1.frequency == e2.frequency)
			return e1.sequenceNumber - e2.sequenceNumber;
		
		return e1.frequency - e2.frequency;
	}
}
