package pkt;

import java.io.File;
import java.net.URISyntaxException;

import net.sourceforge.jFuzzyLogic.FIS;

public class BatteryCharger {
	private FIS fis;
	private double PilSicaklik;
	private double PilVoltaj;
	
	public BatteryCharger(double PilSicaklik,double PilVoltaj) throws URISyntaxException {
		
		this.PilSicaklik=PilSicaklik;
		this.PilVoltaj=PilVoltaj;
		
		File dosya=new File(getClass().getResource("BatteryChargerModel.fcl").toURI());
		
		fis=FIS.load(dosya.getPath());
		fis.setVariable("PilSicaklik", PilSicaklik);
		fis.setVariable("PilVoltaj", PilVoltaj);
		fis.evaluate();		
	}
	public FIS getModel() {
		return fis;
	}
	@Override
	public String toString() {
		String cikti;
		return cikti="Doluluk oranı:"+"%"+Math.round(fis.getVariable("DolulukOran").getValue());
	}
}
