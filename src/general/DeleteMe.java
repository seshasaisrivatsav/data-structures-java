package general;

import java.text.DecimalFormat;

public class DeleteMe {
	public static void main(String[] args) {
		double a = 1;
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(9);
		System.out.println(df.format(a/18000));

	}
}
