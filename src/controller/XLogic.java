package controller;

import model.Lot;
import model.Projection;

public class XLogic {
	public double media(LotController list) {
		double media = 0;
		double div = 0;
		if (list == null) {
			return 0;
		} else {
			int index = 0;
			Lot lot;
			do{
				lot = list.getLot(index);
				if(lot!=null) {
					media += lot.getQtIn() - lot.getQtOut();
					div++;
				}
				index++;
			}while(lot!=null);
			media = media / div;
			return media;
		}
	}

	public Projection LogicaX(Projection element, double media) {
		if (element.getAverage() > media + 1) {
			System.out.println("Compra menos");
			element.setReport("Compra menos");
		} else if (element.getAverage() < media + 1) {
			System.out.println("Compra mais");
			element.setReport("Compra mais");
		}else {
			System.out.println("Mantenha o nível de compra");
			element.setReport("Mantenha o nível de compra");
		}
		return element;
	}
}
