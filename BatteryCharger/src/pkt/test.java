package pkt;

import java.net.URISyntaxException;
import java.util.Scanner;

import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Rule;


public class test {

	public static void main(String[] args) throws URISyntaxException {
		Scanner in=new Scanner(System.in);
		System.out.print("Pil Sicaklik Degeri: ");
		double PilSicaklik=in.nextDouble();
		System.out.print("Pil Voltaj Degeri: ");
		double PilVoltaj=in.nextDouble();
		BatteryCharger mod=new BatteryCharger(PilSicaklik,PilVoltaj);
		System.out.println(mod);
		for(Rule rule : mod.getModel().getFunctionBlock("BatteryChargerModel").getFuzzyRuleBlock("kuralblok").getRules() ) {
			if(rule.getDegreeOfSupport()>0) {
				System.out.println(rule);
			}
		}
		JFuzzyChart.get().chart(mod.getModel().getVariable("DolulukOran").getDefuzzifier(),"Doluluk Oranı",true);
		
	}

}
