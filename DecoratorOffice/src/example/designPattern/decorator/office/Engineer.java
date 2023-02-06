/**
 * 
 */
package example.designPattern.decorator.office;

/**
 * @author apetazzi
 * 
 */
public class Engineer implements Employee {

	private String name, office;

	public Engineer(String nam, String off) {
		name = nam;
		office = off;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see example.pattern.decorator.office.Employee#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getOffice() {
		return office;
	}

}
