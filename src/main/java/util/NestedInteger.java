package util;

import java.util.LinkedList;
import java.util.List;

public class NestedInteger {
	private Integer val;
	private List<NestedInteger> list = new LinkedList<>();

	public NestedInteger(){};
	public NestedInteger(int value){ this.val = value; };

	public boolean isInteger() { return val != null; }
	public Integer getInteger() { return val; }
	public void setInteger(int value) { this.val = value; }
	public void add(NestedInteger ni) { list.add(ni); }
	public List<NestedInteger> getList() { return list; }
}
